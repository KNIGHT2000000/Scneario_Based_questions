package unit1.shape;

public abstract class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract double calculateArea();
    
    public void displayShapeInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Area: " + calculateArea());
        System.out.println("------------------------");
    }
    
    public void draw() {
        System.out.println("Drawing " + name + "...");
    }
}
