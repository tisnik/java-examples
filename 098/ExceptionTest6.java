import java.io.*;

public class ExceptionTest6 {

    public static void method1() {
        try {
            BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream("ExceptionTest6.java")
                            )
                        );
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method1();
    }
}

