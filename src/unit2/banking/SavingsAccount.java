package unit2.banking;

public class SavingsAccount extends Bank {
    private String accountNumber;
    private double balance;
    
    public SavingsAccount(String bankName, String branchCode, String accountNumber, double balance) {
        super(bankName, branchCode);
        this.accountNumber = accountNumber;
        this.balance = balance >= 0 ? balance : 0.0;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " to account " + accountNumber);
            System.out.println("New Balance: $" + balance);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " from account " + accountNumber);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
    
    public void displayAccountInfo() {
        System.out.println("Savings Account Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        displayBankInfo();
    }
    
    // Try to override final method - this will cause compile-time error
    /*
    @Override
    public void displayRate() {
        System.out.println("Attempting to override final method - This will not compile!");
        System.out.println("Modified rate: 6.0%");
    }
    */
    
    // This method shows that we can create new methods but cannot override final ones
    public void displaySavingsRate() {
        System.out.println("Savings Account Special Rate:");
        System.out.println("Base Bank Rate: " + INTEREST_RATE + "%");
        System.out.println("Savings Bonus: +0.5%");
        System.out.println("Effective Rate: " + (INTEREST_RATE + 0.5) + "%");
    }
}
