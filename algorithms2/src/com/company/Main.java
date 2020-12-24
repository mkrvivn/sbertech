package com.company;

import ThreadPool.ThreadPool;
import Utility.Loops;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class Fact implements Callable<Integer>
{
    private Integer f;
    Fact(Integer f)
    {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        Integer res = 1;
        for(int i = 1; i <= this.f; i++)
            for(int j = 0; i <= 10000; i++)
                res += i;
        return res;
    }
}

public class Main {

    public static void main(String[] args) {
        ThreadPool<Integer> pool = new ThreadPool<Integer>(10);
        Queue<FutureTask<Integer>> tasks = new LinkedList<FutureTask<Integer>>();
        System.out.println("1");
        long start = System.currentTimeMillis();
        Loops.times(1000, index -> {
            tasks.add(pool.pushTask(new FutureTask<Integer>(new Fact(index + 1))));
        });
        System.out.println("2");
        tasks.forEach(t -> {
            try
            {
                t.get();
            }catch (Exception e)
            {
                System.out.println("error in future get");
            }
        });
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("done" + elapsedTime);
    }
}
