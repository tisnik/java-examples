public class ExceptionTest8 {

    public static void test(int x) throws Exception
    {
        if (x==0) {
            throw new Exception("I'm exceptional!");
        }
    }

    public static void main(String[] args) {
        try {
            test(10);
            test(0);
        }
        catch (Exception e) {
            System.out.println("caught: " + e.getMessage());
        }

    }
}

