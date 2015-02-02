import java.util.Queue;
import java.util.ArrayDeque;

public class QueueToArray {

    public static void testQueueToArray(Queue<String> queue)
    {
        queue.add("first");
        queue.add("second");
        queue.add("third");

        Object[] array = queue.toArray();

        System.out.println("Array size: " + array.length);
        System.out.println("Array content:");
        for (Object o : array) {
            System.out.println("    " + o);
        }
    }

    public static void main(String[] args)
    {
        Queue<String> queue1 = new ArrayDeque<String>();
        testQueueToArray(queue1);
    }
}

