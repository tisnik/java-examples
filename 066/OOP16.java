/**
 * Inheritance and constructors.
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

class OOP16 {
    public static void main(String[] args) {
        ParentTestClass parent = new ParentTestClass();
        System.out.println(parent);
        System.out.println();

        ChildTestClass1 child1 = new ChildTestClass1();
        System.out.println(child1);
        System.out.println();

        ChildTestClass2 child2 = new ChildTestClass2();
        System.out.println(child2);
        System.out.println();
    }
}

