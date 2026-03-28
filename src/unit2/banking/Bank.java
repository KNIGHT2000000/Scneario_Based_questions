package unit2.banking;

public class Bank {
    // Final variable - cannot be changed once initialized
    public static final double INTEREST_RATE = 5.5;
    
    private String bankName;
    private String branchCode;
    
    public Bank(String bankName, String branchCode) {
        this.bankName = bankName;
        this.branchCode = branchCode;
    }
    
    public String getBankName() {
        return bankName;
    }
    
    public String getBranchCode() {
        return branchCode;
    }
    
    // Final method - cannot be overridden by subclasses
    public final void displayRate() {
        System.out.println("Bank Interest Rate: " + INTEREST_RATE + "%");
        System.out.println("This rate is fixed and cannot be changed.");
        System.out.println("Bank: " + bankName);
        System.out.println("Branch: " + branchCode);
        System.out.println("------------------------");
    }
    
    public void calculateInterest(double principal, int years) {
        double interest = principal * (INTEREST_RATE / 100) * years;
        System.out.println("Interest Calculation:");
        System.out.println("Principal: $" + principal);
        System.out.println("Rate: " + INTEREST_RATE + "%");
        System.out.println("Years: " + years);
        System.out.println("Interest: $" + interest);
        System.out.println("Total Amount: $" + (principal + interest));
        System.out.println("------------------------");
    }
    
    public void displayBankInfo() {
        System.out.println("Bank Information:");
        System.out.println("Name: " + bankName);
        System.out.println("Branch Code: " + branchCode);
        System.out.println("Interest Rate: " + INTEREST_RATE + "%");
    }
}
