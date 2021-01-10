package com.example;

public class AssignConsumer {
    private Object obj = "";
    private String name = "";
    private Integer age = 0;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNumber(Double n)
    {
        System.out.println("this shouldn't been printed");
    }

    public void setNumber(Integer n)
    {
        System.out.println("this should been printed");
    }

    @Override
    public String toString() {
        return obj.toString() + " " + name.toString() + " " + age.toString();
    }
}
