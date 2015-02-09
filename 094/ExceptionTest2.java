public class ExceptionTest2 {

    public static int method2(int a, int b) {
        try {
            return a/b;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        method2(1, 0);
    }

}

