package com.example;

public interface Calculator {

    @Metric
    @Cache
    public int calculate(int value) throws InterruptedException;
}
