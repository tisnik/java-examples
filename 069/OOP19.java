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
 * Inheritance, RTTI and instanceof operator.
 */
class ParentTestClass {
    // this is constructor
    ParentTestClass() {
        System.out.println("ParentTestClass() called.");
    }

    public String toString() {
        return "This is ParentTestClass";
    }
}

class ChildTestClass1 extends ParentTestClass {
    // this is constructor
    ChildTestClass1() {
        System.out.println("ChildTestClass1() called.");
    }

    public String toString() {
        return "This is ChildTestClass1";
    }
}

class ChildChildTestClass1 extends ChildTestClass1 {
    // this is constructor
    ChildChildTestClass1() {
        System.out.println("ChildChildTestClass1() called.");
    }

    public String toString() {
        return "This is ChildChildTestClass1";
    }
}

class ChildTestClass2 extends ParentTestClass {
    // this is constructor
    ChildTestClass2() {
        System.out.println("ChildTestClass2() called.");
    }

    public String toString() {
        return "This is ChildTestClass2";
    }
}

class ChildChildTestClass2 extends ChildTestClass2 {
    // this is constructor
    ChildChildTestClass2() {
        System.out.println("ChildChildTestClass2() called.");
    }

    public String toString() {
        return "This is ChildChildTestClass2";
    }
}

class OOP19 {
    public static void main(String[] args) {
        Object o1 = new ParentTestClass();
        Object o2 = new ChildTestClass1();
        Object o3 = new ChildTestClass2();
        Object o4 = new ChildChildTestClass1();
        Object o5 = new ChildChildTestClass2();

        System.out.println(o1 instanceof ParentTestClass);
        System.out.println(o2 instanceof ParentTestClass);
        System.out.println(o3 instanceof ParentTestClass);
        System.out.println(o4 instanceof ParentTestClass);
        System.out.println(o5 instanceof ParentTestClass);
        System.out.println();

        System.out.println(o1 instanceof ChildTestClass1);
        System.out.println(o2 instanceof ChildTestClass1);
        System.out.println(o3 instanceof ChildTestClass1);
        System.out.println(o4 instanceof ChildTestClass1);
        System.out.println(o5 instanceof ChildTestClass1);
        System.out.println();

        System.out.println(o1 instanceof ChildTestClass2);
        System.out.println(o2 instanceof ChildTestClass2);
        System.out.println(o3 instanceof ChildTestClass2);
        System.out.println(o4 instanceof ChildTestClass2);
        System.out.println(o5 instanceof ChildTestClass2);
        System.out.println();

    }
}

