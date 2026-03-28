package unit2.shapes;

public class Triangle extends Shape {
    private double base;
    private double height;
    private String triangleType;
    
    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base > 0 ? base : 1.0;
        this.height = height > 0 ? height : 1.0;
        this.triangleType = "General";
    }
    
    public Triangle(double base, double height, String triangleType) {
        super("Triangle");
        this.base = base > 0 ? base : 1.0;
        this.height = height > 0 ? height : 1.0;
        this.triangleType = triangleType;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + triangleType + " Triangle with base " + base + " and height " + height);
        System.out.println("  - Drawing three sides");
        System.out.println("  - Creating vertices");
        System.out.println("  - Filling the triangle with color");
    }
    
    public double calculateArea() {
        return 0.5 * base * height;
    }
    
    public double calculatePerimeter() {
        // Approximate perimeter for general triangle
        double side = Math.sqrt((base/2) * (base/2) + height * height);
        return base + 2 * side;
    }
}
