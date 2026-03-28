package unit2.packagecollege.subpackage;

import unit2.packagecollege.Teacher;

public class OtherPackageTest {
    public static void main(String[] args) {
        System.out.println("=== Package Access Control Test (Different Package) ===\n");
        
        Teacher teacher = new Teacher("Dr. Johnson", "$80000", "Mathematics", "456 University Blvd");
        
        System.out.println("=== Accessing from Different Package (unit2.packagecollege.subpackage) ===\n");
        
        System.out.println("1. Public Access:");
        System.out.println("   publicName: " + teacher.publicName); // ✓ Accessible from any package
        teacher.displayPublicInfo(); // ✓ Accessible from any package
        System.out.println();
        
        System.out.println("2. Protected Access:");
        // System.out.println("protectedDepartment: " + teacher.protectedDepartment); // ✗ Not accessible (different package)
        // teacher.displayProtectedInfo(); // ✗ Not accessible (different package, not subclass)
        System.out.println("   Cannot access protected members from different package");
        System.out.println("   (Would be accessible if this was a subclass)");
        System.out.println();
        
        System.out.println("3. Package-Private Access:");
        // System.out.println("packageAddress: " + teacher.packageAddress); // ✗ Not accessible (different package)
        // teacher.displayPackageInfo(); // ✗ Not accessible (different package)
        System.out.println("   Cannot access package-private members from different package");
        System.out.println();
        
        System.out.println("4. Private Access:");
        // System.out.println("privateSalary: " + teacher.privateSalary); // ✗ Not accessible
        // teacher.displayPrivateInfo(); // ✗ Not accessible
        System.out.println("   Cannot access private members outside class");
        System.out.println();
        
        System.out.println("5. Indirect Access:");
        System.out.println("   Using public methods to access private data:");
        teacher.showSalaryInfo(); // ✓ Indirect access through public method
        System.out.println();
        
        System.out.println("=== Summary for Different Package Access ===");
        System.out.println("✓ Public: Always accessible");
        System.out.println("✗ Protected: Not accessible (different package, not subclass)");
        System.out.println("✗ Package-Private: Not accessible (different package)");
        System.out.println("✗ Private: Not accessible outside class");
    }
}
