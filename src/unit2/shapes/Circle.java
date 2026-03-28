package unit2.shapes;

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("Circle");
        this.radius = radius > 0 ? radius : 1.0;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
        System.out.println("  - Drawing circular outline");
        System.out.println("  - Filling the circle with color");
        System.out.println("  - Adding center point");
    }
    
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}
