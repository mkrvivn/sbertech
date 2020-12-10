package Examples;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    static public void run()
    {
        List<String> l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        l.add("e");
        int pos = Utils.Search.BinarySearch.find(l, "c");
        System.out.println("position of \"c\" - " + String.valueOf(pos));
        l.add("g");
        pos = Utils.Search.BinarySearch.find(l, "f");
        System.out.println("position of \"f\" - " + String.valueOf(pos));
    }
}
