/**
 * Inheritance: instance of child class can be used instead of instance of parent class.
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

class ChildTestClass2 extends ParentTestClass {
    // this is constructor
    ChildTestClass2() {
        System.out.println("ChildTestClass2() called.");
    }

    public String toString() {
        return "This is ChildTestClass2";
    }
}

class OOP17 {
    public static void main(String[] args) {
        ParentTestClass[] arrayOfObjects = new ParentTestClass[3];

        arrayOfObjects[0] = new ParentTestClass();
        System.out.println();
        arrayOfObjects[1] = new ChildTestClass1();
        System.out.println();
        arrayOfObjects[2] = new ChildTestClass2();
        System.out.println();

        System.out.println();

        for (ParentTestClass o : arrayOfObjects) {
            System.out.println(o);
        }
    }
}

