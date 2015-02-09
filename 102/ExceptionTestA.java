class MyException extends RuntimeException {
    public MyException(String s) {
        super(s);
    }
}

public class ExceptionTestA {

    public static void test(int x) throws MyException
    {
        if (x==0) {
            throw new MyException("I'm exceptional!");
        }
    }

    public static void main(String[] args) {
        test(10);
        test(0);
    }
}

