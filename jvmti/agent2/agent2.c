/* Check for JVM TI version */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <jvmti.h>

#define AGENT_NAME "Agent2:"

#define MSG(message) puts(AGENT_NAME " " message)

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *jvm, char *options, void *reserved)
{
    jvmtiEnv *jvmti = NULL;
    jint result;

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
    return JNI_OK;
}

JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm)
{
    MSG("Agent_OnUnload");
}

