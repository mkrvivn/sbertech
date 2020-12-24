package com.sbertech.utility;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ArrayIterator<T> implements Iterator<T> {

    private List<T> list;
    private int cur;
    public ArrayIterator(List<T> list)
    {
        this.list = list;
        this.cur = 0;
    }

    @Override
    public boolean hasNext() {
        return cur <= list.size() - 1;
    }

    @Override
    public T next() {
        return list.get(cur++);
    }

    @Override
    public void remove() {
        list.remove(cur);
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        while(hasNext())
        {
            action.accept(next());
        }
    }
}
