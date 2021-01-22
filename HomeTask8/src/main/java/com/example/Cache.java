package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

    /**
     * if persistence enabled then this parameter sets serialization filename
     * "methodName" will be replaced with "invoked method name + random postfix"
     */
    public String fileName() default "methodName";

    /**
     * enable in persistence filesystem saves
     * if true then method and return value should implement serializable
     */
    public boolean persistence() default true;

    /**
     * perform persistence saves every N unique invocations
     */
    public int cacheFrequency() default 5;

    /**
     * if return type is List, then this parameter limits size of cached List
     */
    public int listMaxSize() default 1000;

}
