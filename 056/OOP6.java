/**
 * Class with one method.
 */
class TestClass {
    void printInt(int x) {
        System.out.println("Called with the following argument: " + x);
    }
}

class OOP6 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();      // object construction
        tc.printInt(0);                      // method call
        tc.printInt(10);                     // method call
        tc.printInt(10000);                  // method call
    }
}

