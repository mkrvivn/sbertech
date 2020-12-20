package CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;



public class CollectionUtilsExample {
    public static void run()
    {
        System.out.println("--------------Collection Utils Example------------");
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        List<Number> ln = CollectionUtils.newArrayList();
        CollectionUtils.addAll(ln, l);
        CollectionUtils.add(ln, 6.0);
        CollectionUtils.add(ln, 7.0);
        for(var n : ln)
            System.out.println(n);
        System.out.println("--------------indexOf Example------------");
        System.out.println(CollectionUtils.indexOf(ln, 2));
        System.out.println("--------------removeAll Example------------");
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        List<Double> l3 = new ArrayList<>();
        l3.add(6.0);
        CollectionUtils.removeAll(ln, l2);
        CollectionUtils.removeAll(ln, l3);
        for(var n : ln)
            System.out.println(n);
        System.out.println("--------------contains Any------------");
        l2.clear();
        l2.add(5);
        l2.add(6);
        System.out.println(CollectionUtils.containsAny(ln, l2));
        l2.add(3);
        System.out.println(CollectionUtils.containsAny(ln, l2));
        System.out.println("--------------contains range------------");
        List<CmpTest> cmpList = CollectionUtils.newArrayList();
        cmpList.add(new CmpTest(1, 1));
        cmpList.add(new CmpTest(1, 2));
        cmpList.add(new CmpTest(2, 1));
        cmpList.add(new CmpTest(2, 2));
        cmpList.add(new CmpTestInh(2, 2, 3));
        cmpList.add(new CmpTestInh(1, 1, 3));
        for(var e : CollectionUtils.range(cmpList, new CmpTest(0, 0), new CmpTestInh(2, 0, 0)))
            System.out.println(e);
        System.out.println("--------------contains range with comparator------------");
        for(var e : CollectionUtils.range(cmpList, new CmpTest(0, 0), new CmpTestInh(2, 0, 0), Comparator.naturalOrder()))
            System.out.println(e);
    }
}
