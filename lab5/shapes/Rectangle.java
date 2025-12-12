package lab5.shapes;

public class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double width , double length){
        this.length=length;
        this.width=width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle of width = " + width + " length = " + length);
}
}
