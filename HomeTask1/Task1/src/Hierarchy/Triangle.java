package Hierarchy;

//equilateral triangle
public class Triangle extends Shape {
    public Triangle(double x, double y, double sideSize)
    {
        super(x, y);
        this.sideSize = sideSize;
    }

    @Override
    public double getArea() {
        return (Math.sqrt(3) / 4.0) * Math.pow(this.sideSize, 2);
    }

    public double getSideSize() {
        return sideSize;
    }

    public void setSideSize(double sideSize) {
        this.sideSize = sideSize;
    }

    private double sideSize;
}
