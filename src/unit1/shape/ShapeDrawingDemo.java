package unit1.shape;

public class ShapeDrawingDemo {
    public static void main(String[] args) {
        System.out.println("=== Shape Drawing Application Demo ===\n");
        
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(3.5);
        
        Rectangle rectangle1 = new Rectangle(10.0, 6.0);
        Rectangle rectangle2 = new Rectangle(8.0, 4.0);
        Rectangle rectangle3 = new Rectangle(12.0, 3.0);
        
        System.out.println("=== Individual Shape Operations ===\n");
        
        System.out.println("Circle Operations:");
        circle1.displayShapeInfo();
        circle1.draw();
        System.out.println();
        
        circle2.displayShapeInfo();
        circle2.draw();
        System.out.println();
        
        System.out.println("Rectangle Operations:");
        rectangle1.displayShapeInfo();
        rectangle1.draw();
        System.out.println();
        
        rectangle2.displayShapeInfo();
        rectangle2.draw();
        System.out.println();
        
        rectangle3.displayShapeInfo();
        rectangle3.draw();
        System.out.println();
        
        System.out.println("=== Polymorphism Demonstration ===\n");
        
        Shape[] shapes = {circle1, circle2, rectangle1, rectangle2, rectangle3};
        
        System.out.println("Using base class reference to handle different shapes:");
        for (Shape shape : shapes) {
            shape.draw();
            System.out.println("Area calculated using polymorphism: " + shape.calculateArea());
            System.out.println();
        }
        
        System.out.println("=== Method Overriding Demonstration ===");
        System.out.println("Each shape class overrides calculateArea() method:");
        System.out.println("- Circle: π * r²");
        System.out.println("- Rectangle: length * width");
        System.out.println("Runtime polymorphism ensures correct method is called");
        
        System.out.println("\n=== Dynamic Binding Example ===");
        System.out.println("Shape reference can point to any subclass object:");
        Shape shapeRef;
        
        shapeRef = new Circle(4.0);
        System.out.println("Shape reference points to Circle:");
        shapeRef.displayShapeInfo();
        
        shapeRef = new Rectangle(7.0, 5.0);
        System.out.println("Shape reference points to Rectangle:");
        shapeRef.displayShapeInfo();
        
        System.out.println("\n=== Benefits of Polymorphism ===");
        System.out.println("- Code flexibility and extensibility");
        System.out.println("- Reduced code duplication");
        System.out.println("- Easy to add new shape types");
        System.out.println("- Clean and maintainable code structure");
    }
}
