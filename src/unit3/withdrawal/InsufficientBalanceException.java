package unit3.withdrawal;

public class InsufficientBalanceException extends Exception {
    private final double requestedAmount;
    private final double availableBalance;
    private final String accountNumber;
    private final String accountHolder;
    
    public InsufficientBalanceException(double requestedAmount, double availableBalance, 
                                      String accountNumber, String accountHolder) {
        super(String.format("Insufficient balance for account %s (%s): Requested $%.2f, Available $%.2f", 
                           accountNumber, accountHolder, requestedAmount, availableBalance));
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }
    
    public InsufficientBalanceException(double requestedAmount, double availableBalance, 
                                      String accountNumber, String accountHolder, String customMessage) {
        super(customMessage);
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }
    
    public double getRequestedAmount() {
        return requestedAmount;
    }
    
    public double getAvailableBalance() {
        return availableBalance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getShortfall() {
        return requestedAmount - availableBalance;
    }
    
    public boolean isOverdrawn() {
        return requestedAmount > availableBalance;
    }
    
    public String getWithdrawalAdvice() {
        double shortfall = getShortfall();
        
        if (shortfall <= 50) {
            return String.format("You need only $%.2f more. Consider a small deposit or overdraft protection.", shortfall);
        } else if (shortfall <= 200) {
            return String.format("You need $%.2f more. Consider transferring funds or applying for overdraft.", shortfall);
        } else {
            return String.format("You need $%.2f more. Consider a larger deposit or loan application.", shortfall);
        }
    }
    
    public String getSuggestedActions() {
        StringBuilder suggestions = new StringBuilder();
        suggestions.append("Suggested actions:\n");
        suggestions.append("1. Deposit additional funds\n");
        suggestions.append("2. Transfer money from another account\n");
        suggestions.append("3. Apply for overdraft protection\n");
        suggestions.append("4. Request a temporary credit line\n");
        suggestions.append("5. Reduce withdrawal amount to $").append(String.format("%.2f", availableBalance));
        
        return suggestions.toString();
    }
    
    @Override
    public String toString() {
        return String.format(
            "InsufficientBalanceException:\n" +
            "Account: %s (%s)\n" +
            "Account Number: %s\n" +
            "Requested Amount: $%.2f\n" +
            "Available Balance: $%.2f\n" +
            "Shortfall: $%.2f\n" +
            "Advice: %s\n" +
            "%s",
            accountHolder, accountNumber, accountNumber, requestedAmount, 
            availableBalance, getShortfall(), getWithdrawalAdvice(), getSuggestedActions()
        );
    }
}
