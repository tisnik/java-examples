public class Test7 {

    public static void method1() {
        int[] a = {1,2,3};
        try {
            a[-1] = 10;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int method2(int a, int b) {
        try {
            return a/b;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Class method3(String className) {
        try {
            return Class.forName(className);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String method4(Object object) {
        try {
            return object.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        method1();
        method2(1, 0);
        method3("xyzzy");
        method4(null);
    }
}

