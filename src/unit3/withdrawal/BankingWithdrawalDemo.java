package unit3.withdrawal;

import java.util.Scanner;

public class BankingWithdrawalDemo {
    public static void main(String[] args) {
        System.out.println("=== Banking Withdrawal System ===\n");
        
        System.out.println("Withdrawal Policy:");
        System.out.println("• Cannot withdraw more than available balance");
        System.out.println("• Minimum withdrawal: $10.00");
        System.out.println("• Maximum withdrawal: $10,000.00");
        System.out.println("• Overdraft protection available for qualified accounts\n");
        
        // Create banking system
        BankingSystem bank = new BankingSystem();
        
        // Demonstrate withdrawal scenarios
        demonstrateWithdrawalScenarios(bank);
        
        System.out.println("\n=== Interactive Withdrawal Demo ===\n");
        interactiveWithdrawalDemo(bank);
        
        System.out.println("\n=== System Analysis ===\n");
        analyzeWithdrawalSystem();
    }
    
    public static void demonstrateWithdrawalScenarios(BankingSystem bank) {
        System.out.println("1. Normal Withdrawal:");
        try {
            bank.withdraw("ACC001", 500.0);
        } catch (InsufficientBalanceException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        
        System.out.println("\n2. Insufficient Balance:");
        try {
            bank.withdraw("ACC001", 2000.0); // Should fail - only $1000 available
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed:");
            System.out.println("  " + e.getErrorMessage());
            System.out.println("  Shortfall: $" + String.format("%.2f", e.getShortfall()));
            System.out.println("  Advice: " + e.getWithdrawalAdvice());
        }
        
        System.out.println("\n3. Large Withdrawal Attempt:");
        try {
            bank.withdraw("ACC002", 8000.0); // Should fail - only $5000 available
        } catch (InsufficientBalanceException e) {
            System.out.println("Large withdrawal failed:");
            System.out.println("  Requested: $" + String.format("%.2f", e.getRequestedAmount()));
            System.out.println("  Available: $" + String.format("%.2f", e.getAvailableBalance()));
            System.out.println("  Shortfall: $" + String.format("%.2f", e.getShortfall()));
        }
        
        System.out.println("\n4. Account with Overdraft Protection:");
        try {
            bank.withdraw("ACC003", 6000.0); // Should succeed with overdraft
        } catch (InsufficientBalanceException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        
        System.out.println("\n5. Edge Case - Exact Balance:");
        try {
            bank.withdraw("ACC004", 2500.0); // Should succeed - exact balance
        } catch (InsufficientBalanceException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        
        System.out.println("\n6. Edge Case - Over by Small Amount:");
        try {
            bank.withdraw("ACC004", 2500.01); // Should fail - over by $0.01
        } catch (InsufficientBalanceException e) {
            System.out.println("Small overdraft attempt:");
            System.out.println("  " + e.getWithdrawalAdvice());
        }
    }
    
    public static void interactiveWithdrawalDemo(BankingSystem bank) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Interactive Withdrawal System");
        System.out.println("Available accounts:");
        bank.displayAllAccounts();
        System.out.println("Enter 'quit' to exit\n");
        
        while (true) {
            try {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                
                if (accountNumber.equalsIgnoreCase("quit")) {
                    break;
                }
                
                System.out.print("Enter withdrawal amount: ");
                String amountStr = scanner.nextLine();
                
                if (amountStr.equalsIgnoreCase("quit")) {
                    break;
                }
                
                double amount = Double.parseDouble(amountStr);
                
                bank.withdraw(accountNumber, amount);
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount format. Please enter a number.");
                
            } catch (InsufficientBalanceException e) {
                System.out.println("Withdrawal Failed:");
                System.out.println(e);
                
            } catch (Exception e) {
                System.out.println("System error: " + e.getMessage());
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static void analyzeWithdrawalSystem() {
        System.out.println("InsufficientBalanceException Benefits:");
        System.out.println();
        
        System.out.println("1. Business Logic Enforcement:");
        System.out.println("   ✓ Prevents overdrawing accounts");
        System.out.println("   ✓ Maintains financial integrity");
        System.out.println("   ✓ Enforces banking rules");
        System.out.println("   ✓ Protects against fraud");
        System.out.println();
        
        System.out.println("2. Rich Error Information:");
        System.out.println("   ✓ Account details (number, holder)");
        System.out.println("   ✓ Financial details (requested, available)");
        System.out.println("   ✓ Shortfall calculation");
        System.out.println("   ✓ Actionable advice");
        System.out.println();
        
        System.out.println("3. User Experience:");
        System.out.println("   ✓ Clear error messages");
        System.out.println("   ✓ Helpful suggestions");
        System.out.println("   ✓ Contextual information");
        System.out.println("   ✓ Guidance for resolution");
        System.out.println();
        
        System.out.println("4. System Reliability:");
        System.out.println("   ✓ Graceful error handling");
        System.out.println("   ✓ No account corruption");
        System.out.println("   ✓ Transaction integrity");
        System.out.println("   ✓ Audit trail maintenance");
        System.out.println();
        
        System.out.println("5. Comparison with Generic Exceptions:");
        System.out.println("   Generic Exception:");
        System.out.println("   - throw new Exception('Insufficient funds')");
        System.out.println("   - Limited information");
        System.out.println("   - Hard to provide specific help");
        System.out.println();
        
        System.out.println("   Custom Exception:");
        System.out.println("   - throw new InsufficientBalanceException(...)");
        System.out.println("   - Rich context information");
        System.out.println("   - Business-specific methods");
        System.out.println("   - Better error recovery");
    }
    
    static class BankingSystem {
        private java.util.Map<String, BankAccount> accounts = new java.util.HashMap<>();
        
        public BankingSystem() {
            // Initialize sample accounts
            accounts.put("ACC001", new BankAccount("ACC001", "John Smith", 1000.0, false));
            accounts.put("ACC002", new BankAccount("ACC002", "Alice Johnson", 5000.0, false));
            accounts.put("ACC003", new BankAccount("ACC003", "Bob Wilson", 3000.0, true)); // Overdraft protection
            accounts.put("ACC004", new BankAccount("ACC004", "Carol Davis", 2500.0, false));
        }
        
        public void withdraw(String accountNumber, double amount) throws InsufficientBalanceException {
            BankAccount account = accounts.get(accountNumber);
            
            if (account == null) {
                throw new IllegalArgumentException("Account not found: " + accountNumber);
            }
            
            if (amount < 10.0) {
                throw new IllegalArgumentException("Minimum withdrawal is $10.00");
            }
            
            if (amount > 10000.0) {
                throw new IllegalArgumentException("Maximum withdrawal is $10,000.00");
            }
            
            double availableBalance = account.getAvailableBalance();
            
            if (amount > availableBalance) {
                throw new InsufficientBalanceException(
                    amount, 
                    availableBalance, 
                    accountNumber, 
                    account.getAccountHolder()
                );
            }
            
            // Process withdrawal
            account.withdraw(amount);
            
            System.out.println("✓ Withdrawal successful:");
            System.out.println("  Account: " + accountNumber + " (" + account.getAccountHolder() + ")");
            System.out.println("  Amount: $" + String.format("%.2f", amount));
            System.out.println("  New balance: $" + String.format("%.2f", account.getBalance()));
            
            if (account.hasOverdraftProtection() && amount > account.getBalance()) {
                System.out.println("  Overdraft used: $" + String.format("%.2f", amount - account.getBalance()));
            }
        }
        
        public void displayAllAccounts() {
            System.out.println("Available Accounts:");
            for (BankAccount account : accounts.values()) {
                System.out.println("  " + account.getAccountNumber() + " - " + 
                                 account.getAccountHolder() + " - Balance: $" + 
                                 String.format("%.2f", account.getBalance()) +
                                 (account.hasOverdraftProtection() ? " (Overdraft)" : ""));
            }
        }
    }
    
    static class BankAccount {
        private String accountNumber;
        private String accountHolder;
        private double balance;
        private boolean overdraftProtection;
        private double overdraftLimit = 1000.0;
        
        public BankAccount(String accountNumber, String accountHolder, double balance, boolean overdraftProtection) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
            this.overdraftProtection = overdraftProtection;
        }
        
        public void withdraw(double amount) {
            balance -= amount;
        }
        
        public double getAvailableBalance() {
            if (overdraftProtection) {
                return balance + overdraftLimit;
            }
            return balance;
        }
        
        // Getters
        public String getAccountNumber() { return accountNumber; }
        public String getAccountHolder() { return accountHolder; }
        public double getBalance() { return balance; }
        public boolean hasOverdraftProtection() { return overdraftProtection; }
        public double getOverdraftLimit() { return overdraftLimit; }
    }
}
