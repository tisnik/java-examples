/**
 * Class with two methods.
 */
class TestClass {

    int add(int x, int y) {
        int result = x + y;
        return result;
    }

    int sub(int x, int y) {
        return x - y;
    }
}

class OOP8 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();      // object construction
        System.out.println(tc.add(1,2));
        System.out.println(tc.add(-1,0));
        System.out.println(tc.add(100,100));
        System.out.println(tc.sub(1,2));
        System.out.println(tc.sub(-1,0));
        System.out.println(tc.sub(100,100));
    }
}

