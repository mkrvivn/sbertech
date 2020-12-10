package Hierarchy;

public class Rectangle extends Shape {
    public Rectangle(double x, double y, double xSide, double ySide)
    {
        super(x, y);
        this.xSide = xSide;
        this.ySide = ySide;
    }

    public double getArea()
    {
        return xSide * ySide;
    }

    public double getxSide() {
        return xSide;
    }

    public void setxSide(double xSide) {
        this.xSide = xSide;
    }

    public double getySide() {
        return ySide;
    }

    public void setySide(double ySide) {
        this.ySide = ySide;
    }

    protected double xSide;
    protected double ySide;
}
