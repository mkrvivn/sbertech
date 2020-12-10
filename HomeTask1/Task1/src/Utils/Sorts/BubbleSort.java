package Utils.Sorts;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class BubbleSort {


    //Sorts the specified range of the array into ascending order.
    public static <T extends Comparable<T>> void bubbleSort(@NotNull List<T> list)
    {
        BubbleSort.bubbleSort(list, Comparator.<T>naturalOrder());
    }

    //Sorts the specified array of objects according to the order induced by the specified comparator.
    public static <T extends Comparable<?>> void bubbleSort(@NotNull List<T> list, @NotNull Comparator<T> cmp)
    {
        for(int i = 1; i < list.size(); i++)
        {
            boolean isAlreadySorted = true;
            for(int j = 0; j < list.size() - i; j++)
            {
                T item1 = list.get(j);
                T item2 = list.get(j + 1);
                int cmpVal = cmp.compare(item1, item2);
                if( cmpVal > 0)
                {
                    isAlreadySorted = false;
                    list.set(j, item2);
                    list.set(j + 1, item1);
                }
            }
            if(isAlreadySorted)
                break;
        }
    }
}
