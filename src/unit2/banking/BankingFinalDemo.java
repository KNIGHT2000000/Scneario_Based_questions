package unit2.banking;

public class BankingFinalDemo {
    public static void main(String[] args) {
        System.out.println("=== Banking System with Final Members Demo ===\n");
        
        System.out.println("=== Final Variable Demonstration ===");
        System.out.println("Bank.INTEREST_RATE = " + Bank.INTEREST_RATE + "%");
        System.out.println("Final variables are constants and cannot be modified.");
        
        // Attempting to modify final variable will cause compile-time error
        // Bank.INTEREST_RATE = 6.0; // This would not compile
        
        System.out.println("\n=== Creating Bank Objects ===");
        Bank bank1 = new Bank("National Bank", "NB001");
        SavingsAccount account1 = new SavingsAccount("National Bank", "NB001", "SA123456", 5000.0);
        SavingsAccount account2 = new SavingsAccount("National Bank", "NB002", "SA789012", 7500.0);
        
        System.out.println("\n=== Final Method Demonstration ===");
        System.out.println("Calling final displayRate() method:");
        bank1.displayRate();
        account1.displayRate();
        
        System.out.println("=== Method Overriding Attempt ===");
        System.out.println("The SavingsAccount class cannot override displayRate() method");
        System.out.println("because it is declared as final in Bank class.");
        System.out.println("This ensures consistent interest rate display across all bank types.");
        
        System.out.println("\n=== Alternative Approach ===");
        System.out.println("SavingsAccount can create new methods instead:");
        account1.displaySavingsRate();
        
        System.out.println("\n=== Compile-time Error Demonstration ===");
        System.out.println("If we uncomment the overridden displayRate() method in SavingsAccount:");
        System.out.println("Error: 'displayRate()' in 'unit2.banking.SavingsAccount' cannot override");
        System.out.println("       'displayRate()' in 'unit2.banking.Bank';");
        System.out.println("       overridden method is final");
        System.out.println();
        System.out.println("This is a compile-time error - the code will not compile");
        System.out.println("until the final method override is removed.");
        
        System.out.println("\n=== Benefits of Final Members ===");
        System.out.println("1. Final Variables:");
        System.out.println("   - Create constants that cannot be changed");
        System.out.println("   - Ensure data integrity");
        System.out.println("   - Improve code readability");
        System.out.println("   - Allow compiler optimizations");
        System.out.println();
        System.out.println("2. Final Methods:");
        System.out.println("   - Prevent method overriding");
        System.out.println("   - Ensure consistent behavior");
        System.out.println("   - Security - critical methods cannot be modified");
        System.out.println("   - Performance - allows method inlining");
        
        System.out.println("\n=== Account Operations ===");
        account1.displayAccountInfo();
        account1.deposit(1000.0);
        account1.withdraw(500.0);
        
        System.out.println("\n=== Interest Calculations ===");
        bank1.calculateInterest(account1.getBalance(), 2);
        account2.calculateInterest(account2.getBalance(), 3);
        
        System.out.println("\n=== Final Keyword Usage Summary ===");
        System.out.println("- Final variable: INTEREST_RATE (constant)");
        System.out.println("- Final method: displayRate() (cannot override)");
        System.out.println("- Final class: Not used here, but would prevent inheritance");
        System.out.println("- All provide security and consistency in banking operations");
    }
}
