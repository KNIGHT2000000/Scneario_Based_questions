package unit2.interfacebank;

public interface Bank {
    // Interface variables are implicitly public, static, and final
    double rate = 10.0;
    
    // Abstract methods
    void displayRate();
    void calculateInterest(double principal, int years);
    void showBankDetails();
    
    // Default method (Java 8+)
    default void displayBankingInfo() {
        System.out.println("Banking Information:");
        System.out.println("Standard Interest Rate: " + rate + "%");
        System.out.println("This rate is applicable to all member banks");
    }
    
    // Static method (Java 8+)
    static void displayBankingRules() {
        System.out.println("Banking Rules:");
        System.out.println("1. Interest is calculated annually");
        System.out.println("2. Rate cannot be modified by implementing classes");
        System.out.println("3. All member banks follow standard procedures");
    }
}
