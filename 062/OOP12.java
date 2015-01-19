/**
 * this keyword in constructor.
 */
class TestClass {
    int x;

    // this is constructor
    TestClass() {
        this(1234);
    }

    // one parameter constructor
    TestClass(int initialValue) {
        x = initialValue;
    }

    void setX(int newValue) {
        x = newValue;
    }

    int getX() {
        return x;
    }

}

class OOP12 {
    public static void main(String[] args) {
        TestClass tc = new TestClass(-10000);  // object construction

        System.out.println(tc.getX());

        tc.setX(10);
        System.out.println(tc.getX());

        tc.setX(-1);
        System.out.println(tc.getX());

        TestClass tc2 = new TestClass();  // object construction

        System.out.println(tc2.getX());
    }
}

