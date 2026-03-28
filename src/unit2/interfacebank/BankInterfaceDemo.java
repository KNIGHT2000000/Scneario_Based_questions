package unit2.interfacebank;

public class BankInterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Bank Interface with Constants Demo ===\n");
        
        System.out.println("=== Interface Variable Demonstration ===");
        System.out.println("Bank.rate = " + Bank.rate + "%");
        System.out.println("Interface variables are implicitly:");
        System.out.println("- public (accessible from anywhere)");
        System.out.println("- static (belong to interface, not objects)");
        System.out.println("- final (cannot be modified)");
        System.out.println();
        
        System.out.println("=== Creating SBI Bank Objects ===\n");
        
        SBI sbiMain = new SBI("Main Branch", "SBI001");
        SBI sbiDowntown = new SBI("Downtown Branch", "SBI002");
        
        System.out.println("=== Bank Interface Implementation ===\n");
        
        System.out.println("SBI Main Branch:");
        sbiMain.displayRate();
        System.out.println();
        
        System.out.println("SBI Downtown Branch:");
        sbiDowntown.displayRate();
        System.out.println();
        
        System.out.println("=== Interest Calculations ===\n");
        
        sbiMain.calculateInterest(10000.0, 3);
        System.out.println();
        
        sbiDowntown.calculateInterest(15000.0, 5);
        System.out.println();
        
        System.out.println("=== Attempting to Modify Interface Variable ===\n");
        
        sbiMain.attemptRateModification();
        System.out.println();
        
        System.out.println("=== Compile-time Error Demonstration ===");
        System.out.println("If we uncomment the following line in SBI.java:");
        System.out.println("rate = 12.0;");
        System.out.println();
        System.out.println("We would get this compile-time error:");
        System.out.println("Error: cannot assign a value to final variable 'rate'");
        System.out.println("Reason: Interface variables are implicitly final");
        System.out.println("Solution: Create a local variable or use a different approach");
        System.out.println();
        
        System.out.println("=== Interface Variable Properties ===\n");
        
        System.out.println("1. Accessing interface variable directly:");
        System.out.println("   Bank.rate = " + Bank.rate);
        System.out.println("   (No object needed - it's static)");
        System.out.println();
        
        System.out.println("2. Accessing through implementing class:");
        System.out.println("   SBI.rate = " + SBI.rate);
        System.out.println("   (Inherited from interface)");
        System.out.println();
        
        System.out.println("3. Accessing through object:");
        System.out.println("   sbiMain.rate = " + sbiMain.rate);
        System.out.println("   (Also works but not recommended)");
        System.out.println();
        
        System.out.println("=== Bank Details and Services ===\n");
        
        sbiMain.showBankDetails();
        System.out.println();
        
        sbiMain.displaySBIServices();
        System.out.println();
        
        sbiMain.showSBIOffers();
        System.out.println();
        
        System.out.println("=== Interface Static and Default Methods ===\n");
        
        System.out.println("Calling static method:");
        Bank.displayBankingRules();
        System.out.println();
        
        System.out.println("Calling default method:");
        sbiMain.displayBankingInfo();
        System.out.println();
        
        System.out.println("=== Interface Variable Benefits ===\n");
        
        System.out.println("1. Constants:");
        System.out.println("   - Interface variables serve as constants");
        System.out.println("   - Cannot be accidentally modified");
        System.out.println("   - Shared across all implementing classes");
        System.out.println();
        
        System.out.println("2. Standardization:");
        System.out.println("   - All banks use the same standard rate");
        System.out.println("   - Ensures consistency across implementations");
        System.out.println("   - Easy to maintain and update");
        System.out.println();
        
        System.out.println("3. Memory Efficiency:");
        System.out.println("   - Only one copy exists (static)");
        System.out.println("   - Shared by all implementing classes");
        System.out.println("   - No duplication of constants");
        
        System.out.println("\n=== Comparison with Class Constants ===");
        System.out.println("Interface Constants:");
        System.out.println("- Implicitly public, static, final");
        System.out.println("- No need to specify modifiers");
        System.out.println("- Accessed directly via interface name");
        System.out.println("- Shared across all implementations");
        System.out.println();
        System.out.println("Class Constants:");
        System.out.println("- Need explicit 'public static final' modifiers");
        System.out.println("- Accessed via class name");
        System.out.println("- Specific to that class only");
        System.out.println("- More verbose declaration");
    }
}
