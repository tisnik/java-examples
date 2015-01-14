/**
 * Object construction and access to object's attribute.
 * Attribute initialization.
 */
class TestClass {
    int integerValue = 0;
}

class OOP4 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();      // object construction
        System.out.println(tc.integerValue); // read initial value from object attribute
        tc.integerValue = 42;                // set new value to object attribute
        System.out.println(tc.integerValue); // read new value from object attribute
    }
}

