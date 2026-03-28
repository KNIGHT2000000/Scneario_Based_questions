package unit1.hospital;

public class HospitalManagementDemo {
    public static void main(String[] args) {
        System.out.println("=== Hospital Management System Demo ===\n");
        
        Doctor doctor1 = new Doctor(101, "Dr. Smith", "Cardiology");
        Doctor doctor2 = new Doctor(102, "Dr. Johnson", "Neurology");
        Doctor doctor3 = new Doctor(103, "Dr. Williams", "Orthopedics");
        
        Patient patient1 = new Patient(1001, "John Doe", "Heart Disease");
        Patient patient2 = new Patient(1002, "Jane Smith", "Migraine");
        Patient patient3 = new Patient(1003, "Bob Wilson", "Fracture");
        
        System.out.println("Doctors in the hospital:");
        doctor1.displayDetails();
        doctor2.displayDetails();
        doctor3.displayDetails();
        
        System.out.println("Patients in the hospital:");
        patient1.displayDetails();
        patient2.displayDetails();
        patient3.displayDetails();
        
        System.out.println("Demonstrating object-oriented principles:");
        System.out.println("Total doctors: " + 3);
        System.out.println("Total patients: " + 3);
        System.out.println("Encapsulation: Data members are private with public getters");
        System.out.println("Abstraction: Complex details hidden behind simple methods");
    }
}
