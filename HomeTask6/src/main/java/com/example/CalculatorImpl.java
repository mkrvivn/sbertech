package com.example;

import static java.lang.Thread.sleep;

public class CalculatorImpl implements Calculator{
    @Override
    public int calculate(int value) throws InterruptedException {
        sleep(2000);
        int fact = 1;
        for(int i = 1; i < value; i++)
        {
            fact = fact * i ;
        }
        return fact;
    }
}
