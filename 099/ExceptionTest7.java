import java.io.*;

public class ExceptionTest7 {

    public static void main(String[] args) {
        OutputStream out = null;
        try {
            out = new FileOutputStream("data.bin");
            for (int i = 'a'; i <= 'z'; i++) {
                out.write(i);
            }
            out.write(0);
            out.write(255);
            out.flush();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

