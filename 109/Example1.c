#include <stdio.h>
#include "Example1.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     Example1
 * Method:    foo
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Example1_foo(JNIEnv *env, jclass cls)
{
    puts("foo() called!");
}

#ifdef __cplusplus
}
#endif

