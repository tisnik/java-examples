/**
 * Inheritance
 */
class ParentTestClass {
    // this is constructor
    ParentTestClass() {
    }

    public String toString() {
        return "This is ParentTestClass";
    }
}

class ChildTestClass extends ParentTestClass {
    // this is constructor
    ChildTestClass() {
    }

    public String toString() {
        return "This is ChildTestClass";
    }
}

class OOP15 {
    public static void main(String[] args) {
        ParentTestClass parent = new ParentTestClass();
        System.out.println(parent);

        ChildTestClass child = new ChildTestClass();
        System.out.println(child);
    }
}

