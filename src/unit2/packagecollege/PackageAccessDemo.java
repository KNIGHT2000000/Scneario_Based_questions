package unit2.packagecollege;

public class PackageAccessDemo {
    public static void main(String[] args) {
        System.out.println("=== Package Access Control Comprehensive Demo ===\n");
        
        System.out.println("=== Access Modifiers in Java ===\n");
        
        System.out.println("1. Public: Accessible from anywhere");
        System.out.println("2. Private: Accessible only within the same class");
        System.out.println("3. Protected: Accessible within same package and subclasses");
        System.out.println("4. Package-Private: Accessible only within same package (no modifier)");
        System.out.println();
        
        System.out.println("=== Test Scenarios ===\n");
        
        System.out.println("Scenario 1: Same Package Access");
        System.out.println("Running CollegeTest (same package as Teacher)...");
        CollegeTest.main(new String[]{});
        System.out.println();
        
        System.out.println("=== Scenario 2: Different Package Access ===");
        System.out.println("Running OtherPackageTest (different package)...");
        unit2.packagecollege.subpackage.OtherPackageTest.main(new String[]{});
        System.out.println();
        
        System.out.println("=== Scenario 3: Subclass Access ===");
        System.out.println("Testing SubTeacher (subclass in different package)...");
        SubTeacher subTeacher = new SubTeacher("Dr. Wilson", "$85000", "Physics", "789 Campus Dr", "Quantum Mechanics");
        subTeacher.demonstrateSubclassAccess();
        System.out.println();
        
        System.out.println("=== Access Modifier Summary Table ===\n");
        
        System.out.println("+------------------+---------+----------+------------+--------+");
        System.out.println("| Modifier         | Class   | Package  | Subclass   | World  |");
        System.out.println("+------------------+---------+----------+------------+--------+");
        System.out.println("| public           |    ✓    |    ✓     |     ✓      |   ✓    |");
        System.out.println("| protected        |    ✓    |    ✓     |     ✓      |   ✗    |");
        System.out.println("| package-private  |    ✓    |    ✓     |     ✗      |   ✗    |");
        System.out.println("| private          |    ✓    |    ✗     |     ✗      |   ✗    |");
        System.out.println("+------------------+---------+----------+------------+--------+");
        System.out.println();
        
        System.out.println("=== Key Points ===\n");
        
        System.out.println("Public:");
        System.out.println("- Most accessible modifier");
        System.out.println("- Can be accessed from any class, any package");
        System.out.println("- Use for API methods and public constants");
        System.out.println();
        
        System.out.println("Private:");
        System.out.println("- Most restrictive modifier");
        System.out.println("- Only accessible within the same class");
        System.out.println("- Use for internal implementation details");
        System.out.println("- Encapsulation: hide data, expose methods");
        System.out.println();
        
        System.out.println("Protected:");
        System.out.println("- Accessible within same package AND subclasses");
        System.out.println("- Allows inheritance while maintaining some restriction");
        System.out.println("- Use for methods/fields needed by subclasses");
        System.out.println();
        
        System.out.println("Package-Private (no modifier):");
        System.out.println("- Accessible only within same package");
        System.out.println("- Default access level in Java");
        System.out.println("- Use for package-internal implementation");
        System.out.println();
        
        System.out.println("=== Best Practices ===\n");
        
        System.out.println("1. Principle of Least Privilege:");
        System.out.println("   - Use the most restrictive access that works");
        System.out.println("   - Start with private, relax as needed");
        System.out.println("   - Don't expose more than necessary");
        System.out.println();
        
        System.out.println("2. Encapsulation:");
        System.out.println("   - Keep fields private");
        System.out.println("   - Provide public getter/setter methods");
        System.out.println("   - Validate data in setters");
        System.out.println();
        
        System.out.println("3. API Design:");
        System.out.println("   - Public methods form the API");
        System.out.println("   - Protected methods for extension points");
        System.out.println("   - Private methods for internal logic");
        System.out.println();
        
        System.out.println("4. Package Organization:");
        System.out.println("   - Related classes in same package");
        System.out.println("   - Package-private for package cohesion");
        System.out.println("   - Public for external access");
        
        System.out.println("\n=== Compile-Time Errors ===");
        System.out.println("When you try to access members with wrong visibility:");
        System.out.println("- Private: 'has private access in [class]'"); 
        System.out.println("- Protected: 'has protected access in [class]'");
        System.out.println("- Package-private: 'not visible' or 'has package access'");
        System.out.println("These errors prevent compilation - security at compile time!");
    }
}
