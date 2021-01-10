package com.example;

public class AssignProducer {

    private String obj = "";
    private String name = "";
    private Integer age = 0;

    public AssignProducer(String obj, String name, Integer age) {
        this.obj = obj;
        this.name = name;
        this.age = age;
    }

    public String getObj() {
        return obj;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getNumber()
    {
        return 100;
    }

    @Override
    public String toString() {
        return obj.toString() + " " + name.toString() + " " + age.toString();
    }
}
