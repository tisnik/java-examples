public class ExceptionTest3 {

    public static Class method3(String className) {
        try {
            return Class.forName(className);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        method3("xyzzy");
    }

}

