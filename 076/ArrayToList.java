import java.util.List;

public class ArrayToList {

    public static void main(String[] args)
    {
        String[] array = {"first", "second", "third"};
        List<String> list = java.util.Arrays.asList(array);
        System.out.println(list);
    }
}

