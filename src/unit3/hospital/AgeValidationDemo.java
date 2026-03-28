package unit3.hospital;

public class AgeValidationDemo {
    public static void main(String[] args) {
        System.out.println("=== Hospital Age Validation Exception Handling ===\n");
        
        System.out.println("Scenario: Patient age validation in hospital management system");
        System.out.println("Valid age range: 0 to 120 years\n");
        
        // Demonstrate age validation
        demonstrateAgeValidation();
        
        System.out.println("\n=== Exception Type Analysis ===\n");
        analyzeExceptionType();
        
        System.out.println("\n=== Custom Exception Implementation ===\n");
        demonstrateCustomException();
        
        System.out.println("\n=== Best Practices ===\n");
        demonstrateBestPractices();
    }
    
    public static void demonstrateAgeValidation() {
        System.out.println("1. Testing Various Age Values:");
        
        int[] testAges = {25, 0, 120, -5, 130, 150, -10};
        
        for (int age : testAges) {
            System.out.println("\nTesting age: " + age);
            
            try {
                validateAge(age);
                Patient patient = new Patient("Test Patient", age, "Healthy");
                System.out.println("  ✓ Patient created successfully");
                System.out.println("  Details: " + patient.getSummary());
                
            } catch (IllegalArgumentException e) {
                System.out.println("  ✗ Validation failed: " + e.getMessage());
                System.out.println("  Action: Patient record not created");
                
            } catch (Exception e) {
                System.out.println("  ✗ Unexpected error: " + e.getMessage());
            }
        }
    }
    
    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        
        if (age > 120) {
            throw new IllegalArgumentException("Age cannot be greater than 120: " + age);
        }
        
        // Additional validation
        if (age == 0 && !isNewbornAgeValid()) {
            throw new IllegalArgumentException("Age 0 requires additional verification");
        }
    }
    
    private static boolean isNewbornAgeValid() {
        // In real system, this would check medical records
        return true; // Simplified for demo
    }
    
    public static void analyzeExceptionType() {
        System.out.println("Why IllegalArgumentException is suitable:");
        System.out.println();
        
        System.out.println("1. Type Appropriateness:");
        System.out.println("   ✓ IllegalArgumentException extends RuntimeException");
        System.out.println("   ✓ Indicates invalid method parameter");
        System.out.println("   ✓ Unchecked exception (no need to declare)");
        System.out.println();
        
        System.out.println("2. Alternative Exceptions Considered:");
        System.out.println("   • Exception: Too general");
        System.out.println("   • RuntimeException: Still too general");
        System.out.println("   • ArithmeticException: Not related to calculations");
        System.out.println("   • NumberFormatException: For string parsing issues");
        System.out.println();
        
        System.out.println("3. IllegalArgumentException Benefits:");
        System.out.println("   ✓ Clear indication of parameter problem");
        System.out.println("   ✓ Standard Java exception type");
        System.out.println("   ✓ Widely recognized and understood");
        System.out.println("   ✓ Part of Java API standard practices");
        System.out.println();
        
        System.out.println("4. When to Use IllegalArgumentException:");
        System.out.println("   • Parameter validation fails");
        System.out.println("   • Invalid argument values");
        System.out.println("   • Business rule violations");
        System.out.println("   • Data validation errors");
    }
    
    public static void demonstrateCustomException() {
        System.out.println("Custom Exception Approach:");
        
        int[] testAges = {25, -5, 130};
        
        for (int age : testAges) {
            System.out.println("\nTesting age: " + age + " with custom exception");
            
            try {
                validateAgeWithCustom(age);
                Patient patient = new Patient("Test Patient", age, "Healthy");
                System.out.println("  ✓ Patient created successfully");
                
            } catch (InvalidAgeException e) {
                System.out.println("  ✗ Custom exception caught: " + e.getMessage());
                System.out.println("  Error code: " + e.getErrorCode());
                System.out.println("  Suggested action: " + e.getSuggestedAction());
                
            } catch (Exception e) {
                System.out.println("  ✗ Unexpected error: " + e.getMessage());
            }
        }
    }
    
    public static void validateAgeWithCustom(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException(age, "Age cannot be negative", 
                                        "AGE_NEGATIVE", "Verify patient data entry");
        }
        
        if (age > 120) {
            throw new InvalidAgeException(age, "Age exceeds maximum limit", 
                                        "AGE_TOO_HIGH", "Confirm with patient records");
        }
    }
    
    public static void demonstrateBestPractices() {
        System.out.println("Age Validation Best Practices:");
        System.out.println();
        
        PatientRegistrationSystem system = new PatientRegistrationSystem();
        
        // Test various scenarios
        system.registerPatient("John Doe", 35, "Regular checkup");
        system.registerPatient("Baby Smith", 0, "Newborn screening");
        system.registerPatient("Invalid Patient", -10, "Test case");
        system.registerPatient("Very Old Patient", 150, "Test case");
        
        System.out.println("\nValidation Statistics:");
        System.out.println(system.getStatistics());
    }
    
    static class Patient {
        private String name;
        private int age;
        private String condition;
        
        public Patient(String name, int age, String condition) {
            this.name = name;
            this.age = age;
            this.condition = condition;
        }
        
        public String getSummary() {
            return String.format("%s, %d years old - %s", name, age, condition);
        }
    }
    
    static class PatientRegistrationSystem {
        private int successfulRegistrations = 0;
        private int failedRegistrations = 0;
        private StringBuilder log = new StringBuilder();
        
        public void registerPatient(String name, int age, String condition) {
            try {
                System.out.println("Registering patient: " + name);
                validateAge(age);
                
                Patient patient = new Patient(name, age, condition);
                successfulRegistrations++;
                
                System.out.println("  ✓ Registration successful");
                log.append("SUCCESS: ").append(name).append(" (age ").append(age).append(")\n");
                
            } catch (IllegalArgumentException e) {
                failedRegistrations++;
                System.out.println("  ✗ Registration failed: " + e.getMessage());
                log.append("FAILED: ").append(name).append(" (age ").append(age).append(") - ")
                    .append(e.getMessage()).append("\n");
            }
        }
        
        public String getStatistics() {
            return String.format(
                "Total Attempts: %d\n" +
                "Successful: %d\n" +
                "Failed: %d\n" +
                "Success Rate: %.1f%%\n\n" +
                "Registration Log:\n%s",
                successfulRegistrations + failedRegistrations,
                successfulRegistrations,
                failedRegistrations,
                (successfulRegistrations * 100.0) / (successfulRegistrations + failedRegistrations),
                log.toString()
            );
        }
    }
}
