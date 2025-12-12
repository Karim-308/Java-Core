package lab5.shapes;

import java.util.List;
import java.util.ArrayList;

public class Drawer {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5,5);
        Rectangle r2 = new Rectangle(70,50);
        Circle c1 = new Circle(65);
        Circle c2 = new Circle(13);

        List<Shape> list1 = new ArrayList<>();
        list1.add(r1);
        list1.add(r2);
     
        List<Shape> list2 = new ArrayList<>();
        list2.add(c1);
        list2.add(c2);
        list2.add(r1);
        list2.add(r2);

        drawShapes(list1);
        System.out.println("+++++++");
        drawShapes(list2);
    }

    public static void drawShapes(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw();
        }
    }
} 