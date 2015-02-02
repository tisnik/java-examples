import java.util.Deque;
import java.util.ArrayDeque;

public class TestDeque {

    public static void main(String[] args)
    {
        Deque<String> deque = new ArrayDeque<String>();
        deque.addFirst("first");
        deque.addFirst("second");
        deque.addFirst("third");
        deque.addFirst("fourth");

        String s;
        while ((s=deque.poll()) != null) {
            System.out.println(s + "\t" + deque.size());
        }

        deque.addLast("first");
        deque.addLast("second");
        deque.addLast("third");
        deque.addLast("fourth");

        while ((s=deque.poll()) != null) {
            System.out.println(s + "\t" + deque.size());
        }

    }
}

