package unit2.calculator;

public class Calculator {
    
    // Method overloading for integer addition
    public int add(int a, int b) {
        System.out.println("Calculator.add(int, int) called");
        System.out.println("Adding " + a + " + " + b);
        int result = a + b;
        System.out.println("Result: " + result);
        return result;
    }
    
    // Method overloading for double addition
    public double add(double a, double b) {
        System.out.println("Calculator.add(double, double) called");
        System.out.println("Adding " + a + " + " + b);
        double result = a + b;
        System.out.println("Result: " + result);
        return result;
    }
    
    // Method overloading for three integers
    public int add(int a, int b, int c) {
        System.out.println("Calculator.add(int, int, int) called");
        System.out.println("Adding " + a + " + " + b + " + " + c);
        int result = a + b + c;
        System.out.println("Result: " + result);
        return result;
    }
    
    // Method overloading for array addition
    public int add(int[] numbers) {
        System.out.println("Calculator.add(int[]) called");
        System.out.print("Adding array elements: ");
        int sum = 0;
        for (int num : numbers) {
            System.out.print(num + " ");
            sum += num;
        }
        System.out.println();
        System.out.println("Result: " + sum);
        return sum;
    }
    
    // Additional overloaded methods
    public int subtract(int a, int b) {
        System.out.println("Calculator.subtract(int, int) called");
        return a - b;
    }
    
    public double subtract(double a, double b) {
        System.out.println("Calculator.subtract(double, double) called");
        return a - b;
    }
    
    public int multiply(int a, int b) {
        System.out.println("Calculator.multiply(int, int) called");
        return a * b;
    }
    
    public double multiply(double a, double b) {
        System.out.println("Calculator.multiply(double, double) called");
        return a * b;
    }
    
    public int divide(int a, int b) {
        System.out.println("Calculator.divide(int, int) called");
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: Division by zero!");
            return 0;
        }
    }
    
    public double divide(double a, double b) {
        System.out.println("Calculator.divide(double, double) called");
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: Division by zero!");
            return 0.0;
        }
    }
    
    // Display calculator information
    public void displayCalculatorInfo() {
        System.out.println("=== Basic Calculator ===");
        System.out.println("Features:");
        System.out.println("- Method overloading for different data types");
        System.out.println("- Support for int and double operations");
        System.out.println("- Array operations");
        System.out.println("- Basic arithmetic operations");
    }
}
