package unit1.shape;

public class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length > 0 ? length : 1.0;
        this.width = width > 0 ? width : 1.0;
    }
    
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setLength(double length) {
        this.length = length > 0 ? length : 1.0;
    }
    
    public void setWidth(double width) {
        this.width = width > 0 ? width : 1.0;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public void draw() {
        super.draw();
        System.out.println("Drawing a rectangle with length " + length + " and width " + width);
        System.out.println("Perimeter: " + calculatePerimeter());
    }
    
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    @Override
    public void displayShapeInfo() {
        System.out.println("Rectangle Information:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("------------------------");
    }
}
