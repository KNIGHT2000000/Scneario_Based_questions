package unit2.company;

public class Employee {
    protected String name;
    protected double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary >= 0 ? salary : 0.0;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary >= 0 ? salary : 0.0;
    }
    
    public double calculateSalary() {
        return salary;
    }
    
    public void displayEmployeeInfo() {
        System.out.println("Employee Information:");
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + salary);
        System.out.println("Total Salary: $" + calculateSalary());
        System.out.println("------------------------");
    }
}
