package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheHandler implements InvocationHandler {

    private Object obj;
    private Map<List<Object>, Object> cache = new HashMap<>();
    CacheHandler(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getAnnotation(Cache.class) != null)
        {
            List<Object> argsList = Arrays.asList(args);
            if(cache.containsKey(argsList))
            {
                return cache.get(argsList);
            }else
            {
                Object rObj = method.invoke(obj, args);
                cache.put(argsList, rObj);
                return rObj;
            }
        }else
        {
            return method.invoke(obj, args);
        }
    }
}
