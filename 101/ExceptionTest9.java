public class ExceptionTest9 {

    public static void test1(int x) throws Exception
    {
        if (x==0) {
            throw new Exception("I'm exceptional!");
        }
    }

    public static void test2(int x) throws Exception
    {
        test1(x);
    }

    public static void test3(int x) throws Exception
    {
        test2(x);
    }

    public static void test4(int x) throws Exception
    {
        test3(x);
    }

    public static void main(String[] args) {
        try {
            test4(10);
            test4(0);
        }
        catch (Exception e) {
            System.out.println("caught: " + e.getMessage());
            e.printStackTrace();
        }

    }
}

