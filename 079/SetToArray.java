import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class SetToArray {

    public static void testSetToArray(Set<String> set)
    {
        set.add("first");
        set.add("second");
        set.add("third");

        Object[] array = set.toArray();

        System.out.println("Array size: " + array.length);
        System.out.println("Array content:");
        for (Object o : array) {
            System.out.println("    " + o);
        }
    }

    public static void main(String[] args)
    {
        // the same interface, different implementations
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new TreeSet<String>();
        testSetToArray(set1);
        testSetToArray(set2);
    }
}

