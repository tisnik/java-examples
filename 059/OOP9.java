/**
 * Methods and attributes.
 */
class TestClass {
    int x;

    void setX(int newValue) {
        x = newValue;
    }

    int getX() {
        return x;
    }

}

class OOP9 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();      // object construction

        tc.setX(10);
        System.out.println(tc.getX());

        tc.setX(-1);
        System.out.println(tc.getX());
    }
}

