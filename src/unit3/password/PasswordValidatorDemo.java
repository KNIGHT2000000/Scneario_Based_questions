package unit3.password;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidatorDemo {
    private static final int MIN_LENGTH = 8;
    private static final Pattern DIGIT_PATTERN = Pattern.compile(".*\\d.*");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    
    public static void main(String[] args) {
        System.out.println("=== Password Validation System ===\n");
        
        System.out.println("Password Requirements:");
        System.out.println("• Minimum 8 characters");
        System.out.println("• At least one digit");
        System.out.println("• At least one uppercase letter");
        System.out.println("• At least one lowercase letter");
        System.out.println("• At least one special character\n");
        
        // Test various passwords
        demonstratePasswordValidation();
        
        System.out.println("\n=== Interactive Password Testing ===\n");
        interactivePasswordTest();
        
        System.out.println("\n=== Advanced Password Features ===\n");
        demonstrateAdvancedFeatures();
    }
    
    public static void demonstratePasswordValidation() {
        String[] testPasswords = {
            "password",      // Too short, no uppercase, no digit, no special
            "Password1",     // No special character
            "password1",     // No uppercase, no special
            "PASSWORD1",     // No lowercase, no special
            "Password!",     // No digit
            "Pass1!",        // Too short
            "Password1!",    // Valid
            "MySecureP@ssw0rd!", // Valid
            "12345678",      // No letters, no special
            "",              // Empty
            "aB1!"           // Too short
        };
        
        for (String password : testPasswords) {
            System.out.println("Testing password: \"" + password + "\"");
            
            try {
                validatePassword(password);
                System.out.println("  ✓ Password is valid");
                
            } catch (InvalidPasswordException e) {
                System.out.println("  ✗ " + e.getMessage());
                System.out.println("    Suggestion: " + e.getSuggestion());
            }
            System.out.println();
        }
    }
    
    public static void validatePassword(String password) throws InvalidPasswordException {
        // Check for null or empty
        if (password == null || password.trim().isEmpty()) {
            throw new InvalidPasswordException(
                password, 
                "Password cannot be empty", 
                "Please enter a password"
            );
        }
        
        // Check minimum length
        if (password.length() < MIN_LENGTH) {
            throw new InvalidPasswordException(
                password, 
                "Password must be at least " + MIN_LENGTH + " characters long", 
                "Add " + (MIN_LENGTH - password.length()) + " more characters"
            );
        }
        
        // Check for at least one digit
        if (!DIGIT_PATTERN.matcher(password).matches()) {
            throw new InvalidPasswordException(
                password, 
                "Password must contain at least one digit", 
                "Add a number (0-9) to your password"
            );
        }
        
        // Check for at least one uppercase letter
        if (!UPPERCASE_PATTERN.matcher(password).matches()) {
            throw new InvalidPasswordException(
                password, 
                "Password must contain at least one uppercase letter", 
                "Add an uppercase letter (A-Z) to your password"
            );
        }
        
        // Check for at least one lowercase letter
        if (!LOWERCASE_PATTERN.matcher(password).matches()) {
            throw new InvalidPasswordException(
                password, 
                "Password must contain at least one lowercase letter", 
                "Add a lowercase letter (a-z) to your password"
            );
        }
        
        // Check for at least one special character
        if (!SPECIAL_CHAR_PATTERN.matcher(password).matches()) {
            throw new InvalidPasswordException(
                password, 
                "Password must contain at least one special character", 
                "Add a special character (!@#$%^&*()) to your password"
            );
        }
    }
    
    public static void interactivePasswordTest() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Interactive Password Validator");
        System.out.println("Enter passwords to test (enter 'quit' to exit):\n");
        
        while (true) {
            try {
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                
                if (password.equalsIgnoreCase("quit")) {
                    break;
                }
                
                validatePassword(password);
                
                System.out.println("✓ Password is valid!");
                System.out.println("Password strength: " + calculatePasswordStrength(password));
                
            } catch (InvalidPasswordException e) {
                System.out.println("✗ Password validation failed:");
                System.out.println(e);
                
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static String calculatePasswordStrength(String password) {
        int score = 0;
        
        // Length scoring
        if (password.length() >= 8) score += 1;
        if (password.length() >= 12) score += 1;
        if (password.length() >= 16) score += 1;
        
        // Character variety scoring
        if (DIGIT_PATTERN.matcher(password).matches()) score += 1;
        if (UPPERCASE_PATTERN.matcher(password).matches()) score += 1;
        if (LOWERCASE_PATTERN.matcher(password).matches()) score += 1;
        if (SPECIAL_CHAR_PATTERN.matcher(password).matches()) score += 1;
        
        // Additional scoring
        if (password.length() >= 20) score += 1;
        if (!password.matches(".*\\s.*")) score += 1; // No spaces
        
        if (score <= 3) return "Weak";
        if (score <= 6) return "Medium";
        if (score <= 8) return "Strong";
        return "Very Strong";
    }
    
    public static void demonstrateAdvancedFeatures() {
        System.out.println("Advanced Password Features:");
        System.out.println();
        
        PasswordManager manager = new PasswordManager();
        
        // Test password manager
        manager.createUser("john", "Password1!");
        manager.createUser("alice", "MySecureP@ssw0rd!");
        
        try {
            manager.createUser("bob", "weak"); // Should fail
        } catch (InvalidPasswordException e) {
            System.out.println("Failed to create user: " + e.getMessage());
        }
        
        // Test password change
        try {
            manager.changePassword("john", "NewPassword1!");
        } catch (Exception e) {
            System.out.println("Password change failed: " + e.getMessage());
        }
        
        // Display user statistics
        System.out.println("\nUser Statistics:");
        System.out.println(manager.getStatistics());
    }
    
    static class PasswordManager {
        private java.util.Map<String, String> users = new java.util.HashMap<>();
        private java.util.Map<String, Integer> failedAttempts = new java.util.HashMap<>();
        
        public void createUser(String username, String password) throws InvalidPasswordException {
            validatePassword(password);
            users.put(username, password);
            System.out.println("✓ User '" + username + "' created successfully");
        }
        
        public void changePassword(String username, String newPassword) throws Exception {
            if (!users.containsKey(username)) {
                throw new Exception("User not found: " + username);
            }
            
            validatePassword(newPassword);
            users.put(username, newPassword);
            System.out.println("✓ Password changed for user '" + username + "'");
        }
        
        public boolean authenticate(String username, String password) {
            String storedPassword = users.get(username);
            if (storedPassword != null && storedPassword.equals(password)) {
                failedAttempts.remove(username);
                return true;
            } else {
                failedAttempts.put(username, failedAttempts.getOrDefault(username, 0) + 1);
                return false;
            }
        }
        
        public String getStatistics() {
            return String.format(
                "Total Users: %d\n" +
                "Failed Login Attempts: %d\n" +
                "Accounts with Failed Attempts: %d",
                users.size(),
                failedAttempts.values().stream().mapToInt(Integer::intValue).sum(),
                failedAttempts.size()
            );
        }
    }
}
