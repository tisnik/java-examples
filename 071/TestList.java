import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TestList {

    public static void testList(List<String> list)
    {
        list.add("first");
        list.add("second");
        list.add("third");
        for (String item : list) {
            System.out.println(item);
        }
        System.out.println("List size: " + list.size());
        System.out.println("Contains 'first'?:  " + list.contains("first"));
        System.out.println("Contains 'second'?: " + list.contains("second"));
        System.out.println("Contains 'xyzzy'?:  " + list.contains("xyzzy"));
        list.remove(1);
    }

    public static void main(String[] args)
    {
        // the same interface, different implementations
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();
        testList(list1);
        testList(list2);
    }
}

