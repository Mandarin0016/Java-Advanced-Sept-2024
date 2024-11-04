package _02_shapes;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        calculateArea();
        calculatePerimeter();
    }

    @Override
    public void calculatePerimeter() {
        double perimeter = (height + width) * 2;
        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        double area = height * width;
        super.setPerimeter(area);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
