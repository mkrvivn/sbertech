package com.example;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CacheProxy cp = new CacheProxy(new DoStuffImpl());
        DoStuff cacheProxy = (DoStuff) Proxy.newProxyInstance(DoStuff.class.getClassLoader(), new Class[] {DoStuff.class}, cp);
        System.out.println(cacheProxy.hardWork(1, 1));
        System.out.println(cacheProxy.hardWork(2, 2));
        System.out.println(cacheProxy.hardWork(3, 3));
        System.out.println(cacheProxy.hardWork(4, 4));
        System.out.println(cacheProxy.hardWork(5, 5));
        System.out.println(cacheProxy.hardWork(6, 6));
        System.out.println(cacheProxy.hardWork(6, 7));
    }
}
