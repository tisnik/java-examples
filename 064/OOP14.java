/**
 * Inheritance
 */
class ParentTestClass {
    int x;

    // this is constructor
    ParentTestClass() {
        x = 1;
    }

    int getX() {
        return x;
    }
}

class ChildTestClass extends ParentTestClass {
    int y;

    // this is constructor
    ChildTestClass() {
        y = 2;
    }

    int getY() {
        return y;
    }
}

class OOP14 {
    public static void main(String[] args) {
        ParentTestClass parent = new ParentTestClass();

        System.out.println(parent.getX());

        ChildTestClass child = new ChildTestClass();

        System.out.println(child.getX());
        System.out.println(child.getY());

    }
}

