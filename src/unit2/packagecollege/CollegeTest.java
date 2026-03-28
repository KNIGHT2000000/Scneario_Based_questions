package unit2.packagecollege;

public class CollegeTest {
    public static void main(String[] args) {
        System.out.println("=== Package Access Control Test (Same Package) ===\n");
        
        Teacher teacher = new Teacher("Dr. Smith", "$75000", "Computer Science", "123 College Ave");
        
        System.out.println("=== Accessing from Same Package (unit2.packagecollege) ===\n");
        
        System.out.println("1. Public Access:");
        System.out.println("   publicName: " + teacher.publicName); // ✓ Accessible
        teacher.displayPublicInfo(); // ✓ Accessible
        System.out.println();
        
        System.out.println("2. Protected Access:");
        System.out.println("   protectedDepartment: " + teacher.protectedDepartment); // ✓ Accessible (same package)
        teacher.displayProtectedInfo(); // ✓ Accessible (same package)
        System.out.println();
        
        System.out.println("3. Package-Private Access:");
        System.out.println("   packageAddress: " + teacher.packageAddress); // ✓ Accessible (same package)
        teacher.displayPackageInfo(); // ✓ Accessible (same package)
        System.out.println();
        
        System.out.println("4. Private Access:");
        // System.out.println("privateSalary: " + teacher.privateSalary); // ✗ Not accessible
        // teacher.displayPrivateInfo(); // ✗ Not accessible
        
        System.out.println("   Cannot access private members directly");
        System.out.println("   Must use public methods for indirect access:");
        teacher.showSalaryInfo(); // ✓ Indirect access through public method
        System.out.println();
        
        System.out.println("=== Summary for Same Package Access ===");
        System.out.println("✓ Public: Always accessible");
        System.out.println("✓ Protected: Accessible (same package)");
        System.out.println("✓ Package-Private: Accessible (same package)");
        System.out.println("✗ Private: Not accessible outside class");
    }
}
