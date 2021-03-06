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



public class Test8 {

    public static void method1() {
        int[] a = {1,2,3};
        try {
            a[-1] = 10;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int method2(int a, int b) {
        try {
            return a/b;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Class method3(String className) {
        try {
            return Class.forName(className);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String method4(Object object) {
        try {
            return object.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String throwSomeException(Object object) {
        return object.toString();
    }

    public static void methodX() {
        methodY();
    }

    public static void methodY() {
        methodZ();
    }

    public static void methodZ() {
        methodW();
    }

    public static void methodW() {
        throwSomeException(null);
    }

    public static void main(String[] args) {
        method1();
        method2(1, 0);
        method3("xyzzy");
        method4(null);
        methodX();
    }
}

