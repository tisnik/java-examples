import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListToArray {

    public static void testListToArray(List<String> list)
    {
        list.add("first");
        list.add("second");
        list.add("third");

        Object[] array = list.toArray();

        System.out.println("Array size: " + array.length);
        System.out.println("Array content:");
        for (Object o : array) {
            System.out.println("    " + o);
        }
    }

    public static void main(String[] args)
    {
        // the same interface, different implementations
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();
        testListToArray(list1);
        testListToArray(list2);
    }
}

