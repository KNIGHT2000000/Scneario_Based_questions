package unit1.hospital;

public class Patient {
    private int patientId;
    private String name;
    private String disease;
    
    public Patient(int patientId, String name, String disease) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
    }
    
    public int getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDisease() {
        return disease;
    }
    
    public void displayDetails() {
        System.out.println("Patient Details:");
        System.out.println("ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Disease: " + disease);
        System.out.println("------------------------");
    }
}
