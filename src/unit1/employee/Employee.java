package unit1.employee;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double salary;
    
    // Default constructor
    public Employee() {
        this.employeeId = 0;
        this.name = "Unknown";
        this.department = "Unassigned";
        this.salary = 0.0;
        System.out.println("Default constructor called - Employee created with default values");
    }
    
    // Parameterized constructor
    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary >= 0 ? salary : 0.0;
        System.out.println("Parameterized constructor called - Employee created with provided values");
    }
    
    // Getters
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public double getSalary() {
        return salary;
    }
    
    // Setters
    public void setSalary(double salary) {
        this.salary = salary >= 0 ? salary : 0.0;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void displayEmployeeInfo() {
        System.out.println("Employee Information:");
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("------------------------");
    }
    
    public double calculateAnnualSalary() {
        return salary * 12;
    }
}
