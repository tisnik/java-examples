/* Barebone JVM TI agent */

#include <jvmti.h>

#define AGENT_NAME "Agent1:"

#define MSG(message) puts(AGENT_NAME " " message)

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *jvm, char *options, void *reserved)
{
    MSG("Agent_OnLoad");
    return JNI_OK;
}

JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm)
{
    MSG("Agent_OnUnload");
}

