import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class TestMap {

    public static void testMap(Map<String, String> map)
    {
        map.put("first",  "prvni");
        map.put("second", "druhy");
        map.put("third",  "treti");
        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println(item.getKey() + "\t->\t" + item.getValue());
        }
        System.out.println("Map size: " + map.size());
        System.out.println("Contains key 'first'?:   " + map.containsKey("first"));
        System.out.println("Contains key 'second'?:  " + map.containsKey("second"));
        System.out.println("Contains key 'xyzzy'?:   " + map.containsKey("xyzzy"));
        System.out.println("Contains value 'prvni'?: " + map.containsValue("prvni"));
        System.out.println("Contains value 'druhy'?: " + map.containsValue("druhy"));
        System.out.println("Contains value 'xyzzy'?: " + map.containsValue("xyzzy"));
    }

    public static void main(String[] args)
    {
        // the same interface, different implementations
        Map<String, String> map1 = new HashMap<String, String>();
        Map<String, String> map2 = new TreeMap<String, String>();
        testMap(map1);
        testMap(map2);
    }
}

