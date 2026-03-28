package unit2.calculator;

public class CalculatorDemo {
    public static void main(String[] args) {
        System.out.println("=== Calculator with Method Overloading and Overriding Demo ===\n");
        
        System.out.println("=== Basic Calculator - Method Overloading ===\n");
        
        Calculator basicCalc = new Calculator();
        basicCalc.displayCalculatorInfo();
        System.out.println();
        
        System.out.println("Method Overloading Examples:");
        System.out.println("Same method name, different parameters:\n");
        
        // Overloaded methods with different parameter types
        basicCalc.add(10, 20);
        System.out.println();
        
        basicCalc.add(10.5, 20.7);
        System.out.println();
        
        // Overloaded method with different number of parameters
        basicCalc.add(5, 10, 15);
        System.out.println();
        
        // Overloaded method with array parameter
        int[] numbers = {1, 2, 3, 4, 5};
        basicCalc.add(numbers);
        System.out.println();
        
        // Other overloaded methods
        basicCalc.subtract(50, 25);
        basicCalc.subtract(50.5, 25.3);
        System.out.println();
        
        basicCalc.multiply(6, 7);
        basicCalc.multiply(6.5, 7.2);
        System.out.println();
        
        basicCalc.divide(100, 4);
        basicCalc.divide(100.0, 3.0);
        System.out.println();
        
        System.out.println("=== Advanced Calculator - Method Overriding ===\n");
        
        AdvancedCalculator advCalc = new AdvancedCalculator();
        advCalc.displayCalculatorInfo();
        System.out.println();
        
        System.out.println("Method Overriding Examples:");
        System.out.println("Child class provides new implementation for parent methods:\n");
        
        // Overridden methods
        advCalc.add(10, 20);
        System.out.println();
        
        advCalc.add(10.5, 20.7);
        System.out.println();
        
        // New overloaded method in child class
        advCalc.add(1, 2, 3, 4);
        System.out.println();
        
        // Advanced calculator specific methods
        advCalc.power(2, 8);
        System.out.println();
        
        advCalc.factorial(5);
        System.out.println();
        
        advCalc.isPrime(17);
        System.out.println();
        
        System.out.println("=== Polymorphism Demonstration ===\n");
        
        Calculator polyCalc = new AdvancedCalculator(); // Upcasting
        
        System.out.println("Using Calculator reference pointing to AdvancedCalculator:");
        polyCalc.add(15, 25); // Calls AdvancedCalculator.add() due to overriding
        System.out.println();
        
        polyCalc.add(15.5, 25.7); // Calls AdvancedCalculator.add() due to overriding
        System.out.println();
        
        // Cannot access AdvancedCalculator specific methods through Calculator reference
        // polyCalc.power(2, 3); // This would cause compile-time error
        
        System.out.println("=== Method Selection Process ===\n");
        
        System.out.println("Compile-time (Method Overloading):");
        System.out.println("- Compiler selects method based on reference type");
        System.out.println("- Method signature (name + parameters) must be unique");
        System.out.println("- Return type doesn't matter for overloading");
        System.out.println("- Example: add(int, int) vs add(double, double)");
        System.out.println();
        
        System.out.println("Runtime (Method Overriding):");
        System.out.println("- JVM selects method based on actual object type");
        System.out.println("- Method signature must be same in parent and child");
        System.out.println("- @Override annotation ensures correct overriding");
        System.out.println("- Example: Calculator.add() vs AdvancedCalculator.add()");
        System.out.println();
        
        System.out.println("=== Overriding Demonstration ===");
        advCalc.demonstrateOverriding();
        System.out.println();
        
        System.out.println("=== Comparison Summary ===");
        System.out.println("Method Overloading:");
        System.out.println("✓ Same class");
        System.out.println("✓ Same method name");
        System.out.println("✓ Different parameters (type, count, or order)");
        System.out.println("✓ Can have different return types");
        System.out.println("✓ Compile-time polymorphism");
        System.out.println("✓ Used for convenience and flexibility");
        System.out.println();
        
        System.out.println("Method Overriding:");
        System.out.println("✓ Parent-child relationship");
        System.out.println("✓ Same method name");
        System.out.println("✓ Same parameters");
        System.out.println("✓ Same return type (or covariant)");
        System.out.println("✓ Runtime polymorphism");
        System.out.println("✓ Used for specialization and customization");
        
        System.out.println("\n=== Real-world Analogy ===");
        System.out.println("Overloading is like a Swiss Army knife:");
        System.out.println("- One tool (name) with multiple functions");
        System.out.println("- Different blades for different purposes");
        System.out.println("- Choose the right blade for the task");
        System.out.println();
        
        System.out.println("Overriding is like customizing a car:");
        System.out.println("- Start with base model (parent class)");
        System.out.println("- Modify or replace parts (override methods)");
        System.out.println("- Keep same interface but improved functionality");
        System.out.println("- Each custom car has its unique features");
    }
}
