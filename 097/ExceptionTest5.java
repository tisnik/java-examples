import java.io.*;

public class ExceptionTest5 {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("ExceptionTest5.java");
            InputStream input  = new FileInputStream(file);
            Reader      reader = new InputStreamReader(input);
            bufferedReader     = new BufferedReader(reader);
            String line;
            while ((line=bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

