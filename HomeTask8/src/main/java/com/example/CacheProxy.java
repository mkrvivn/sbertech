package com.example;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheProxy implements InvocationHandler {

    private Object obj;
    private Map<List<Object>, Object> cachedData = new HashMap<>();
    private Integer currentIteration = 0;
    CacheProxy(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(currentIteration == 0)
        {
            try
            {
                loadFromDisk(method);
            }catch (Throwable e)
            {

            }
        }
        currentIteration++;
        if(isCacheAnnotated(method))
        {
            List<Object> filteredArgs = argsFilter(method, args);
            var cachedValue = cachedData.get(filteredArgs);
            if(cachedValue != null)
            {
                return cachedValue;
            }else
            {
                Object rValue = method.invoke(this.obj, args);
                cachedData.put(filteredArgs, rValue);
                cachedValue = rValue;
            }
            if(shouldSaveOnDisk(method) && this.currentIteration % method.getAnnotation(Cache.class).cacheFrequency() == 0)
            {
                this.saveOnDisk(method);
            }
            return cachedValue;


        }else
        {
            return method.invoke(this.obj, args);
        }
    }


    /**
     * returns List<Object> of args which wasn't annotated with @Exclude
     */
    private List<Object> argsFilter(Method method, Object[] args)
    {
        List<Object> filteredArgs = new ArrayList<>();
        var parameterAnnotations = method.getParameterAnnotations();
        for(int i = 0; i < parameterAnnotations.length; i++)
        {
            boolean shouldAdd = true;
            for(var annotation : parameterAnnotations[i])
            {
                if(annotation instanceof Exclude)
                {
                    shouldAdd = false;
                    break;
                }
            }
            if(shouldAdd)
            {
                filteredArgs.add(args[i]);
            }
        }
        return filteredArgs;
    }

    private boolean isCacheAnnotated(Method method)
    {
        if(method.getAnnotation(Cache.class) != null)
        {
            return true;
        }else
        {
            return false;
        }
    }

    private boolean shouldSaveOnDisk(Method method)
    {
        var cacheAnnotation = method.getAnnotation(Cache.class);
        if(cacheAnnotation != null)
        {
            return cacheAnnotation.persistence();
        }else
        {
            return false;
        }
    }

    private void saveOnDisk(Method method) throws IOException {
        boolean canPerformSerialization = true;
        for(var entry : this.cachedData.entrySet())
        {
            for(var key : entry.getKey())
            {
                if(!(key instanceof Serializable)){
                    canPerformSerialization = false;
                    break;
                }
            }
            if(!(entry.getValue() instanceof Serializable))
            {
                canPerformSerialization = false;
            }
            if(!canPerformSerialization)
            {
                break;
            }
        }
        if(!canPerformSerialization)
        {
            throw new ClassCastException("if @Cache.persistence equals true then " +
                    "all non @Exclude parameters and return type should be Serializable");
        }

        Map<List<Serializable>, Serializable> mapToSave =(Map) this.cachedData;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.getSaveFileName(method)));
        oos.writeObject(mapToSave);
        oos.close();

    }

    private void loadFromDisk(Method method) throws IOException, ClassNotFoundException {
        var cacheAnnotation = method.getAnnotation(Cache.class);
        if(cacheAnnotation != null)
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.getSaveFileName(method)));
            this.cachedData = (Map<List<Object>, Object>) ois.readObject();
            ois.close();
        }else
        {
            throw new IllegalArgumentException("method is now annotated as @Cache");
        }
    }

    private String getSaveFileName(Method method)
    {
        var cacheAnnotation = method.getAnnotation(Cache.class);
        if(cacheAnnotation != null)
        {
            if(cacheAnnotation.fileName().equals("methodName"))
            {
                return method.getName();
            }else
            {
                return cacheAnnotation.fileName();
            }
        }else
        {
            return "";
        }
    }

}
