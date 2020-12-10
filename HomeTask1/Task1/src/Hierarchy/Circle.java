package Hierarchy;

import java.util.regex.Matcher;

public class Circle extends Shape {
    public Circle(double x, double y, double radius)
    {
        super(x, y);
        this.radius = radius;
    }

    public double getArea()
    {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double radius;
}
