/*
 * Catched and uncatched exceptions monitoring.
 */

#include <stdlib.h>
#include <string.h>

#include <jvmti.h>

#define AGENT_NAME "Agent8:"

#define MSG(message) puts(AGENT_NAME " " message)

jrawMonitorID  global_lock;


static void print_jvmti_error(jvmtiEnv *jvmti, jvmtiError error_code, const char *str)
{
    char *error_code_str = NULL;
    const char *msg_str = str == NULL ? "" : str;
    char *msg_err = NULL;

    (*jvmti)->GetErrorName(jvmti, error_code, &error_code_str);
    msg_err = error_code_str == NULL ? "Unknown" : error_code_str;
    printf(AGENT_NAME " ERROR: JVMTI: %d(%s): %s\n", error_code, msg_err, msg_str);
}

static void check_jvmti_error(jvmtiEnv *jvmti, jvmtiError error_code, const char *str)
{
    if ( error_code != JVMTI_ERROR_NONE )
    {
        print_jvmti_error(jvmti, error_code, str);
    }
}

jvmtiError create_raw_monitor(jvmtiEnv *jvmti)
{
    jvmtiError error_code;

    error_code = (*jvmti)->CreateRawMonitor(jvmti, "agent data", &global_lock);
    check_jvmti_error(jvmti, error_code, "Cannot create raw monitor");

    return error_code;
}

static void enter_critical_section(jvmtiEnv *jvmti)
{
    jvmtiError error_code;

    error_code = (*jvmti)->RawMonitorEnter(jvmti, global_lock);
    check_jvmti_error(jvmti, error_code, "Cannot enter with raw monitor");
}

static void exit_critical_section(jvmtiEnv *jvmti)
{
    jvmtiError error_code;

    error_code = (*jvmti)->RawMonitorExit(jvmti, global_lock);
    check_jvmti_error(jvmti, error_code, "Cannot exit with raw monitor");
}

jvmtiError set_capabilities(jvmtiEnv *jvmti)
{
    jvmtiCapabilities capabilities;
    jvmtiError error_code;

    memset(&capabilities, 0, sizeof(jvmtiCapabilities));

    capabilities.can_generate_exception_events = 1;
    capabilities.can_get_line_numbers = 1;

    error_code = (*jvmti)->AddCapabilities(jvmti, &capabilities);
    check_jvmti_error(jvmti, error_code, "Unable to get necessary JVMTI capabilities.");
    return error_code;
}

char* update_class_name(char *class_name_ptr, char replace_to)
{
    char *class_name_ptr_;
    char *c;
    if (class_name_ptr != NULL)
    {
        class_name_ptr_ = class_name_ptr;
        if (class_name_ptr_[0] == 'L')
        {
            class_name_ptr_++;
        }
        char *last_char = class_name_ptr_ + strlen(class_name_ptr_) - 1;
        if (*last_char == ';')
        {
            *last_char = replace_to;
        }
        c = class_name_ptr_;
        for (c = class_name_ptr_; *c != 0; c++)
        {
            if (*c == '/') *c = '.';
        }
    }
    return class_name_ptr_;
}

int get_line_number(jvmtiEnv *jvmti_env, jmethodID method, jlocation location)
{
    int count;
    int line_number = 0;
    int i;
    jvmtiLineNumberEntry *location_table;
    jvmtiError error_code;

    if (method == NULL)
    {
        return -1;
    }

    error_code = (*jvmti_env)->GetLineNumberTable(jvmti_env, method, &count, &location_table);
    if (error_code != JVMTI_ERROR_NONE)
    {
        return -1;
    }

    for (i = 0; i < count - 1; i++)
    {
        jvmtiLineNumberEntry entry1 = location_table[i];
        jvmtiLineNumberEntry entry2 = location_table[i+1];
        if (location >= entry1.start_location && location < entry2.start_location)
        {
            line_number = entry1.line_number;
            break;
        }
    }
    if (location >= location_table[count-1].start_location)
    {
        line_number = location_table[count-1].line_number;
    }

    (*jvmti_env)->Deallocate(jvmti_env, (unsigned char *)location_table);
    return line_number;
}

void print_stack_trace(
            jvmtiEnv *jvmti_env,
            jthread   thr)
{
    jvmtiFrameInfo *stack_frames;
    jclass declaring_class;
    int count;
    char *method_name_ptr;
    char *method_signature_ptr;
    char *class_name_ptr;
    char *updated_class_name_ptr;
    int malloc_size;
    int frame_count;
    int i;

    (*jvmti_env)->GetFrameCount(jvmti_env, thr, &frame_count);
    printf("Stack Trace Depth: %d\n", frame_count);
    malloc_size = frame_count * sizeof(jvmtiFrameInfo);
    stack_frames = (jvmtiFrameInfo*)malloc(malloc_size);
    printf("(allocated %d bytes at address %p for storing stack frames info)\n", malloc_size, stack_frames);

    (*jvmti_env)->GetStackTrace(jvmti_env, thr, 0, frame_count, stack_frames, &count);
    if (count == 1)
    {
        printf("No stack trace!\n");
    }
    printf("Exception Stack Trace\n");
    for (i = 0; i < count; i++) {
        int line_number;
        jvmtiFrameInfo stack_frame = stack_frames[i];

        (*jvmti_env)->GetMethodName(jvmti_env, stack_frame.method, &method_name_ptr, &method_signature_ptr, NULL);
        (*jvmti_env)->GetMethodDeclaringClass(jvmti_env, stack_frame.method, &declaring_class);
        (*jvmti_env)->GetClassSignature(jvmti_env, declaring_class, &class_name_ptr, NULL);

        updated_class_name_ptr = update_class_name(class_name_ptr, '.');

        line_number = get_line_number(jvmti_env, stack_frame.method, stack_frame.location);

        if (line_number >= 0)
        {
            printf("\tat %s%s(line:%d)\n", updated_class_name_ptr, method_name_ptr, line_number);
        }
        else
        {
            printf("\tat %s%s(unknown location)\n", updated_class_name_ptr, method_name_ptr);
        }

        (*jvmti_env)->Deallocate(jvmti_env, (unsigned char*)method_name_ptr);
        (*jvmti_env)->Deallocate(jvmti_env, (unsigned char*)method_signature_ptr);
        (*jvmti_env)->Deallocate(jvmti_env, (unsigned char*)class_name_ptr);
    }
    free(stack_frames);
}

static void JNICALL callback_on_exception(
            jvmtiEnv *jvmti_env,
            JNIEnv   *jni_env,
            jthread   thr,
            jmethodID method,
            jlocation location,
            jobject   exception_object,
            jmethodID catch_method,
            jlocation catch_location)
{
    char *method_name_ptr;
    char *method_signature_ptr;
    char *class_name_ptr;
    char *updated_class_name_ptr;
    char *exception_name_ptr;
    char *updated_exception_name_ptr;
    jclass method_class;
    jclass exception_class;
    int line_number;

    enter_critical_section(jvmti_env);

    exception_class = (*jni_env)->GetObjectClass(jni_env, exception_object);

    (*jvmti_env)->GetMethodName(jvmti_env, method, &method_name_ptr, &method_signature_ptr, NULL);
    (*jvmti_env)->GetMethodDeclaringClass(jvmti_env, method, &method_class);
    (*jvmti_env)->GetClassSignature(jvmti_env, method_class, &class_name_ptr, NULL);
    (*jvmti_env)->GetClassSignature(jvmti_env, exception_class, &exception_name_ptr, NULL);

    updated_class_name_ptr = update_class_name(class_name_ptr, '.');
    updated_exception_name_ptr = update_class_name(exception_name_ptr, ' ');

    line_number = get_line_number(jvmti_env, method, location);

    printf(AGENT_NAME " %scatch exception of type %s\n",
            catch_method == NULL ? "un" : "",
            updated_exception_name_ptr);
    printf("    generated in method %s%s() at ",
            updated_class_name_ptr,
            method_name_ptr);
    if (line_number == -1)
    {
        printf("unknown location\n");
    }
    else
    {
        printf("line %d\n", line_number);
    }

    if (catch_method == NULL)
    {
        print_stack_trace(jvmti_env, thr);
    }

    (*jvmti_env)->Deallocate(jvmti_env, (unsigned char *)method_name_ptr);
    (*jvmti_env)->Deallocate(jvmti_env, (unsigned char *)method_signature_ptr);
    (*jvmti_env)->Deallocate(jvmti_env, (unsigned char *)class_name_ptr);
    (*jvmti_env)->Deallocate(jvmti_env, (unsigned char *)exception_name_ptr);

    exit_critical_section(jvmti_env);
}

jvmtiError register_all_callback_functions(jvmtiEnv *jvmti)
{
    jvmtiEventCallbacks callbacks;
    jvmtiError error_code;

    memset(&callbacks, 0, sizeof(callbacks));

    /* JVMTI_EVENT_EXCEPTION */
    callbacks.Exception = &callback_on_exception;

    error_code = (*jvmti)->SetEventCallbacks(jvmti, &callbacks, (jint)sizeof(callbacks));
    check_jvmti_error(jvmti, error_code, "Cannot set JVM TI callbacks");
    return error_code;
}

jvmtiError set_event_notification_mode(jvmtiEnv *jvmti, int event)
{
    jvmtiError error_code;

    error_code = (*jvmti)->SetEventNotificationMode(jvmti, JVMTI_ENABLE, event, (jthread)NULL);
    check_jvmti_error(jvmti, error_code, "Cannot set event notification");
    return error_code;
}

jvmtiError set_event_notification_modes(jvmtiEnv *jvmti)
{
    jvmtiError error_code;

    if ((error_code = set_event_notification_mode(jvmti, JVMTI_EVENT_EXCEPTION)) != JNI_OK)
    {
        return error_code;
    }

    return error_code;
}

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *jvm, char *options, void *reserved)
{
    jvmtiEnv *jvmti = NULL;
    jint result;
    jvmtiError error_code;

    MSG("Agent_OnLoad");
    result = (*jvm)->GetEnv(jvm, (void **) &jvmti, JVMTI_VERSION_1_0);
    if (result != JNI_OK || jvmti == NULL)
    {
        printf("ERROR: Unable to access JVMTI Version 1 (0x%x),"
                " is your J2SE a 1.5 or newer version? JNIEnv's GetEnv() returned %d\n",
                JVMTI_VERSION_1, (int)result);
        return result;
    }
    MSG("JVM TI version is correct");

    if ((error_code = set_capabilities(jvmti)) != JNI_OK)
    {
        return error_code;
    }

    if ((error_code = register_all_callback_functions(jvmti)) != JNI_OK)
    {
        return error_code;
    }

    if ((error_code = set_event_notification_modes(jvmti)) != JNI_OK)
    {
        return error_code;
    }

    if ((error_code = create_raw_monitor(jvmti)) != JNI_OK)
    {
        return error_code;
    }

    return JNI_OK;
}

JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm)
{
    MSG("Agent_OnUnload");
}

