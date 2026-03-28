package unit2.company;

public class Manager extends Employee {
    private double bonus;
    private String department;
    
    public Manager(String name, double salary, double bonus, String department) {
        super(name, salary);
        this.bonus = bonus >= 0 ? bonus : 0.0;
        this.department = department;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus >= 0 ? bonus : 0.0;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }
    
    @Override
    public void displayEmployeeInfo() {
        System.out.println("Manager Information:");
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: $" + salary);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Salary: $" + calculateSalary());
        System.out.println("------------------------");
    }
    
    public void displayManagementInfo() {
        System.out.println("Management Details:");
        System.out.println("Manager: " + name);
        System.out.println("Department: " + department);
        System.out.println("Team Size: Calculating...");
        System.out.println("Performance Bonus: $" + bonus);
    }
}
