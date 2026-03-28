package unit3.array;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ArrayIndexDemo {
    private static String[] students = {
        "Alice Johnson", "Bob Smith", "Charlie Brown", 
        "Diana Prince", "Edward Norton", "Fiona Apple"
    };
    
    private static int[] grades = {85, 92, 78, 95, 88, 91};
    
    public static void main(String[] args) {
        System.out.println("=== Array Index Out of Bounds Exception Handling ===\n");
        
        System.out.println("Student Management System");
        System.out.println("Total students: " + students.length);
        displayAllStudents();
        
        System.out.println("\n=== Demonstration of Array Index Problems ===\n");
        
        demonstrateInvalidIndex();
        demonstrateMultipleCatchBlocks();
        demonstrateRobustHandling();
        demonstrateUserInput();
    }
    
    public static void displayAllStudents() {
        System.out.println("\nStudent List:");
        for (int i = 0; i < students.length; i++) {
            System.out.println((i + 1) + ". " + students[i] + " - Grade: " + grades[i]);
        }
    }
    
    public static void demonstrateInvalidIndex() {
        System.out.println("1. Direct Invalid Access (Will Cause Exception):");
        
        try {
            System.out.println("Trying to access student at index 10...");
            String student = students[10]; // ArrayIndexOutOfBoundsException
            System.out.println("Student: " + student);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Array length: " + students.length);
            System.out.println("Valid indices: 0 to " + (students.length - 1));
        }
        
        System.out.println("\n2. Negative Index Access:");
        
        try {
            System.out.println("Trying to access student at index -1...");
            String student = students[-1]; // ArrayIndexOutOfBoundsException
            System.out.println("Student: " + student);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Negative indices are not allowed in Java arrays");
        }
    }
    
    public static void demonstrateMultipleCatchBlocks() {
        System.out.println("\n=== Multiple Catch Blocks Demonstration ===\n");
        
        // Test scenarios that can cause different exceptions
        int[][] testCases = {
            {0},      // Valid index
            {5},      // Valid index (last element)
            {6},      // Invalid index (too high)
            {-1},     // Invalid index (negative)
            {100}     // Very invalid index
        };
        
        for (int[] testCase : testCases) {
            int index = testCase[0];
            System.out.println("Testing index: " + index);
            
            try {
                // This can cause ArrayIndexOutOfBoundsException
                String studentName = students[index];
                int studentGrade = grades[index];
                
                // This can cause ArithmeticException (if grade is 0)
                double percentage = studentGrade / 0.0;
                
                System.out.println("  Student: " + studentName);
                System.out.println("  Grade: " + studentGrade);
                System.out.println("  Status: Success");
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("  ArrayIndexOutOfBoundsException: " + e.getMessage());
                System.out.println("  Action: Please use index between 0 and " + (students.length - 1));
                
            } catch (ArithmeticException e) {
                System.out.println("  ArithmeticException: " + e.getMessage());
                System.out.println("  Action: Invalid grade calculation");
                
            } catch (Exception e) {
                System.out.println("  General Exception: " + e.getMessage());
                System.out.println("  Action: Unknown error occurred");
                
            } finally {
                System.out.println("  Test completed for index " + index);
            }
            System.out.println();
        }
    }
    
    public static void demonstrateRobustHandling() {
        System.out.println("=== Robust Array Access Methods ===\n");
        
        // Test safe access methods
        System.out.println("Testing safe access methods:");
        
        String student1 = getStudentSafely(2);
        System.out.println("Index 2: " + student1);
        
        String student2 = getStudentSafely(10);
        System.out.println("Index 10: " + student2);
        
        String student3 = getStudentSafely(-1);
        System.out.println("Index -1: " + student3);
        
        System.out.println("\nTesting grade access with validation:");
        
        GradeResult result1 = getGradeSafely(1);
        System.out.println("Index 1: " + result1);
        
        GradeResult result2 = getGradeSafely(15);
        System.out.println("Index 15: " + result2);
        
        GradeResult result3 = getGradeSafely(-5);
        System.out.println("Index -5: " + result3);
    }
    
    public static String getStudentSafely(int index) {
        try {
            if (index < 0 || index >= students.length) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            return students[index];
        } catch (IndexOutOfBoundsException e) {
            return "Invalid index: " + e.getMessage();
        }
    }
    
    public static GradeResult getGradeSafely(int index) {
        try {
            if (index < 0 || index >= grades.length) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            
            int grade = grades[index];
            String status = getGradeStatus(grade);
            return new GradeResult(students[index], grade, status, "Success");
            
        } catch (IndexOutOfBoundsException e) {
            return new GradeResult("N/A", -1, "N/A", "Error: " + e.getMessage());
        } catch (Exception e) {
            return new GradeResult("N/A", -1, "N/A", "Unexpected error: " + e.getMessage());
        }
    }
    
    public static String getGradeStatus(int grade) {
        if (grade >= 90) return "Excellent";
        else if (grade >= 80) return "Good";
        else if (grade >= 70) return "Average";
        else if (grade >= 60) return "Below Average";
        else return "Poor";
    }
    
    public static void demonstrateUserInput() {
        System.out.println("\n=== User Input Demonstration ===\n");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Student Grade Lookup System");
        System.out.println("Enter student index (0-" + (students.length - 1) + ") or -1 to exit:");
        
        while (true) {
            try {
                System.out.print("Enter index: ");
                int input = scanner.nextInt();
                
                if (input == -1) {
                    System.out.println("Exiting system...");
                    break;
                }
                
                GradeResult result = getGradeSafely(input);
                System.out.println("Result: " + result);
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear the buffer
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
    
    static class GradeResult {
        String studentName;
        int grade;
        String status;
        String message;
        
        public GradeResult(String studentName, int grade, String status, String message) {
            this.studentName = studentName;
            this.grade = grade;
            this.status = status;
            this.message = message;
        }
        
        @Override
        public String toString() {
            if (message.startsWith("Error")) {
                return message;
            }
            return String.format("%s - Grade: %d (%s) [%s]", 
                               studentName, grade, status, message);
        }
    }
}
