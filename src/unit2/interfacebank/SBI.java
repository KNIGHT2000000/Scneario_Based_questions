package unit2.interfacebank;

public class SBI implements Bank {
    private String branchName;
    private String branchCode;
    
    public SBI(String branchName, String branchCode) {
        this.branchName = branchName;
        this.branchCode = branchCode;
    }
    
    @Override
    public void displayRate() {
        System.out.println("State Bank of India (SBI)");
        System.out.println("Branch: " + branchName);
        System.out.println("Branch Code: " + branchCode);
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("Note: This is the standard bank rate");
    }
    
    @Override
    public void calculateInterest(double principal, int years) {
        double interest = principal * (rate / 100) * years;
        System.out.println("SBI Interest Calculation:");
        System.out.println("Principal Amount: $" + principal);
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("Period: " + years + " years");
        System.out.println("Simple Interest: $" + interest);
        System.out.println("Total Amount: $" + (principal + interest));
    }
    
    @Override
    public void showBankDetails() {
        System.out.println("=== State Bank of India ===");
        System.out.println("Branch Name: " + branchName);
        System.out.println("Branch Code: " + branchCode);
        System.out.println("Type: Public Sector Bank");
        System.out.println("Founded: 1955");
        System.out.println("Headquarters: Mumbai, India");
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("========================");
    }
    
    // Attempt to modify interface variable - this will cause compile-time error
    /*
    public void modifyRate() {
        rate = 12.0; // This will not compile - interface variables are final
        System.out.println("Modified rate to: " + rate + "%");
    }
    */
    
    // This method shows what happens when we try to modify the rate
    public void attemptRateModification() {
        System.out.println("Attempting to modify interest rate...");
        System.out.println("Original rate: " + rate + "%");
        
        // The following line would cause compile-time error:
        // rate = 12.0; // Cannot assign a value to final variable 'rate'
        
        System.out.println("Cannot modify interface variable 'rate' - it is final");
        System.out.println("Interface variables are implicitly public, static, and final");
        
        // We can create a local variable instead
        double modifiedRate = rate + 2.0;
        System.out.println("Local modified rate: " + modifiedRate + "% (for demonstration only)");
        System.out.println("Original interface rate remains unchanged: " + rate + "%");
    }
    
    // Additional SBI-specific methods
    public void displaySBIServices() {
        System.out.println("SBI Services:");
        System.out.println("- Personal Banking");
        System.out.println("- Corporate Banking");
        System.out.println("- International Banking");
        System.out.println("- Agricultural Banking");
        System.out.println("- NRI Banking");
    }
    
    public void showSBIOffers() {
        System.out.println("Current SBI Offers:");
        System.out.println("- Home Loan at " + (rate - 1.0) + "% interest");
        System.out.println("- Car Loan at " + (rate + 0.5) + "% interest");
        System.out.println("- Personal Loan at " + (rate + 2.0) + "% interest");
        System.out.println("(All rates based on standard bank rate: " + rate + "%)");
    }
}
