package unit1.shape;

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("Circle");
        this.radius = radius > 0 ? radius : 1.0;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius > 0 ? radius : 1.0;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void draw() {
        super.draw();
        System.out.println("Drawing a circle with radius " + radius);
        System.out.println("Circumference: " + (2 * Math.PI * radius));
    }
    
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void displayShapeInfo() {
        System.out.println("Circle Information:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
        System.out.println("------------------------");
    }
}
