package com.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassInfoPrinter {

    public static void printAllMethods(Class<?> c)
    {
        if(c == null)
            return ;
        printAllMethods(c.getSuperclass());
        Method[] m = c.getDeclaredMethods();
        for(var method : m)
        {
            System.out.println(method);
        }

    }

    public static void printGetters(Class<?> c)
    {
        if(c == null)
            return;
        printGetters(c.getSuperclass());
        Method[] m = c.getDeclaredMethods();
        for(var method : m)
            if(method.getName().startsWith("get") && method.getModifiers() == Modifier.PUBLIC)
                System.out.println(method);
    }

    public static void checkStaticStrings(Class<?> c) throws  java.lang.IllegalAccessException
    {
        Field[] fields = c.getFields();
        boolean allIsEqual = true;
        for(var field : fields)
        {
            field.setAccessible(true);
            int mod = field.getModifiers() & (Modifier.PUBLIC + Modifier.STATIC);
            if(mod == (Modifier.PUBLIC + Modifier.STATIC))
                if(field.getType() == String.class)
                    if(!field.getName().equals(field.get(null)))
                        allIsEqual = false;
        }
        System.out.println(allIsEqual);
    }
}
