import java.util.List;

public class SortArray {

    public static void main(String[] args)
    {
        String[] array = {"first", "second", "third", "zzz", "aaa"};

        List<String> list1 = java.util.Arrays.asList(array);
        System.out.println(list1);

        java.util.Arrays.sort(array);

        List<String> list2 = java.util.Arrays.asList(array);
        System.out.println(list2);
    }
}

