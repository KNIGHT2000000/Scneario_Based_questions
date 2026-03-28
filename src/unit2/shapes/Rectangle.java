package unit2.shapes;

public class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length > 0 ? length : 1.0;
        this.width = width > 0 ? width : 1.0;
    }
    
    @Override
    public void() {
        System.out.println("Drawing a Rectangle with length " + length + " and width " + width);
        System.out.println("  - Drawing four sides");
        System.out.println("  - Creating 90-degree corners");
        System.out.println("  - Filling the rectangle with color");
    }
    
    public double calculateArea() {
        return length * width;
    }
    
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
