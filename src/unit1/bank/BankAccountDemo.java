package unit1.bank;

public class BankAccountDemo {
    public static void main(String[] args) {
        System.out.println("=== Bank Account System Demo ===\n");
        
        BankAccount account1 = new BankAccount("ACC123456", 1000.0);
        BankAccount account2 = new BankAccount("ACC789012", 500.0);
        
        System.out.println("Initial Account Details:");
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        
        System.out.println("\nDemonstrating Deposit Operations:");
        account1.deposit(500.0);
        account2.deposit(200.0);
        
        System.out.println("\nDemonstrating Withdrawal Operations:");
        account1.withdraw(300.0);
        account2.withdraw(100.0);
        
        System.out.println("\nTesting Edge Cases:");
        account1.withdraw(2000.0); // Insufficient funds
        account2.deposit(-50.0);   // Negative deposit
        account1.withdraw(-100.0); // Negative withdrawal
        
        System.out.println("\nFinal Account Details:");
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        
        System.out.println("\nEncapsulation Demonstration:");
        System.out.println("- Private data members: accountNumber, balance");
        System.out.println("- Public methods provide controlled access");
        System.out.println("- Validation ensures data integrity");
        System.out.println("- Unauthorized direct access prevented");
    }
}
