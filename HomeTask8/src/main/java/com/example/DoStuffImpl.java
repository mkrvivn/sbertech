package com.example;

import java.util.Random;

public class DoStuffImpl implements DoStuff{

    @Override
    public Integer hardWork(Integer val, Integer mul) throws InterruptedException {
        Thread.sleep(3000);
        return val * mul;
    }
}
