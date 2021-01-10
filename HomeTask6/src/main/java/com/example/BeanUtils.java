package com.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtils {
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Map<String, Method> getters = allGetters(from.getClass());
        Map<String, List<Method>> setters = allSetters(to.getClass());
        for(var entry : getters.entrySet())
        {
            if(setters.containsKey(entry.getKey()))
            {
                for(var setter : setters.get(entry.getKey()))
                {
                    if(isCompatible(entry.getValue(), setter))
                    {
                        setter.invoke(to, entry.getValue().invoke(from));
                    }
                }
            }
        }
    }

    private static Map<String, Method> allGetters(Class<?> c)
    {
        Method[] allMethods = c.getMethods();
        Map<String, Method> getters = new HashMap<>();
        for(var method : allMethods)
            if(method.getName().startsWith("get"))
            {
                getters.put(method.getName().substring(3), method);
            }
        return getters;
    }

    private static Map<String, List<Method>> allSetters(Class<?> c)
    {
        Method[] allMethods = c.getMethods();
        Map<String, List<Method>> setters = new HashMap<>();
        for(var method : allMethods)
            if(method.getName().startsWith("set"))
            {
                setters.computeIfAbsent(method.getName().substring(3), k -> new ArrayList<>());
                setters.computeIfPresent(method.getName().substring(3), (k, v) -> {v.add(method); return v;});
            }
        return setters;
    }

    private static boolean isCompatible(Method from, Method to)
    {
        return to.getParameterCount() == 1 && to.getParameterTypes()[0].isAssignableFrom(from.getReturnType());
    }
}
