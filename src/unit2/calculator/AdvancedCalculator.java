package unit2.calculator;

public class AdvancedCalculator extends Calculator {
    
    // Override add(int, int) method to change logic
    @Override
    public int add(int a, int b) {
        System.out.println("AdvancedCalculator.add(int, int) called - OVERRIDDEN");
        System.out.println("Enhanced addition for integers:");
        System.out.println("Adding " + a + " + " + b + " with validation");
        
        // Add validation and enhanced logic
        if (a < 0 || b < 0) {
            System.out.println("Warning: Negative numbers detected");
        }
        
        int result = a + b;
        
        // Add result validation
        if (result > Integer.MAX_VALUE / 2) {
            System.out.println("Warning: Result is large");
        }
        
        System.out.println("Enhanced result: " + result);
        System.out.println("Note: This method overrides the parent class method");
        
        return result;
    }
    
    // Override add(double, double) method
    @Override
    public double add(double a, double b) {
        System.out.println("AdvancedCalculator.add(double, double) called - OVERRIDDEN");
        System.out.println("Enhanced addition for doubles:");
        System.out.println("Adding " + a + " + " + b + " with precision check");
        
        double result = a + b;
        
        // Check for precision issues
        if (Double.isInfinite(result)) {
            System.out.println("Warning: Result is infinite");
        } else if (Double.isNaN(result)) {
            System.out.println("Warning: Result is not a number");
        }
        
        // Format result to reasonable precision
        System.out.printf("Precise result: %.4f\n", result);
        System.out.println("Note: This method overrides the parent class method");
        
        return result;
    }
    
    // New overloaded method specific to AdvancedCalculator
    public int add(int a, int b, int c, int d) {
        System.out.println("AdvancedCalculator.add(int, int, int, int) called - NEW");
        System.out.println("Adding four integers: " + a + " + " + b + " + " + c + " + " + d);
        int result = a + b + c + d;
        System.out.println("Result: " + result);
        return result;
    }
    
    // Advanced operations
    public int power(int base, int exponent) {
        System.out.println("AdvancedCalculator.power(int, int) called");
        System.out.println("Calculating " + base + " ^ " + exponent);
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        System.out.println("Result: " + result);
        return result;
    }
    
    public int factorial(int n) {
        System.out.println("AdvancedCalculator.factorial(int) called");
        System.out.println("Calculating factorial of " + n);
        if (n < 0) {
            System.out.println("Factorial not defined for negative numbers");
            return -1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("Result: " + result);
        return result;
    }
    
    public boolean isPrime(int n) {
        System.out.println("AdvancedCalculator.isPrime(int) called");
        System.out.println("Checking if " + n + " is prime");
        if (n <= 1) {
            System.out.println("Result: false");
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println("Result: false");
                return false;
            }
        }
        System.out.println("Result: true");
        return true;
    }
    
    @Override
    public void displayCalculatorInfo() {
        System.out.println("=== Advanced Calculator ===");
        System.out.println("Features:");
        System.out.println("- Inherits all basic calculator features");
        System.out.println("- Overrides add() methods with enhanced logic");
        System.out.println("- Additional advanced operations");
        System.out.println("- Prime number checking");
        System.out.println("- Factorial calculation");
        System.out.println("- Power operations");
    }
    
    // Demonstrate method overriding
    public void demonstrateOverriding() {
        System.out.println("=== Method Overriding Demonstration ===");
        System.out.println("Parent class (Calculator) methods:");
        System.out.println("- add(int, int): Simple addition");
        System.out.println("- add(double, double): Simple addition");
        System.out.println();
        System.out.println("Child class (AdvancedCalculator) methods:");
        System.out.println("- add(int, int): Enhanced addition with validation");
        System.out.println("- add(double, double): Enhanced addition with precision check");
        System.out.println();
        System.out.println("Overriding allows:");
        System.out.println("- Changing implementation of inherited methods");
        System.out.println("- Adding new functionality");
        System.out.println("- Maintaining same method signature");
        System.out.println("- Using @Override annotation for clarity");
    }
}
