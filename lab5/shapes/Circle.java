package lab5.shapes;

public class Circle extends Shape {
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle of radius = " + radius);
    }
}
