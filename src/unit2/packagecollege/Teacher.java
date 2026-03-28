package unit2.packagecollege;

public class Teacher {
    public String publicName;
    private String privateSalary;
    protected String protectedDepartment;
    
    // Package-private (no modifier)
    String packageAddress;
    
    public Teacher(String publicName, String privateSalary, String protectedDepartment, String packageAddress) {
        this.publicName = publicName;
        this.privateSalary = privateSalary;
        this.protectedDepartment = protectedDepartment;
        this.packageAddress = packageAddress;
    }
    
    // Public method - accessible from anywhere
    public void displayPublicInfo() {
        System.out.println("=== Public Information ===");
        System.out.println("Name (public): " + publicName);
        System.out.println("This information can be accessed from any package");
    }
    
    // Private method - accessible only within this class
    private void displayPrivateInfo() {
        System.out.println("=== Private Information ===");
        System.out.println("Salary (private): " + privateSalary);
        System.out.println("This information can only be accessed within Teacher class");
    }
    
    // Protected method - accessible within package and subclasses
    protected void displayProtectedInfo() {
        System.out.println("=== Protected Information ===");
        System.out.println("Department (protected): " + protectedDepartment);
        System.out.println("This information can be accessed within package and by subclasses");
    }
    
    // Package-private method - accessible only within same package
    void displayPackageInfo() {
        System.out.println("=== Package Information ===");
        System.out.println("Address (package-private): " + packageAddress);
        System.out.println("This information can only be accessed within the same package");
    }
    
    // Public method that calls private method (indirect access)
    public void showSalaryInfo() {
        System.out.println("Accessing private salary through public method:");
        displayPrivateInfo();
    }
    
    // Method to demonstrate all access levels
    public void demonstrateAccessLevels() {
        System.out.println("=== Access Level Demonstration within Teacher Class ===");
        displayPublicInfo();     // ✓ Always accessible
        displayPrivateInfo();     // ✓ Accessible within same class
        displayProtectedInfo();    // ✓ Accessible within same class
        displayPackageInfo();     // ✓ Accessible within same package
        System.out.println();
        
        // Direct field access within class
        System.out.println("Direct field access within Teacher class:");
        System.out.println("publicName: " + publicName);        // ✓ Always accessible
        System.out.println("privateSalary: " + privateSalary);    // ✓ Accessible within same class
        System.out.println("protectedDepartment: " + protectedDepartment); // ✓ Accessible within same class
        System.out.println("packageAddress: " + packageAddress);  // ✓ Accessible within same package
    }
}
