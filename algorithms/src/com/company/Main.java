package com.company;


import java.util.List;

class Shape { void draw() {}}

class Circle extends Shape {void draw() {}}

class Square extends Shape {void draw() {}}

class Rectangle extends Shape {void draw() {}}

public class Test {
    /*
     * Example for an upper bound wildcard (Get values i.e Producer `extends`)
     *
     * */

    public void testCoVariance(List<? extends Shape> list) {
        list.add(new Shape()); // Error:  is not applicable for the arguments (Shape) i.e. inheritance is not supporting
        list.add(new Circle()); // Error:  is not applicable for the arguments (Circle) i.e. inheritance is not supporting
        list.add(new Square()); // Error:  is not applicable for the arguments (Square) i.e. inheritance is not supporting
        list.add(new Rectangle()); // Error:  is not applicable for the arguments (Rectangle) i.e. inheritance is not supporting
        Shape shape= list.get(0);//compiles so list act as produces only

        /*You can't add a Shape,Circle,Square,Rectangle to a List<? extends Shape>
         * You can get an object and know that it will be an Shape
         */
    }
    /*
     * Example for  a lower bound wildcard (Put values i.e Consumer`super`)
     * */
    public void testContraVariance(List<? super Shape> list) {
        list.add(new Shape());//compiles i.e. inheritance is supporting
        list.add(new Circle());//compiles i.e. inheritance is  supporting
        list.add(new Square());//compiles i.e. inheritance is supporting
        list.add(new Rectangle());//compiles i.e. inheritance is supporting
        Shape shape= list.get(0); // Error: Type mismatch, so list acts only as consumer
        Object object= list.get(0); // gets an object, but we don't know what kind of Object it is.

        /*You can add a Shape,Circle,Square,Rectangle to a List<? super Shape>
         * You can't get an Shape(but can get Object) and don't know what kind of Shape it is.
         */
    }
}
public class Main {

    public static void main(String[] args) {
        list<Integer> l = new list<>();
        l.add(23);
        Number i = l.get();
    }
}
