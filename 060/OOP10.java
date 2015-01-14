/**
 * Methods, attributes and constructor.
 */
class TestClass {
    int x;

    // this is constructor
    TestClass() {
        x = 1234;
    }

    void setX(int newValue) {
        x = newValue;
    }

    int getX() {
        return x;
    }

}

class OOP10 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();      // object construction

        System.out.println(tc.getX());

        tc.setX(10);
        System.out.println(tc.getX());

        tc.setX(-1);
        System.out.println(tc.getX());
    }
}

