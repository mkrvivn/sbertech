package com.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream<T> {

    private Collection<Object> holdedCollection;
    private LinkedList<LinkedList<Predicate<? super Object>>> filters = new LinkedList<>();
    private LinkedList<Function<Object, Object>> transforms = new LinkedList<>();

    protected Stream(Collection<T> collection)
    {
        this.holdedCollection = (Collection<Object>) collection;
    }

    protected Stream(Stream<T> stream)
    {
        this.holdedCollection = stream.holdedCollection;
        this.filters = stream.filters;
        this.transforms = stream.transforms;
    }

    public Stream<T> filter(Predicate<? super T> predicate)
    {
        var filterPack = this.filters.peek();
        filterPack.add((Predicate<? super Object>) predicate);
        return this;
    }

    public <R> Stream<R> transform(Function<? super T,? extends R> mapper)
    {
        this.filters.add(new LinkedList<>());
        transforms.add((Function<Object, Object>) mapper);
        return new Stream<R>((Stream<R>) this);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, K> key, Function<? super T, V > value)
    {
        Map<K, V> m = new HashMap<>();

        var it = this.holdedCollection.iterator();
        while(it.hasNext()){
            boolean shouldSkip = false;
            Object obj = it.next();
            for(int i  = 0; i <= transforms.size(); i++)
            {
                for(Predicate<? super Object> filter : filters.get(i))
                {
                    if(!filter.test(obj))
                    {
                        shouldSkip = true;
                        break;
                    }
                }
                if(shouldSkip)
                {
                    break;
                }else {
                    if(transforms.size() > i)
                    {
                        var tf = transforms.get(i);
                        obj = tf.apply(obj);
                    }
                }
            }
            if(!shouldSkip)
            {
                m.put(key.apply((T)obj), value.apply((T)obj));
            }
        }
        return m;

    }

    public static <T> Stream<T> of(Collection<T> collection)
    {
        Stream<T> s = new Stream<T>(collection);
        s.filters.add(new LinkedList<>());
        return s;
    }
}
