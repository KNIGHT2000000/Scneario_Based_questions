package unit2.hospitaladvanced;

public class Doctor extends Person implements Payable {
    private String doctorId;
    private String specialization;
    private double consultationFee;
    private int yearsOfExperience;
    private boolean available;
    
    public Doctor(String name, int age, String gender, String address, String phoneNumber,
                  String doctorId, String specialization, double consultationFee, int yearsOfExperience) {
        super(name, age, gender, address, phoneNumber);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.consultationFee = consultationFee >= 0 ? consultationFee : 0.0;
        this.yearsOfExperience = yearsOfExperience >= 0 ? yearsOfExperience : 0;
        this.available = true;
    }
    
    // Getters
    public String getDoctorId() {
        return doctorId;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public double getConsultationFee() {
        return consultationFee;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    // Setters
    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee >= 0 ? consultationFee : 0.0;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    // Abstract method implementation
    @Override
    public String getRole() {
        return "Doctor";
    }
    
    @Override
    public void displayDetails() {
        System.out.println("=== Doctor Information ===");
        displayBasicInfo();
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: $" + consultationFee);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Availability: " + (available ? "Available" : "Not Available"));
        System.out.println("========================");
    }
    
    // Payable interface implementation
    @Override
    public double calculatePayment() {
        // Base salary + experience bonus + specialization bonus
        double baseSalary = 8000.0;
        double experienceBonus = yearsOfExperience * 200.0;
        double specializationBonus = getSpecializationBonus();
        return baseSalary + experienceBonus + specializationBonus;
    }
    
    @Override
    public String getPaymentDetails() {
        return "Dr. " + name + " - " + specialization + " (ID: " + doctorId + ")";
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing salary payment of $" + amount + " for Dr. " + name);
        System.out.println("Payment method: Direct Bank Transfer");
        System.out.println("Payment status: Completed");
    }
    
    // Doctor-specific methods
    public void conductConsultation() {
        if (available) {
            System.out.println("Dr. " + name + " is conducting consultation...");
            System.out.println("Specialization: " + specialization);
            System.out.println("Consultation fee: $" + consultationFee);
        } else {
            System.out.println("Dr. " + name + " is not available for consultation");
        }
    }
    
    public void prescribeMedicine(String medicine, String dosage) {
        System.out.println("Dr. " + name + " prescribed:");
        System.out.println("Medicine: " + medicine);
        System.out.println("Dosage: " + dosage);
    }
    
    public void performDiagnosis(String diagnosis) {
        System.out.println("Dr. " + name + " diagnosed: " + diagnosis);
    }
    
    private double getSpecializationBonus() {
        switch (specialization.toLowerCase()) {
            case "cardiology":
            case "neurosurgery":
                return 2000.0;
            case "orthopedics":
            case "pediatrics":
                return 1500.0;
            case "general":
                return 1000.0;
            default:
                return 1200.0;
        }
    }
    
    @Override
    public void generateInvoice() {
        System.out.println("=== Doctor Salary Invoice ===");
        Payable.super.generateInvoice();
        System.out.println("Base Salary: $8000.0");
        System.out.println("Experience Bonus: $" + (yearsOfExperience * 200.0));
        System.out.println("Specialization Bonus: $" + getSpecializationBonus());
        System.out.println("Total Salary: $" + calculatePayment());
    }
}
