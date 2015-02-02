import java.util.Queue;
import java.util.ArrayDeque;

public class TestQueue {

    public static void main(String[] args)
    {
        Queue<String> q = new ArrayDeque<String>();
        q.add("first");
        q.add("second");
        q.add("third");
        q.add("fourth");

        String s;
        while ((s=q.poll()) != null) {
            System.out.println(s + "\t" + q.size());
        }
    }
}

