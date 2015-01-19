/**
 * Inheritance and RTTI: getClass(), Class.getName(), Class.getSuperclass().
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

class OOP20 {
    public static void main(String[] args) {
        Object o1 = new ParentTestClass();
        Object o2 = new ChildTestClass1();
        Object o3 = new ChildTestClass2();
        Object o4 = new ChildChildTestClass1();
        Object o5 = new ChildChildTestClass2();
        System.out.println();

        System.out.println(o1.getClass().getName());
        System.out.println(o2.getClass().getName());
        System.out.println(o3.getClass().getName());
        System.out.println(o4.getClass().getName());
        System.out.println(o5.getClass().getName());

        System.out.println();

        System.out.println(o1.getClass().getSuperclass().getName());
        System.out.println(o2.getClass().getSuperclass().getName());
        System.out.println(o3.getClass().getSuperclass().getName());
        System.out.println(o4.getClass().getSuperclass().getName());
        System.out.println(o5.getClass().getSuperclass().getName());

    }
}

