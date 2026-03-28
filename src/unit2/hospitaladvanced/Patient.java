package unit2.hospitaladvanced;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person implements Payable {
    private String patientId;
    private String disease;
    private Date admissionDate;
    private Date dischargeDate;
    private ArrayList<String> treatments;
    private double totalBill;
    private boolean insured;
    private String insuranceProvider;
    
    public Patient(String name, int age, String gender, String address, String phoneNumber,
                   String patientId, String disease, boolean insured, String insuranceProvider) {
        super(name, age, gender, address, phoneNumber);
        this.patientId = patientId;
        this.disease = disease;
        this.admissionDate = new Date(); // Current date
        this.dischargeDate = null; // Not discharged yet
        this.treatments = new ArrayList<>();
        this.totalBill = 0.0;
        this.insured = insured;
        this.insuranceProvider = insuranceProvider;
    }
    
    // Getters
    public String getPatientId() {
        return patientId;
    }
    
    public String getDisease() {
        return disease;
    }
    
    public Date getAdmissionDate() {
        return admissionDate;
    }
    
    public Date getDischargeDate() {
        return dischargeDate;
    }
    
    public ArrayList<String> getTreatments() {
        return new ArrayList<>(treatments);
    }
    
    public double getTotalBill() {
        return totalBill;
    }
    
    public boolean isInsured() {
        return insured;
    }
    
    public String getInsuranceProvider() {
        return insuranceProvider;
    }
    
    // Setters
    public void setDisease(String disease) {
        this.disease = disease;
    }
    
    public void setInsured(boolean insured, String insuranceProvider) {
        this.insured = insured;
        this.insuranceProvider = insuranceProvider;
    }
    
    // Abstract method implementation
    @Override
    public String getRole() {
        return "Patient";
    }
    
    @Override
    public void displayDetails() {
        System.out.println("=== Patient Information ===");
        displayBasicInfo();
        System.out.println("Patient ID: " + patientId);
        System.out.println("Disease: " + disease);
        System.out.println("Admission Date: " + admissionDate);
        if (dischargeDate != null) {
            System.out.println("Discharge Date: " + dischargeDate);
        } else {
            System.out.println("Status: Admitted");
        }
        System.out.println("Total Bill: $" + totalBill);
        System.out.println("Insurance: " + (insured ? "Yes (" + insuranceProvider + ")" : "No"));
        System.out.println("Treatments (" + treatments.size() + "):");
        for (int i = 0; i < treatments.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + treatments.get(i));
        }
        System.out.println("========================");
    }
    
    // Payable interface implementation
    @Override
    public double calculatePayment() {
        double payableAmount = totalBill;
        if (insured) {
            // Insurance covers 80% of the bill
            payableAmount = totalBill * 0.2;
        }
        return payableAmount;
    }
    
    @Override
    public String getPaymentDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Patient: ").append(name).append(" (ID: ").append(patientId).append(")\n");
        details.append("Total Bill: $").append(totalBill).append("\n");
        if (insured) {
            details.append("Insurance Coverage: ").append(insuranceProvider).append(" (80%)\n");
            details.append("Patient Payment: $").append(calculatePayment());
        } else {
            details.append("Insurance: None - Full payment required");
        }
        return details.toString();
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing patient payment of $" + amount + " for " + name);
        if (insured) {
            System.out.println("Insurance claim processed for: $" + (totalBill - amount));
            System.out.println("Patient co-payment: $" + amount);
        } else {
            System.out.println("Full payment received: $" + amount);
        }
        System.out.println("Payment status: Completed");
    }
    
    // Patient-specific methods
    public void addTreatment(String treatment, double cost) {
        treatments.add(treatment);
        totalBill += cost;
        System.out.println("Treatment added for " + name + ": " + treatment + " ($" + cost + ")");
    }
    
    public void discharge() {
        this.dischargeDate = new Date();
        System.out.println("Patient " + name + " discharged on " + dischargeDate);
    }
    
    public void prescribeMedication(String medication, double cost) {
        addTreatment("Medication: " + medication, cost);
    }
    
    public void undergoSurgery(String surgeryType, double cost) {
        addTreatment("Surgery: " + surgeryType, cost);
    }
    
    public void undergoTest(String testName, double cost) {
        addTreatment("Test: " + testName, cost);
    }
    
    @Override
    public void generateInvoice() {
        System.out.println("=== Patient Bill Invoice ===");
        Payable.super.generateInvoice();
        System.out.println("\nDetailed Bill:");
        System.out.println("Admission Date: " + admissionDate);
        if (dischargeDate != null) {
            System.out.println("Discharge Date: " + dischargeDate);
        }
        System.out.println("\nTreatments and Costs:");
        for (int i = 0; i < treatments.size(); i++) {
            System.out.println((i + 1) + ". " + treatments.get(i));
        }
        System.out.println("\nTotal Bill: $" + totalBill);
        if (insured) {
            System.out.println("Insurance Coverage: $" + (totalBill * 0.8) + " (80%)");
            System.out.println("Patient Responsibility: $" + calculatePayment());
        } else {
            System.out.println("Patient Responsibility: $" + totalBill + " (100%)");
        }
    }
}
