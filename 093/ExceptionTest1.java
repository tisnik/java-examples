public class ExceptionTest1 {

    public static void method1() {
        int[] a = {1,2,3};
        try {
            a[-1] = 10;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method1();
    }

}

