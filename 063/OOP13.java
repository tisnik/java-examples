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



/**
 * Access modifiers.
 */
class TestClass {
    int           x;
    public int    y;
    private int   z;
    protected int w;

    // this is constructor
    TestClass() {
        x = 1;
        y = 2;
        z = 3;
        w = 4;
    }

    void setX(int newValue) {
        x = newValue;
    }

    int getX() {
        return x;
    }

    void setY(int newValue) {
        y = newValue;
    }

    int getY() {
        return y;
    }

    void setZ(int newValue) {
        z = newValue;
    }

    int getZ() {
        return z;
    }

    void setW(int newValue) {
        w = newValue;
    }

    int getW() {
        return w;
    }

}

class OOP13 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();

        System.out.println(tc.getX());
        System.out.println(tc.getY());
        System.out.println(tc.getZ());
        System.out.println(tc.getW());

        tc.setX(10);
        tc.setY(20);
        tc.setZ(30);
        tc.setW(40);

        System.out.println(tc.getX());
        System.out.println(tc.getY());
        System.out.println(tc.getZ());
        System.out.println(tc.getW());

    }
}

