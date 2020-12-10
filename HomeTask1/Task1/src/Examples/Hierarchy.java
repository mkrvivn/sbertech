package Examples;

import java.util.ArrayList;
import java.util.List;
import Hierarchy.*;
public class Hierarchy {
    static public void run()
    {
        List<Shape> l = new ArrayList<Shape>();
        l.add(new Circle(1, 2, 3));
        l.add(new Rectangle(1, 1, 2, 3));
        l.add(new Square(1, 1, 2));
        l.add(new Triangle(1, 1, 2));
        for(Shape s : l)
        {
            System.out.println(s.getClass().getName() + " area - " + s.getArea());
        }

        Rectangle r = new Square(1, 1, 4);
        System.out.println("Area of square: " + String.valueOf(r.getArea()));
        r.setxSide(5);
        System.out.println("Area of square: " + String.valueOf(r.getArea()));
    }
}
