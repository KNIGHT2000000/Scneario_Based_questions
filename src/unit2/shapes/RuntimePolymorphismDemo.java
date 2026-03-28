package unit2.shapes;

public class RuntimePolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("=== Runtime Polymorphism Demo ===\n");
        
        System.out.println("=== Creating Individual Shape Objects ===\n");
        
        Circle circle1 = new Circle(5.0);
        Rectangle rectangle1 = new Rectangle(10.0, 6.0);
        Triangle triangle1 = new Triangle(8.0, 6.0, "Equilateral");
        
        System.out.println("Individual Shape Drawing:");
        circle1.displayShapeInfo();
        System.out.println();
        
        rectangle1.displayShapeInfo();
        System.out.println();
        
        triangle1.displayShapeInfo();
        System.out.println();
        
        System.out.println("=== Runtime Polymorphism with Shape Array ===\n");
        
        // Shape reference array storing different shape objects
        Shape[] shapes = new Shape[6];
        
        shapes[0] = new Circle(3.0);
        shapes[1] = new Rectangle(8.0, 4.0);
        shapes[2] = new Triangle(6.0, 4.0, "Isosceles");
        shapes[3] = new Circle(7.0);
        shapes[4] = new Rectangle(12.0, 8.0);
        shapes[5] = new Triangle(10.0, 8.0, "Right");
        
        System.out.println("Drawing all shapes using base class reference:");
        System.out.println("Demonstrating runtime polymorphism:\n");
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + ":");
            shapes[i].displayShapeInfo();
            System.out.println();
        }
        
        System.out.println("=== Runtime Binding Demonstration ===");
        System.out.println("The actual draw() method to be executed is determined at runtime:");
        System.out.println("- Compiler sees: shapes[i].draw()");
        System.out.println("- JVM determines at runtime which draw() to call based on actual object type");
        System.out.println("- This is called dynamic method dispatch or runtime polymorphism");
        System.out.println();
        
        System.out.println("=== Method Resolution Process ===");
        System.out.println("1. Reference type: Shape");
        System.out.println("2. Actual object types: Circle, Rectangle, Triangle");
        System.out.println("3. JVM looks up the actual object's class");
        System.out.println("4. Calls the overridden method in the actual object class");
        System.out.println("5. Different behavior for different objects");
        System.out.println();
        
        System.out.println("=== Benefits of Runtime Polymorphism ===");
        System.out.println("1. Flexibility: Code can work with different object types");
        System.out.println("2. Extensibility: New shapes can be added without changing existing code");
        System.out.println("3. Maintainability: Single interface for multiple implementations");
        System.out.println("4. Code Reusability: Same code works for all shape types");
        System.out.println();
        
        System.out.println("=== Polymorphic Method Calls ===");
        System.out.println("Calling draw() method polymorphically:");
        
        for (Shape shape : shapes) {
            System.out.print("Drawing " + shape.getName() + ": ");
            shape.draw(); // Runtime polymorphism
            System.out.println();
        }
        
        System.out.println("=== Comparison with Compile-time Polymorphism ===");
        System.out.println("Compile-time (Method Overloading):");
        System.out.println("- Method selection happens at compile time");
        System.out.println("- Based on method signature");
        System.out.println("- Example: draw(), draw(String color)");
        System.out.println();
        System.out.println("Runtime (Method Overriding):");
        System.out.println("- Method selection happens at runtime");
        System.out.println("- Based on actual object type");
        System.out.println("- Example: shape.draw() calls Circle.draw() or Rectangle.draw()");
    }
}
