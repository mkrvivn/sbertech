package com.sbertech.utility;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayIteratorTest {

    List<String> array;

    @Mock
    ArrayIterator<String> myIt;

    @Before
    public void setUp() {
        array = new ArrayList<String>();
        array.add("a");
        array.add("b");
        array.add("c");
    }

    @After
    public void tearDown() {
        array = null;
    }


    @Test
    public void copyTest() {
        List<String> ls = new ArrayList<String>();
        Iterator<String> i = new ArrayIterator<>(array);
        while(i.hasNext())
        {
            ls.add(i.next());
        }
        assertEquals(ls.toString(), "[a, b, c]");
    }

    @Test
    public void zeroArrayTest() {
        List<String> ls = new ArrayList<String>();
        Iterator<String> i = new ArrayIterator<>(new ArrayList<String>());
        while(i.hasNext())
        {
            ls.add(i.next());
        }
        assertEquals(ls.toString(), "[]");
    }

    @Test
    public void forEachRemainingTest() {
        List<String> ls = new ArrayList<String>();
        Iterator<String> i = new ArrayIterator<>(array);
        i.forEachRemaining((e) -> ls.add(e + "1"));
        assertEquals(ls.toString(), "[a1, b1, c1]");
    }

    @Test
    public void removeTest() {
        List<String> ls = new ArrayList<String>();
        Iterator<String> i = new ArrayIterator<>(array);
        i.next();
        i.remove();
        i = new ArrayIterator<>(array);
        while(i.hasNext())
        {
            ls.add(i.next());
        }
        assertEquals(ls.toString(), "[a, c]");
    }


}
