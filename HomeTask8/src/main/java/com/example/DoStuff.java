package com.example;

public interface DoStuff {

    @Cache
    public Integer hardWork(Integer val, @Exclude Integer mul) throws InterruptedException;
}
