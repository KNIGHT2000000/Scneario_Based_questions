package unit3.banking;

public class DivisionByZeroDemo {
    public static void main(String[] args) {
        System.out.println("=== Banking Division by Zero Exception Handling ===\n");
        
        System.out.println("Scenario: User enters 0 as withdrawal divisor");
        System.out.println("This simulates a calculation error in banking operations\n");
        
        // Demonstrate the problem
        demonstrateDivisionByZero();
        
        System.out.println("\n=== Exception Handling Solutions ===\n");
        
        demonstrateTryCatch();
        demonstrateValidation();
        demonstrateMultipleApproaches();
    }
    
    public static void demonstrateDivisionByZero() {
        System.out.println("1. Without Exception Handling (Will Crash):");
        
        try {
            System.out.println("Attempting to divide by zero...");
            double result = calculateInterest(1000.0, 0.0); // This will cause ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
        
        System.out.println("\n2. What happens in real banking application:");
        System.out.println("- User enters: Withdrawal amount / 0 for some calculation");
        System.out.println("- System tries to perform division");
        System.out.println("- ArithmeticException is thrown");
        System.out.println("- Application crashes without proper handling");
    }
    
    public static double calculateInterest(double principal, double divisor) {
        System.out.println("Calculating: " + principal + " / " + divisor);
        return principal / divisor; // This will throw ArithmeticException if divisor is 0
    }
    
    public static void demonstrateTryCatch() {
        System.out.println("=== Solution 1: Try-Catch Block ===\n");
        
        double[] principals = {1000.0, 2500.0, 5000.0};
        double[] divisors = {2.0, 0.0, 4.0}; // One of them is zero
        
        for (int i = 0; i < principals.length; i++) {
            try {
                System.out.println("Processing transaction " + (i + 1) + ":");
                double result = calculateInterest(principals[i], divisors[i]);
                System.out.println("  Principal: $" + principals[i]);
                System.out.println("  Divisor: " + divisors[i]);
                System.out.println("  Result: $" + result);
                System.out.println("  Status: Success");
            } catch (ArithmeticException e) {
                System.out.println("  Principal: $" + principals[i]);
                System.out.println("  Divisor: " + divisors[i]);
                System.out.println("  Error: " + e.getMessage());
                System.out.println("  Status: Failed - Division by zero");
                System.out.println("  Action: Using default calculation");
                double defaultResult = principals[i] * 0.05; // 5% default interest
                System.out.println("  Default interest: $" + defaultResult);
            } catch (Exception e) {
                System.out.println("  Unexpected error: " + e.getMessage());
                System.out.println("  Status: Failed - Unknown error");
            } finally {
                System.out.println("  Transaction " + (i + 1) + " completed\n");
            }
        }
    }
    
    public static void demonstrateValidation() {
        System.out.println("=== Solution 2: Input Validation ===\n");
        
        double[] testValues = {1000.0, 0.0, 500.0, -100.0};
        
        for (double value : testValues) {
            System.out.println("Processing value: " + value);
            
            if (value == 0.0) {
                System.out.println("  Validation failed: Value cannot be zero");
                System.out.println("  Action: Using default value of 1.0");
                value = 1.0;
            } else if (value < 0) {
                System.out.println("  Validation failed: Value cannot be negative");
                System.out.println("  Action: Using absolute value");
                value = Math.abs(value);
            }
            
            try {
                double result = 1000.0 / value;
                System.out.println("  Calculation successful: 1000 / " + value + " = " + result);
            } catch (Exception e) {
                System.out.println("  Unexpected error: " + e.getMessage());
            }
            System.out.println();
        }
    }
    
    public static void demonstrateMultipleApproaches() {
        System.out.println("=== Solution 3: Combined Approach ===\n");
        
        BankingCalculator calculator = new BankingCalculator();
        
        // Test various scenarios
        calculator.processTransaction("TXN001", 1000.0, 2.0);  // Normal case
        calculator.processTransaction("TXN002", 2000.0, 0.0);  // Division by zero
        calculator.processTransaction("TXN003", 1500.0, -1.0); // Negative divisor
        calculator.processTransaction("TXN004", 3000.0, 5.0);  // Normal case
        
        System.out.println("\n=== Best Practices Summary ===");
        System.out.println("1. Always validate user input before processing");
        System.out.println("2. Use try-catch blocks for potential exceptions");
        System.out.println("3. Provide meaningful error messages");
        System.out.println("4. Implement fallback mechanisms");
        System.out.println("5. Log errors for debugging");
        System.out.println("6. Gracefully handle exceptions without crashing");
    }
    
    static class BankingCalculator {
        public void processTransaction(String transactionId, double amount, double divisor) {
            System.out.println("Processing Transaction: " + transactionId);
            System.out.println("  Amount: $" + amount);
            System.out.println("  Divisor: " + divisor);
            
            try {
                // Validate input
                if (divisor == 0.0) {
                    throw new IllegalArgumentException("Divisor cannot be zero");
                }
                
                if (divisor < 0) {
                    throw new IllegalArgumentException("Divisor cannot be negative");
                }
                
                // Perform calculation
                double result = amount / divisor;
                System.out.println("  Result: $" + result);
                System.out.println("  Status: Success");
                
            } catch (IllegalArgumentException e) {
                System.out.println("  Validation Error: " + e.getMessage());
                System.out.println("  Action: Using default calculation");
                double defaultResult = amount * 0.1; // 10% default
                System.out.println("  Default Result: $" + defaultResult);
                System.out.println("  Status: Completed with fallback");
                
            } catch (Exception e) {
                System.out.println("  Unexpected Error: " + e.getMessage());
                System.out.println("  Status: Failed");
                
            } finally {
                System.out.println("  Transaction " + transactionId + " processed");
            }
            System.out.println();
        }
    }
}
