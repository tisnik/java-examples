public class ExceptionTest4 {

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
        method4(null);
    }

}

