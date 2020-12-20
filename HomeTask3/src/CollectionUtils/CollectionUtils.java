package CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }
    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }
    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }
    public static <T> boolean containsAll(List<T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }
    public static <T> boolean containsAny(List<T> c1, List<? extends T> c2) {
        return !Collections.disjoint(c1, c2);
    }
    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        return list.stream().filter(x -> (x.compareTo(max) < 0 && x.compareTo(min) > 0)).collect(Collectors.toList());
    }
    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> cmp) {
        return list.stream().filter(x -> (cmp.compare(x, max) < 0 && cmp.compare(x, min) > 0)).collect(Collectors.toList());
    }
}

