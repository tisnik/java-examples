/**
 * Object construction and access to object's attribute.
 */
class TestClass {
    int integerValue;
}

class OOP3 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();      // object construction
        tc.integerValue = 42;                // set new value to object attribute
        System.out.println(tc.integerValue); // read value from object attribute
    }
}

