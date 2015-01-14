/**
 * Class with one method.
 */
class TestClass {
    void helloWorld() {
        System.out.println("Hello world!");
    }
}

class OOP5 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();      // object construction
        tc.helloWorld();                     // method call
    }
}

