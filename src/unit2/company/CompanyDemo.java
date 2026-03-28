package unit2.company;

public class CompanyDemo {
    public static void main(String[] args) {
        System.out.println("=== Company Employee System Demo ===\n");
        
        Employee employee1 = new Employee("John Smith", 50000.0);
        Employee employee2 = new Employee("Alice Johnson", 55000.0);
        Employee employee3 = new Employee("Bob Wilson", 48000.0);
        
        Manager manager1 = new Manager("Carol Davis", 75000.0, 15000.0, "IT");
        Manager manager2 = new Manager("David Brown", 80000.0, 20000.0, "Finance");
        Manager manager3 = new Manager("Eva Miller", 85000.0, 18000.0, "HR");
        
        System.out.println("=== Regular Employees ===");
        employee1.displayEmployeeInfo();
        employee2.displayEmployeeInfo();
        employee3.displayEmployeeInfo();
        
        System.out.println("=== Managers ===");
        manager1.displayEmployeeInfo();
        manager2.displayEmployeeInfo();
        manager3.displayEmployeeInfo();
        
        System.out.println("=== Method Overriding Demonstration ===");
        System.out.println("Employee calculateSalary() returns: $" + employee1.calculateSalary());
        System.out.println("Manager calculateSalary() returns: $" + manager1.calculateSalary());
        System.out.println("Manager salary includes base salary + bonus using super.calculateSalary()");
        
        System.out.println("\n=== Polymorphism Example ===");
        Employee[] staff = {
            employee1, 
            employee2, 
            manager1, 
            manager2, 
            employee3,
            manager3
        };
        
        System.out.println("Using Employee reference for all staff:");
        double totalPayroll = 0;
        for (Employee emp : staff) {
            emp.displayEmployeeInfo();
            totalPayroll += emp.calculateSalary();
        }
        
        System.out.println("Total Company Payroll: $" + totalPayroll);
        
        System.out.println("\n=== Super Keyword Usage ===");
        System.out.println("In Manager.calculateSalary():");
        System.out.println("return super.calculateSalary() + bonus;");
        System.out.println("- super.calculateSalary() calls Employee.calculateSalary()");
        System.out.println("- Returns base salary from parent class");
        System.out.println("- Adds bonus to calculate total manager salary");
        
        System.out.println("\n=== Inheritance Benefits ===");
        System.out.println("- Code reusability: Manager inherits Employee properties");
        System.out.println("- Method overriding: Specialized behavior for managers");
        System.out.println("- Super keyword: Access to parent class methods");
        System.out.println("- Polymorphism: Uniform treatment of different employee types");
    }
}
