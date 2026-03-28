package unit1.marks;

public class MarksProcessingDemo {
    public static void main(String[] args) {
        System.out.println("=== Student Marks Processing Program ===\n");
        
        MarksProcessor.demonstrateParameterPassing();
        
        System.out.println("=== Summary of Java Parameter Passing ===");
        System.out.println();
        System.out.println("Key Points:");
        System.out.println("1. Java always uses PASS-BY-VALUE");
        System.out.println("2. For primitive types: The actual value is copied");
        System.out.println("3. For objects: The reference value is copied");
        System.out.println("4. Changes to object state are reflected outside method");
        System.out.println("5. Reassigning reference inside method doesn't affect original");
        System.out.println();
        
        System.out.println("Visual Representation:");
        System.out.println("Primitive: int x = 10 -> method(x) copies value 10");
        System.out.println("Object: Marks m -> method(m) copies reference value");
        System.out.println("Both cases: Only the value is copied, not the variable itself");
        System.out.println();
        
        System.out.println("Practical Implications:");
        System.out.println("- Primitive modifications inside methods are lost");
        System.out.println("- Object modifications inside methods persist");
        System.out.println("- Arrays behave like objects (modifiable)");
        System.out.println("- String objects are immutable (effectively pass-by-value)");
        System.out.println();
        
        System.out.println("Memory Perspective:");
        System.out.println("- Stack: Stores primitive values and reference copies");
        System.out.println("- Heap: Stores actual objects");
        System.out.println("- Method parameters get their own stack space");
        System.out.println("- Multiple references can point to same heap object");
    }
}
