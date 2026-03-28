package unit1.employee;

public class EmployeePayrollDemo {
    public static void main(String[] args) {
        System.out.println("=== Employee Payroll System Demo ===\n");
        
        System.out.println("Creating employees using different constructors:\n");
        
        Employee employee1 = new Employee(); // Default constructor
        System.out.println();
        
        Employee employee2 = new Employee(101, "Alice Johnson", "IT", 75000.0); // Parameterized constructor
        System.out.println();
        
        Employee employee3 = new Employee(102, "Bob Smith", "HR", 65000.0); // Parameterized constructor
        System.out.println();
        
        Employee employee4 = new Employee(103, "Carol Davis", "Finance", 80000.0); // Parameterized constructor
        System.out.println();
        
        System.out.println("Displaying all employee information:");
        employee1.displayEmployeeInfo();
        employee2.displayEmployeeInfo();
        employee3.displayEmployeeInfo();
        employee4.displayEmployeeInfo();
        
        System.out.println("Demonstrating constructor usage:");
        System.out.println("- Default constructor: Creates employee with default values");
        System.out.println("- Parameterized constructor: Creates employee with specific values");
        System.out.println("- Constructor overloading: Multiple ways to create objects");
        
        System.out.println("\nCalculating annual salaries:");
        System.out.println(employee1.getName() + ": $" + employee1.calculateAnnualSalary());
        System.out.println(employee2.getName() + ": $" + employee2.calculateAnnualSalary());
        System.out.println(employee3.getName() + ": $" + employee3.calculateAnnualSalary());
        System.out.println(employee4.getName() + ": $" + employee4.calculateAnnualSalary());
        
        System.out.println("\nUpdating employee information:");
        employee1.setDepartment("Administration");
        employee1.setSalary(45000.0);
        System.out.println("Updated default employee:");
        employee1.displayEmployeeInfo();
    }
}
