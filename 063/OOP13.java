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

