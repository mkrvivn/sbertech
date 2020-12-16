package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class BackwardIterableList<T> extends ArrayList<T> {
    @Override
    public Iterator<T> iterator() {
        return new BackwardIterator<T>();
    }

    class BackwardIterator<TT> implements Iterator<T>
    {
        int cursor = size() - 1;

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer action) {
            while(hasNext())
                action.accept(next());
        }

        @Override
        public boolean hasNext()  {
            return cursor >= 0;
        }

        @Override
        public T next() {
            return get(cursor--);
        }
    }
}
