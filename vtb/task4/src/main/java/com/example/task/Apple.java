package com.example.task;

public class Apple extends Fruit{

    public Apple()
    {
        name = "apple";
    }

    @Override
    public Double getWeight() {
        return 1.5;
    }
}
