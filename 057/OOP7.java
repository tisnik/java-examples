/**
 * Class with one method.
 */
class TestClass {
    int add(int x, int y) {
        int result = x + y;
        return result;
    }
}

class OOP7 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();      // object construction
        System.out.println(tc.add(1,2));
        System.out.println(tc.add(-1,0));
        System.out.println(tc.add(100,100));
    }
}

