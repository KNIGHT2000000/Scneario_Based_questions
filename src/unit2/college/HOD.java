package unit2.college;

public class HOD extends Teacher {
    private String department;
    private int yearsOfExperience;
    
    public HOD(String name, int age, String subject, double salary, String department, int yearsOfExperience) {
        super(name, age, subject, salary); // Call to super constructor
        this.department = department;
        this.yearsOfExperience = yearsOfExperience >= 0 ? yearsOfExperience : 0;
        System.out.println("HOD constructor called: " + name + ", " + department);
    }
    
    public String getDepartment() {
        return department;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience >= 0 ? yearsOfExperience : 0;
    }
    
    @Override
    public void displayPersonInfo() {
        System.out.println("HOD Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
        System.out.println("Salary: $" + salary);
        System.out.println("Department: " + department);
        System.out.println("Years of Experience: " + yearsOfExperience);
    }
    
    @Override
    public void introduce() {
        System.out.println("Hello, I am " + name + ", " + age + " years old, HOD of " + 
                          department + " department, teaching " + subject + " with " + 
                          yearsOfExperience + " years of experience.");
    }
    
    @Override
    public void teach() {
        System.out.println("HOD " + name + " is teaching advanced " + subject + " courses.");
    }
    
    public void manageDepartment() {
        System.out.println("HOD " + name + " is managing the " + department + " department.");
    }
    
    public void conductMeeting() {
        System.out.println("HOD " + name + " is conducting a department meeting.");
    }
    
    public void approveBudget() {
        System.out.println("HOD " + name + " is approving budget for " + department + " department.");
    }
}
