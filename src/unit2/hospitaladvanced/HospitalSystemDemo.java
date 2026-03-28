package unit2.hospitaladvanced;

import java.util.ArrayList;

public class HospitalSystemDemo {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Hospital Management System Demo ===\n");
        
        initializeHospital();
        
        System.out.println("=== Abstract Class and Interface Demonstration ===\n");
        demonstrateAbstractClass();
        
        System.out.println("\n=== Interface Implementation Demonstration ===\n");
        demonstrateInterface();
        
        System.out.println("\n=== Patient Management with ArrayList ===\n");
        demonstratePatientManagement();
        
        System.out.println("\n=== Overridden Methods Demonstration ===\n");
        demonstrateOverriddenMethods();
        
        System.out.println("\n=== Billing System ===\n");
        demonstrateBillingSystem();
        
        System.out.println("\n=== Polymorphism Demonstration ===\n");
        demonstratePolymorphism();
        
        System.out.println("\n=== System Summary ===\n");
        displaySystemSummary();
    }
    
    public static void initializeHospital() {
        System.out.println("Initializing Hospital System...");
        
        // Create doctors
        Doctor doctor1 = new Doctor("Sarah Johnson", 35, "Female", "123 Main St", "555-0101",
                                   "DOC001", "Cardiology", 150.0, 10);
        Doctor doctor2 = new Doctor("Michael Chen", 42, "Male", "456 Oak Ave", "555-0102",
                                   "DOC002", "Neurosurgery", 200.0, 15);
        Doctor doctor3 = new Doctor("Emily Davis", 38, "Female", "789 Pine Rd", "555-0103",
                                   "DOC003", "Pediatrics", 120.0, 8);
        
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        
        // Create patients
        Patient patient1 = new Patient("John Smith", 45, "Male", "111 Elm St", "555-1001",
                                     "PAT001", "Heart Disease", true, "HealthPlus");
        Patient patient2 = new Patient("Mary Johnson", 32, "Female", "222 Maple Dr", "555-1002",
                                     "PAT002", "Migraine", false, "");
        Patient patient3 = new Patient("Robert Wilson", 28, "Male", "333 Cedar Ln", "555-1003",
                                     "PAT003", "Fracture", true, "MediCare");
        
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        
        System.out.println("Hospital initialized with " + doctors.size() + " doctors and " + 
                          patients.size() + " patients.");
    }
    
    public static void demonstrateAbstractClass() {
        System.out.println("Abstract Class (Person) Demonstration:");
        System.out.println("- Person is abstract - cannot be instantiated directly");
        System.out.println("- Provides common properties for all hospital personnel");
        System.out.println("- Defines abstract methods: getRole(), displayDetails()");
        System.out.println("- Provides concrete methods: displayBasicInfo(), updateContactInfo()");
        System.out.println();
        
        System.out.println("Concrete implementations:");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.getName() + " is a " + doctor.getRole());
        }
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName() + " is a " + patient.getRole());
        }
    }
    
    public static void demonstrateInterface() {
        System.out.println("Interface (Payable) Demonstration:");
        System.out.println("- Payable interface defines payment contract");
        System.out.println("- Methods: calculatePayment(), getPaymentDetails(), processPayment()");
        System.out.println("- Default method: generateInvoice()");
        System.out.println("- Static method: displayPaymentPolicies()");
        System.out.println();
        
        System.out.println("Classes implementing Payable:");
        for (Doctor doctor : doctors) {
            if (doctor instanceof Payable) {
                System.out.println("- " + doctor.getName() + " implements Payable");
            }
        }
        for (Patient patient : patients) {
            if (patient instanceof Payable) {
                System.out.println("- " + patient.getName() + " implements Payable");
            }
        }
        
        System.out.println("\nInterface static method:");
        Payable.displayPaymentPolicies();
    }
    
    public static void demonstratePatientManagement() {
        System.out.println("Patient Management with ArrayList:");
        System.out.println("Current patients: " + patients.size());
        
        // Add treatments to patients
        patients.get(0).addTreatment("Cardiac Consultation", 150.0);
        patients.get(0).addTreatment("ECG Test", 200.0);
        patients.get(0).addTreatment("Blood Test", 50.0);
        
        patients.get(1).addTreatment("Neurological Exam", 120.0);
        patients.get(1).addTreatment("MRI Scan", 800.0);
        
        patients.get(2).addTreatment("X-Ray", 150.0);
        patients.get(2).addTreatment("Cast Application", 300.0);
        patients.get(2).addTreatment("Physical Therapy", 200.0);
        
        System.out.println("\nPatient Details:");
        for (Patient patient : patients) {
            patient.displayDetails();
            System.out.println();
        }
        
        // Demonstrate ArrayList operations
        System.out.println("ArrayList Operations:");
        System.out.println("Total patients: " + patients.size());
        System.out.println("First patient: " + patients.get(0).getName());
        System.out.println("Contains patient PAT002: " + 
                          patients.stream().anyMatch(p -> p.getPatientId().equals("PAT002")));
        
        // Add new patient
        Patient newPatient = new Patient("Alice Brown", 25, "Female", "444 Birch Way", "555-1004",
                                       "PAT004", "Asthma", true, "HealthGuard");
        patients.add(newPatient);
        System.out.println("Added new patient. Total: " + patients.size());
        
        // Remove patient
        patients.remove(1); // Remove Mary Johnson
        System.out.println("Removed patient. Total: " + patients.size());
    }
    
    public static void demonstrateOverriddenMethods() {
        System.out.println("Overridden Methods Demonstration:");
        
        System.out.println("\n1. getRole() method:");
        for (Doctor doctor : doctors) {
            System.out.println("Doctor.getRole(): " + doctor.getRole());
        }
        for (Patient patient : patients) {
            System.out.println("Patient.getRole(): " + patient.getRole());
        }
        
        System.out.println("\n2. displayDetails() method:");
        System.out.println("Each class provides its own implementation:");
        doctors.get(0).displayDetails();
        patients.get(0).displayDetails();
        
        System.out.println("\n3. Payable interface methods:");
        System.out.println("calculatePayment() implementation differs:");
        System.out.println("Doctor salary: $" + doctors.get(0).calculatePayment());
        System.out.println("Patient bill: $" + patients.get(0).calculatePayment());
    }
    
    public static void demonstrateBillingSystem() {
        System.out.println("Billing System Demonstration:");
        
        System.out.println("\nDoctor Salaries:");
        for (Doctor doctor : doctors) {
            doctor.generateInvoice();
            System.out.println();
        }
        
        System.out.println("\nPatient Bills:");
        for (Patient patient : patients) {
            patient.generateInvoice();
            System.out.println();
        }
        
        System.out.println("Payment Processing:");
        for (Doctor doctor : doctors) {
            doctor.processPayment(doctor.calculatePayment());
        }
        for (Patient patient : patients) {
            patient.processPayment(patient.calculatePayment());
        }
    }
    
    public static void demonstratePolymorphism() {
        System.out.println("Polymorphism Demonstration:");
        
        // ArrayList of Person references
        ArrayList<Person> hospitalStaff = new ArrayList<>();
        hospitalStaff.addAll(doctors);
        hospitalStaff.addAll(patients);
        
        System.out.println("Using Person reference for all:");
        for (Person person : hospitalStaff) {
            System.out.println("\nProcessing " + person.getRole() + ":");
            person.displayDetails();
            
            // Interface polymorphism
            if (person instanceof Payable) {
                Payable payable = (Payable) person;
                System.out.println("Payment amount: $" + payable.calculatePayment());
                System.out.println("Payment details: " + payable.getPaymentDetails());
            }
        }
        
        System.out.println("\nPolymorphism Benefits:");
        System.out.println("- Single interface for different object types");
        System.out.println("- Code flexibility and extensibility");
        System.out.println("- Reduced code duplication");
        System.out.println("- Easy maintenance and updates");
    }
    
    public static void displaySystemSummary() {
        System.out.println("=== Hospital System Summary ===");
        System.out.println("Total Doctors: " + doctors.size());
        System.out.println("Total Patients: " + patients.size());
        
        double totalSalaries = 0;
        for (Doctor doctor : doctors) {
            totalSalaries += doctor.calculatePayment();
        }
        
        double totalBills = 0;
        double totalPatientPayments = 0;
        for (Patient patient : patients) {
            totalBills += patient.getTotalBill();
            totalPatientPayments += patient.calculatePayment();
        }
        
        System.out.println("\nFinancial Summary:");
        System.out.println("Total Doctor Salaries: $" + totalSalaries);
        System.out.println("Total Patient Bills: $" + totalBills);
        System.out.println("Total Patient Payments: $" + totalPatientPayments);
        System.out.println("Insurance Coverage: $" + (totalBills - totalPatientPayments));
        
        System.out.println("\nSystem Features Demonstrated:");
        System.out.println("✓ Abstract class (Person)");
        System.out.println("✓ Interface (Payable)");
        System.out.println("✓ Method overriding");
        System.out.println("✓ ArrayList for patient management");
        System.out.println("✓ Polymorphism");
        System.out.println("✓ Encapsulation");
        System.out.println("✓ Inheritance");
        System.out.println("✓ Default and static interface methods");
    }
}
