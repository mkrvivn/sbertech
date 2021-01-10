package com.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) throws java.lang.IllegalAccessException, InterruptedException, InvocationTargetException {
        TestClassInh tci = new TestClassInh();
        ClassInfoPrinter.printAllMethods(TestClassInh.class);
        System.out.println("--------");
        ClassInfoPrinter.printGetters(TestClassInh.class);

        ClassInfoPrinter.checkStaticStrings(StringClassTrue.class);
        ClassInfoPrinter.checkStaticStrings(StringClassFalse.class);

        System.out.println("cache proxy");
        Calculator c = new CalculatorImpl();
        CacheHandler ch = new CacheHandler(c);
        Calculator cacheProxy = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), new Class[] {Calculator.class}, ch);

        System.out.println("perfomance proxy");


        PerfomanceHandler ph = new PerfomanceHandler(cacheProxy);
        Calculator cProxy = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), new Class[] {Calculator.class}, ph);
        System.out.println(cProxy.calculate(8));
        System.out.println(cProxy.calculate(8));

        System.out.println("BeanUtils");

        AssignConsumer ac = new AssignConsumer();
        AssignProducer ap = new AssignProducer("test", "Name", 30);

        BeanUtils.assign(ac, ap);


        System.out.println(ap);

        System.out.println(ac);



    }
}
