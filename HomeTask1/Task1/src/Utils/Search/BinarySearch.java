package Utils.Search;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<T>> int find(@NotNull List<T> list, T val)
    {
        int lhv = 0, middle = 0, rhv = list.size() - 1;
        while(lhv <= rhv)
        {
            middle = (lhv + rhv) / 2;
            int cmp = list.get(middle).compareTo(val);
            if(cmp < 0)
                lhv = middle + 1;
            if(cmp > 0)
                rhv = middle - 1;
            if(cmp == 0)
                return middle;
        }
        return -1;
    }
}
