package _02_shapes;

public class Circle extends Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
        calculatePerimeter();
        calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        double perimeter = 2 * Math.PI * radius;
        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        double area = Math.PI * radius * radius;
        super.setArea(area);
    }

    public final double getRadius() {
        return radius;
    }
}
