package unit2.hospitaladvanced;

public interface Payable {
    double calculatePayment();
    String getPaymentDetails();
    void processPayment(double amount);
    
    // Default method (Java 8+)
    default void generateInvoice() {
        System.out.println("Generating invoice...");
        System.out.println("Payment Details: " + getPaymentDetails());
        System.out.println("Amount Due: $" + calculatePayment());
        System.out.println("Invoice generated successfully.");
    }
    
    // Static method (Java 8+)
    static void displayPaymentPolicies() {
        System.out.println("Hospital Payment Policies:");
        System.out.println("1. Payment due within 30 days of service");
        System.out.println("2. Late payment fee: 2% per month");
        System.out.println("3. Multiple payment methods accepted");
        System.out.println("4. Insurance claims processed separately");
    }
}
