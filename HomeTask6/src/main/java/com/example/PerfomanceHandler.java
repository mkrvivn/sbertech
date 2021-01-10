package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Handler;

import static java.lang.Thread.sleep;

public class PerfomanceHandler implements InvocationHandler {

    Object obj;

    PerfomanceHandler(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object rValue;
        if(method.getAnnotation(Metric.class) != null)
        {
            long m = System.currentTimeMillis();
            rValue = method.invoke(obj, args);
            System.out.println("time of work is - " + (double) (System.currentTimeMillis() - m) + "ms for method: " + method.getName());
        }else
        {
            rValue = method.invoke(obj, args);
        }

        return rValue;
    }
}
