public class Test4 {

    public static void method1(String s1, String s2) {
        method2(s1 + " " + s2);
    }

    public static void method2(String s) {
        method3(s);
    }

    public static void method3(String s) {
        System.err.println(s);
    }

    public static void main(String[] args) {
        method1("Hello", "world");
        method1("Hello", "world");
    }
}

