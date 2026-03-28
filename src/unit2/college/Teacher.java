package unit2.college;

public class Teacher extends Person {
    protected String subject;
    protected double salary;
    
    public Teacher(String name, int age, String subject, double salary) {
        super(name, age); // Call to super constructor
        this.subject = subject;
        this.salary = salary >= 0 ? salary : 0.0;
        System.out.println("Teacher constructor called: " + name + ", " + subject);
    }
    
    public String getSubject() {
        return subject;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary >= 0 ? salary : 0.0;
    }
    
    @Override
    public void displayPersonInfo() {
        System.out.println("Teacher Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
        System.out.println("Salary: $" + salary);
    }
    
    @Override
    public void introduce() {
        System.out.println("Hello, I am " + name + ", " + age + " years old, and I teach " + subject + ".");
    }
    
    public void teach() {
        System.out.println(name + " is teaching " + subject + " to students.");
    }
    
    public void gradePapers() {
        System.out.println(name + " is grading " + subject + " papers.");
    }
}
