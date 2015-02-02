import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class TestSet {

    public static void testSet(Set<String> set)
    {
        set.add("first");
        set.add("second");
        set.add("third");
        for (String item : set) {
            System.out.println(item);
        }
        System.out.println("Set size: " + set.size());
        System.out.println("Contains 'first'?:  " + set.contains("first"));
        System.out.println("Contains 'second'?: " + set.contains("second"));
        System.out.println("Contains 'xyzzy'?:  " + set.contains("xyzzy"));
        set.remove("first");
    }

    public static void main(String[] args)
    {
        // the same interface, different implementations
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new TreeSet<String>();
        testSet(set1);
        testSet(set2);
    }
}

