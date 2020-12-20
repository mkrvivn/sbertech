package CountMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapExample {
    public static void run()
    {
        CountMap<String> cm = new CountMapImpl<String>();
        cm.add("a");
        cm.add("a");
        cm.add("b");
        cm.add("c");
        cm.add("c");
        cm.add("c");
        System.out.println("----------test of getCount and add----------");
        System.out.println("Count of c - " + String.valueOf(cm.getCount("c")));
        System.out.println("Count of d - " + String.valueOf(cm.getCount("d")));
        System.out.println("----------test of getCount and add----------");
        System.out.println("Count of c - " + String.valueOf(cm.remove("c")));
        System.out.println("Count of c - " + String.valueOf(cm.remove("c")));
        System.out.println("Count of c - " + String.valueOf(cm.remove("c")));
        System.out.println("Count of c - " + String.valueOf(cm.remove("c")));
        System.out.println("Count of c - " + String.valueOf(cm.remove("c")));
        System.out.println("----------test toMap()----------");
        cm.toMap().forEach((key, val) -> System.out.println(key + "  " + val));
        Map<String, Integer> m = new HashMap<>();
        System.out.println("----------test toMap(dest)----------");
        cm.toMap(m);
        m.forEach((key, val) -> System.out.println(key + "  " + val));
        System.out.println("----------test addAll----------");
        cm.addAll(cm);
        cm.toMap().forEach((key, val) -> System.out.println(key + "  " + val));
        cm.addAll(cm);
        cm.toMap().forEach((key, val) -> System.out.println(key + "  " + val));
    }

    public static void examplesFromPdf()
    {
        System.out.println("----------examplesFromPdf----------");
        CountMap<Integer> map = new CountMapImpl<Integer>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        map.toMap().forEach((key, val) -> System.out.println(key + "  " + val));
    }
}
