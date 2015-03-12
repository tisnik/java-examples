/*
 * Java programming language course examples.
 *
 * Copyright (c) 2015  Pavel Tisnovsky, Red Hat
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Red Hat nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Pavel Tisnovsky BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */



/* Method entry monitoring (w/ method signature) */

#include <stdlib.h>
#include <string.h>

#include <jvmti.h>

#define AGENT_NAME "Agent4:"

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

    capabilities.can_generate_method_entry_events = 1;

    error_code = (*jvmti)->AddCapabilities(jvmti, &capabilities);
    check_jvmti_error(jvmti, error_code, "Unable to get necessary JVMTI capabilities.");
    return error_code;
}

static void JNICALL callback_on_vm_init(jvmtiEnv *jvmti_env, JNIEnv* env, jthread thread)
{
    MSG("Got VM init event");
}

static void JNICALL callback_on_vm_death(jvmtiEnv *jvmti_env, JNIEnv* env)
{
    MSG("Got VM Death event");
}

static void JNICALL callback_on_method_entry(jvmtiEnv *jvmti, JNIEnv* env,
        jthread thread, jmethodID method)
{
    char *name_ptr;
    char *signature_ptr;

    enter_critical_section(jvmti);
    {
        /* MSG("Got Method Entry event"); */
        (*jvmti)->GetMethodName(jvmti, method, &name_ptr, &signature_ptr, NULL);
        printf("called method %s with signature %s\n", name_ptr, signature_ptr);
        (*jvmti)->Deallocate(jvmti, (unsigned char *)name_ptr);
        (*jvmti)->Deallocate(jvmti, (unsigned char *)signature_ptr);
    }
    exit_critical_section(jvmti);
}

jvmtiError register_all_callback_functions(jvmtiEnv *jvmti)
{
    jvmtiEventCallbacks callbacks;
    jvmtiError error_code;

    memset(&callbacks, 0, sizeof(callbacks));

    /* JVMTI_EVENT_VM_INIT */
    callbacks.VMInit = &callback_on_vm_init;

    /* JVMTI_EVENT_VM_DEATH */
    callbacks.VMDeath = &callback_on_vm_death;

    /* JVMTI_EVENT_METHOD_ENTRY */
    callbacks.MethodEntry = &callback_on_method_entry;

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

    if ((error_code = set_event_notification_mode(jvmti, JVMTI_EVENT_VM_INIT)) != JNI_OK)
    {
        return error_code;
    }

    if ((error_code = set_event_notification_mode(jvmti, JVMTI_EVENT_VM_DEATH)) != JNI_OK)
    {
        return error_code;
    }

    if ((error_code = set_event_notification_mode(jvmti, JVMTI_EVENT_METHOD_ENTRY)) != JNI_OK)
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

