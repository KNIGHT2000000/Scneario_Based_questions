import java.util.Scanner;

/**
 * Comprehensive Java Programming Demo System
 * 
 * This main class serves as the entry point for running all Java programs
 * from Units 1, 2, and 3. Each unit covers different Java programming concepts
 * with practical examples and demonstrations.
 * 
 * Units Covered:
 * - Unit 1: Basic OOP Concepts (9 programs)
 * - Unit 2: Advanced OOP & Collections (14 programs)
 * - Unit 3: Exception Handling (8 programs)
 * 
 * Author: Java Programming Demo System
 * Version: 1.0
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    COMPREHENSIVE JAVA PROGRAMMING DEMO");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Welcome to the complete Java programming demonstration!");
        System.out.println("This system contains 31 programs covering all major Java concepts.");
        System.out.println();
        
        boolean running = true;
        
        while (running) {
            displayMainMenu();
            
            try {
                int choice = getIntInput("Enter your choice (1-4): ");
                
                switch (choice) {
                    case 1:
                        runUnit1Programs();
                        break;
                    case 2:
                        runUnit2Programs();
                        break;
                    case 3:
                        runUnit3Programs();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Thank you for using the Java Programming Demo System!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1-4.");
                }
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n========================================");
        System.out.println("           MAIN MENU");
        System.out.println("========================================");
        System.out.println("1. Unit 1 - Basic OOP Concepts (9 programs)");
        System.out.println("2. Unit 2 - Advanced OOP & Collections (14 programs)");
        System.out.println("3. Unit 3 - Exception Handling (8 programs)");
        System.out.println("4. Exit");
        System.out.println("========================================");
    }
    
    private static void runUnit1Programs() {
        while (true) {
            displayUnit1Menu();
            
            try {
                int choice = getIntInput("Enter your choice (1-10): ");
                
                if (choice == 10) {
                    break;
                }
                
                runUnit1Program(choice);
                
            } catch (Exception e) {
                System.out.println("Error running program: " + e.getMessage());
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void displayUnit1Menu() {
        System.out.println("\n========================================");
        System.out.println("    UNIT 1 - BASIC OOP CONCEPTS");
        System.out.println("========================================");
        System.out.println("1. Hospital Management System");
        System.out.println("2. Bank Account System (Encapsulation)");
        System.out.println("3. Employee Payroll System (Constructors)");
        System.out.println("4. Vehicle Rental System (Inheritance)");
        System.out.println("5. Shape Drawing Application (Polymorphism)");
        System.out.println("6. College Admission System (Static/Instance)");
        System.out.println("7. Student Marks Processing (Parameter Passing)");
        System.out.println("8. Result Processing System (ArrayList)");
        System.out.println("9. CPU Simulation (Inner Classes)");
        System.out.println("10. Back to Main Menu");
        System.out.println("========================================");
    }
    
    private static void runUnit1Program(int choice) {
        System.out.println("\n--- Running Unit 1 Program " + choice + " ---");
        
        try {
            switch (choice) {
                case 1:
                    unit1.hospital.HospitalManagementDemo.main(new String[]{});
                    break;
                case 2:
                    unit1.bank.BankAccountDemo.main(new String[]{});
                    break;
                case 3:
                    unit1.employee.EmployeePayrollDemo.main(new String[]{});
                    break;
                case 4:
                    unit1.vehicle.VehicleRentalDemo.main(new String[]{});
                    break;
                case 5:
                    unit1.shape.ShapeDrawingDemo.main(new String[]{});
                    break;
                case 6:
                    unit1.college.CollegeAdmissionDemo.main(new String[]{});
                    break;
                case 7:
                    unit1.marks.MarksProcessingDemo.main(new String[]{});
                    break;
                case 8:
                    unit1.marks.ResultProcessingDemo.main(new String[]{});
                    break;
                case 9:
                    unit1.cpu.CPUSimulationDemo.main(new String[]{});
                    break;
                default:
                    System.out.println("Invalid program number.");
            }
        } catch (Exception e) {
            System.out.println("Error executing program: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void runUnit2Programs() {
        while (true) {
            displayUnit2Menu();
            
            try {
                int choice = getIntInput("Enter your choice (1-15): ");
                
                if (choice == 15) {
                    break;
                }
                
                runUnit2Program(choice);
                
            } catch (Exception e) {
                System.out.println("Error running program: " + e.getMessage());
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void displayUnit2Menu() {
        System.out.println("\n========================================");
        System.out.println("  UNIT 2 - ADVANCED OOP & COLLECTIONS");
        System.out.println("========================================");
        System.out.println("1. Company Employee System (Method Overriding)");
        System.out.println("2. College System (Super Constructor)");
        System.out.println("3. Shape System (Runtime Polymorphism)");
        System.out.println("4. Banking System (Final Members)");
        System.out.println("5. Abstract Vehicle System");
        System.out.println("6. Smart Device (Multiple Interfaces)");
        System.out.println("7. Bank Interface (Constants)");
        System.out.println("8. Calculator (Overloading & Overriding)");
        System.out.println("9. Package Access Control");
        System.out.println("10. Array vs ArrayList");
        System.out.println("11. Vector Operations");
        System.out.println("12. Garbage Collection");
        System.out.println("13. StringTokenizer");
        System.out.println("14. Advanced Hospital System");
        System.out.println("15. Back to Main Menu");
        System.out.println("========================================");
    }
    
    private static void runUnit2Program(int choice) {
        System.out.println("\n--- Running Unit 2 Program " + choice + " ---");
        
        try {
            switch (choice) {
                case 1:
                    unit2.company.CompanyDemo.main(new String[]{});
                    break;
                case 2:
                    unit2.college.CollegeSystemDemo.main(new String[]{});
                    break;
                case 3:
                    unit2.shapes.RuntimePolymorphismDemo.main(new String[]{});
                    break;
                case 4:
                    unit2.banking.BankingFinalDemo.main(new String[]{});
                    break;
                case 5:
                    unit2.vehicles.AbstractVehicleDemo.main(new String[]{});
                    break;
                case 6:
                    unit2.device.SmartPhoneDemo.main(new String[]{});
                    break;
                case 7:
                    unit2.interfacebank.BankInterfaceDemo.main(new String[]{});
                    break;
                case 8:
                    unit2.calculator.CalculatorDemo.main(new String[]{});
                    break;
                case 9:
                    unit2.packagecollege.PackageAccessDemo.main(new String[]{});
                    break;
                case 10:
                    unit2.collections.ArrayArrayListDemo.main(new String[]{});
                    break;
                case 11:
                    unit2.collections.VectorDemo.main(new String[]{});
                    break;
                case 12:
                    unit2.garbage.GarbageCollectionDemo.main(new String[]{});
                    break;
                case 13:
                    unit2.tokenizer.StringTokenizerDemo.main(new String[]{});
                    break;
                case 14:
                    unit2.hospitaladvanced.HospitalSystemDemo.main(new String[]{});
                    break;
                default:
                    System.out.println("Invalid program number.");
            }
        } catch (Exception e) {
            System.out.println("Error executing program: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void runUnit3Programs() {
        while (true) {
            displayUnit3Menu();
            
            try {
                int choice = getIntInput("Enter your choice (1-9): ");
                
                if (choice == 9) {
                    break;
                }
                
                runUnit3Program(choice);
                
            } catch (Exception e) {
                System.out.println("Error running program: " + e.getMessage());
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void displayUnit3Menu() {
        System.out.println("\n========================================");
        System.out.println("      UNIT 3 - EXCEPTION HANDLING");
        System.out.println("========================================");
        System.out.println("1. Banking Division by Zero");
        System.out.println("2. Array Index Out of Bounds");
        System.out.println("3. Hospital Age Validation");
        System.out.println("4. Login System (Custom Exception)");
        System.out.println("5. Password Validation");
        System.out.println("6. Student Grading System");
        System.out.println("7. Banking Withdrawal System");
        System.out.println("8. File I/O Exception Handling");
        System.out.println("9. Back to Main Menu");
        System.out.println("========================================");
    }
    
    private static void runUnit3Program(int choice) {
        System.out.println("\n--- Running Unit 3 Program " + choice + " ---");
        
        try {
            switch (choice) {
                case 1:
                    unit3.banking.DivisionByZeroDemo.main(new String[]{});
                    break;
                case 2:
                    unit3.array.ArrayIndexDemo.main(new String[]{});
                    break;
                case 3:
                    unit3.hospital.AgeValidationDemo.main(new String[]{});
                    break;
                case 4:
                    unit3.login.LoginSystemDemo.main(new String[]{});
                    break;
                case 5:
                    unit3.password.PasswordValidatorDemo.main(new String[]{});
                    break;
                case 6:
                    unit3.marks.GradingSystemDemo.main(new String[]{});
                    break;
                case 7:
                    unit3.withdrawal.BankingWithdrawalDemo.main(new String[]{});
                    break;
                case 8:
                    unit3.fileio.FileIODemo.main(new String[]{});
                    break;
                default:
                    System.out.println("Invalid program number.");
            }
        } catch (Exception e) {
            System.out.println("Error executing program: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}