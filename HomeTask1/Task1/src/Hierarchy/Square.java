package Hierarchy;

public class Square extends Rectangle {

    public Square(double x, double y, double sideSize)
    {
        super(x, y, sideSize, sideSize);
    }

    public void setxSide(double xSide) {
        this.xSide = xSide;
        this.ySide = xSide;
    }

    public void setySide(double ySide) {
        this.ySide = ySide;
        this.xSide = xSide;
    }

    public double getArea()
    {
        return Math.pow(this.getxSide(), 2);
    }

    private double sizeSize;

    public double getSizeSize() {
        return sizeSize;
    }

    public void setSizeSize(double sizeSize) {
        this.sizeSize = sizeSize;
    }
}
