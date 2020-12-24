package ThreadPool;

import Utility.Loops;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

class SyncThread<T> extends Thread
{
    private Queue<SyncThread<T>> pool;
    private BlockingQueue<FutureTask<T>> tasks;
    private AtomicBoolean closed;

    SyncThread(Queue<SyncThread<T>> p, BlockingQueue<FutureTask<T>> t, AtomicBoolean closed)
    {
        this.pool = p;
        this.tasks = t;
        this.closed = closed;
    }



    @Override
    public void run() {
        while(!closed.get())
        {
            if(!tasks.isEmpty())
            {
                try{
                    FutureTask<T> toDo = tasks.take();
                    toDo.run();
                }catch (Exception e)
                {
                    System.out.println("take exception");
                }
            }
            try
            {
                sleep(10);
            }catch (Exception e)
            {
                System.out.println("exception in sleep");
            };
        }
        System.out.println("after run");
    }
}

public class ThreadPool<T> {
    private Queue<SyncThread<T>> pool;
    private BlockingQueue<FutureTask<T>> tasks;
    private int size;
    private AtomicBoolean closed;
    public ThreadPool(int size)
    {
        closed = new AtomicBoolean(false);
        pool = new LinkedList<SyncThread<T>>();
        tasks = new LinkedBlockingQueue<>();
        this.size = size;
        Loops.times(size, (i)->pool.add(new SyncThread<T>(this.pool, this.tasks, closed)));
        pool.forEach(t -> t.start());
    }

    public FutureTask<T> pushTask(FutureTask<T> task)
    {
        try
        {
            tasks.put(task);
        }catch (Exception e)
        {
            System.out.println("exception in pushTask");
        }
        return task;
    }

    public void close()
    {
        this.closed.set(true);
        pool.forEach(t-> {
            try{
                t.join();
            }catch (Exception e)
            {
                System.out.println("exception in close");
            }
        });
    }


}
