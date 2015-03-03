/* Exception catch monitoring */

#include <stdlib.h>
#include <string.h>

#include <jvmti.h>

#define AGENT_NAME "Agent6:"

#define MSG(message) puts(AGENT_NAME " " message)

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

jvmtiError set_capabilities(jvmtiEnv *jvmti)
{
    jvmtiCapabilities capabilities;
    jvmtiError error_code;

    memset(&capabilities, 0, sizeof(jvmtiCapabilities));

    capabilities.can_generate_exception_events = 1;

    error_code = (*jvmti)->AddCapabilities(jvmti, &capabilities);
    check_jvmti_error(jvmti, error_code, "Unable to get necessary JVMTI capabilities.");
    return error_code;
}

static void JNICALL callback_on_exception_catch(
            jvmtiEnv *jvmti_env,
            JNIEnv *jni_env,
            jthread thr,
            jmethodID method,
            jlocation location,
            jobject exception_object)
{
    printf(AGENT_NAME " An exception is caught\n");
}

jvmtiError register_all_callback_functions(jvmtiEnv *jvmti)
{
    jvmtiEventCallbacks callbacks;
    jvmtiError error_code;

    memset(&callbacks, 0, sizeof(callbacks));

    /* JVMTI_EVENT_EXCEPTION_CATCH */
    callbacks.ExceptionCatch = &callback_on_exception_catch;

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

    if ((error_code = set_event_notification_mode(jvmti, JVMTI_EVENT_EXCEPTION_CATCH)) != JNI_OK)
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

    return JNI_OK;
}

JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm)
{
    MSG("Agent_OnUnload");
}

