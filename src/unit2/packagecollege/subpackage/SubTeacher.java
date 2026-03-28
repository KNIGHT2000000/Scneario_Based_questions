package unit2.packagecollege.subpackage;

import unit2.packagecollege.Teacher;

public class SubTeacher extends Teacher {
    private String researchArea;
    
    public SubTeacher(String name, String salary, String department, String address, String researchArea) {
        super(name, salary, department, address);
        this.researchArea = researchArea;
    }
    
    public void demonstrateSubclassAccess() {
        System.out.println("=== Subclass Access Demonstration ===\n");
        
        System.out.println("Accessing parent class members from subclass:");
        
        System.out.println("1. Public Access:");
        System.out.println("   publicName: " + publicName); // ✓ Always accessible
        displayPublicInfo(); // ✓ Always accessible
        System.out.println();
        
        System.out.println("2. Protected Access:");
        System.out.println("   protectedDepartment: " + protectedDepartment); // ✓ Accessible in subclass
        displayProtectedInfo(); // ✓ Accessible in subclass
        System.out.println();
        
        System.out.println("3. Package-Private Access:");
        // System.out.println("packageAddress: " + packageAddress); // ✗ Not accessible (different package)
        // displayPackageInfo(); // ✗ Not accessible (different package)
        System.out.println("   Cannot access package-private members from different package");
        System.out.println("   even in subclass");
        System.out.println();
        
        System.out.println("4. Private Access:");
        // System.out.println("privateSalary: " + privateSalary); // ✗ Not accessible
        // displayPrivateInfo(); // ✗ Not accessible
        System.out.println("   Cannot access private members outside class");
        System.out.println("   even in subclass");
        System.out.println();
        
        System.out.println("5. Subclass-specific:");
        System.out.println("   Research Area: " + researchArea);
    }
    
    @Override
    public void displayPublicInfo() {
        System.out.println("=== SubTeacher Public Information (Overridden) ===");
        System.out.println("Name: " + publicName);
        System.out.println("Research Area: " + researchArea);
        System.out.println("This is an overridden method from subclass");
    }
}
