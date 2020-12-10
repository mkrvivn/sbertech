package Examples;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BubbleSort {
    static public void run()
    {
        List<String> l = new ArrayList<>();
        l.add("asf");
        l.add("fsdhg");
        l.add("dsg");
        l.add("sgdfsg");
        l.add("sdgs");
        Utils.Sorts.BubbleSort.bubbleSort(l);
        System.out.println(l);
        Utils.Sorts.BubbleSort.bubbleSort(l, Comparator.reverseOrder());
        System.out.println(l);
    }
}
