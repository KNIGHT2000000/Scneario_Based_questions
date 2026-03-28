package unit3.login;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystemDemo {
    private static Map<String, String> userDatabase = new HashMap<>();
    private static Map<String, Integer> loginAttempts = new HashMap<>();
    private static final int MAX_ATTEMPTS = 3;
    
    static {
        // Initialize user database
        userDatabase.put("admin", "admin123");
        userDatabase.put("john", "password123");
        userDatabase.put("alice", "alice456");
        userDatabase.put("bob", "bob789");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Online Exam Portal Login System ===\n");
        
        System.out.println("User-Defined Exception: InvalidLoginException");
        System.out.println("Purpose: Handle login failures with detailed information\n");
        
        // Demonstrate login scenarios
        demonstrateLoginScenarios();
        
        System.out.println("\n=== Interactive Login Demo ===\n");
        interactiveLoginDemo();
        
        System.out.println("\n=== Exception Handling Analysis ===\n");
        analyzeExceptionHandling();
    }
    
    public static void demonstrateLoginScenarios() {
        System.out.println("1. Successful Login:");
        try {
            login("admin", "admin123");
        } catch (InvalidLoginException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        
        System.out.println("\n2. Wrong Password:");
        try {
            login("admin", "wrongpass");
        } catch (InvalidLoginException e) {
            System.out.println("Login failed: " + e.getMessage());
            System.out.println("Attempt count: " + e.getAttemptCount());
            System.out.println("Account locked: " + e.isAccountLocked());
        }
        
        System.out.println("\n3. Non-existent User:");
        try {
            login("nonexistent", "password");
        } catch (InvalidLoginException e) {
            System.out.println("Login failed: " + e.getMessage());
            System.out.println("Reason: " + e.getReason());
        }
        
        System.out.println("\n4. Multiple Failed Attempts (Account Lock):");
        for (int i = 1; i <= 4; i++) {
            try {
                login("alice", "wrongpass" + i);
            } catch (InvalidLoginException e) {
                System.out.println("Attempt " + i + ": " + e.getMessage());
                if (e.isAccountLocked()) {
                    System.out.println("ACCOUNT LOCKED! Contact administrator.");
                    break;
                }
            }
        }
    }
    
    public static void login(String username, String password) throws InvalidLoginException {
        // Check if account is locked
        Integer attempts = loginAttempts.get(username);
        if (attempts != null && attempts >= MAX_ATTEMPTS) {
            throw new InvalidLoginException(username, "Account locked due to too many failed attempts", attempts);
        }
        
        // Validate credentials
        if (!userDatabase.containsKey(username)) {
            // Record failed attempt
            incrementAttempts(username);
            throw new InvalidLoginException(username, "User not found", 
                                         loginAttempts.get(username));
        }
        
        if (!userDatabase.get(username).equals(password)) {
            // Record failed attempt
            incrementAttempts(username);
            int currentAttempts = loginAttempts.get(username);
            
            String reason = "Invalid password";
            if (currentAttempts >= MAX_ATTEMPTS) {
                reason = "Account locked due to too many failed attempts";
            }
            
            throw new InvalidLoginException(username, reason, currentAttempts);
        }
        
        // Successful login - reset attempts
        loginAttempts.remove(username);
        System.out.println("✓ Login successful for user: " + username);
        System.out.println("Welcome to the Online Exam Portal!");
    }
    
    private static void incrementAttempts(String username) {
        int attempts = loginAttempts.getOrDefault(username, 0) + 1;
        loginAttempts.put(username, attempts);
    }
    
    public static void interactiveLoginDemo() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Interactive Login Test");
        System.out.println("Available users: admin, john, alice, bob");
        System.out.println("Passwords: admin123, password123, alice456, bob789");
        System.out.println("Enter 'quit' to exit\n");
        
        while (true) {
            try {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                
                if (username.equalsIgnoreCase("quit")) {
                    break;
                }
                
                System.out.print("Password: ");
                String password = scanner.nextLine();
                
                login(username, password);
                
            } catch (InvalidLoginException e) {
                System.out.println("Login Error:");
                System.out.println(e);
                
                if (e.isAccountLocked()) {
                    System.out.println("Please contact administrator to unlock account.");
                }
                
            } catch (Exception e) {
                System.out.println("System error: " + e.getMessage());
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static void analyzeExceptionHandling() {
        System.out.println("User-Defined Exception Benefits:");
        System.out.println();
        
        System.out.println("1. Specific Error Information:");
        System.out.println("   ✓ Username that failed");
        System.out.println("   ✓ Specific reason for failure");
        System.out.println("   ✓ Number of attempts");
        System.out.println("   ✓ Account lock status");
        System.out.println();
        
        System.out.println("2. Business Logic Integration:");
        System.out.println("   ✓ Enforces maximum login attempts");
        System.out.println("   ✓ Provides account lock mechanism");
        System.out.println("   ✓ Tracks login attempts per user");
        System.out.println("   ✓ Supports different failure scenarios");
        System.out.println();
        
        System.out.println("3. Better Error Handling:");
        System.out.println("   ✓ Type-safe exception handling");
        System.out.println("   ✓ Catch-specific exception type");
        System.out.println("   ✓ Access to exception-specific data");
        System.out.println("   ✓ Meaningful error messages");
        System.out.println();
        
        System.out.println("4. Comparison with Standard Exceptions:");
        System.out.println("   Standard Exception:");
        System.out.println("   - throw new Exception('Login failed')");
        System.out.println("   - Generic error message");
        System.out.println("   - No specific error details");
        System.out.println("   - Hard to handle different failure types");
        System.out.println();
        
        System.out.println("   Custom Exception:");
        System.out.println("   - throw new InvalidLoginException(...)");
        System.out.println("   - Detailed error information");
        System.out.println("   - Business-specific data");
        System.out.println("   - Easy to handle specific scenarios");
        System.out.println();
        
        System.out.println("5. When to Create Custom Exceptions:");
        System.out.println("   ✓ Business rule violations");
        System.out.println("   ✓ Need for additional error data");
        System.out.println("   ✓ Multiple failure scenarios");
        System.out.println("   ✓ Domain-specific error handling");
        System.out.println("   ✓ Better error reporting requirements");
        
        System.out.println("\nLogin System Statistics:");
        System.out.println("Total users in database: " + userDatabase.size());
        System.out.println("Users with failed attempts: " + loginAttempts.size());
        System.out.println("Locked accounts: " + getLockedAccountCount());
    }
    
    private static int getLockedAccountCount() {
        int count = 0;
        for (int attempts : loginAttempts.values()) {
            if (attempts >= MAX_ATTEMPTS) {
                count++;
            }
        }
        return count;
    }
}
