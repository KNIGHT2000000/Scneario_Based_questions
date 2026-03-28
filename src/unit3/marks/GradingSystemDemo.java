package unit3.marks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradingSystemDemo {
    private static final double MIN_MARKS = 0.0;
    private static final double MAX_MARKS = 100.0;
    
    public static void main(String[] args) {
        System.out.println("=== Student Grading System ===\n");
        
        System.out.println("Grading Policy:");
        System.out.println("• Valid marks range: 0 to 100");
        System.out.println("• Grade A: 90-100");
        System.out.println("• Grade B: 80-89");
        System.out.println("• Grade C: 70-79");
        System.out.println("• Grade D: 60-69");
        System.out.println("• Grade F: 0-59\n");
        
        // Demonstrate grading system
        demonstrateGradingSystem();
        
        System.out.println("\n=== Interactive Grade Entry ===\n");
        interactiveGradeEntry();
        
        System.out.println("\n=== Grade Analysis ===\n");
        analyzeGrades();
    }
    
    public static void demonstrateGradingSystem() {
        System.out.println("1. Testing Various Mark Entries:");
        
        // Test cases
        Object[][] testCases = {
            {"Alice Johnson", "Mathematics", 95.5},
            {"Bob Smith", "Physics", 85.0},
            {"Charlie Brown", "Chemistry", 75.5},
            {"Diana Prince", "Biology", 65.0},
            {"Edward Norton", "History", 55.5},
            {"Fiona Apple", "Geography", -5.0},    // Invalid (negative)
            {"George Lucas", "Literature", 105.0},   // Invalid (too high)
            {"Helen Troy", "Computer Science", 110.5}, // Invalid (too high)
            {"Ian McKellen", "Art", -10.0},          // Invalid (negative)
            {"Julia Roberts", "Music", 101.0}        // Invalid (too high)
        };
        
        StudentGrades grades = new StudentGrades();
        
        for (Object[] testCase : testCases) {
            String studentName = (String) testCase[0];
            String subject = (String) testCase[1];
            double marks = (double) testCase[2];
            
            System.out.println("\nProcessing: " + studentName + " - " + subject + " - " + marks);
            
            try {
                grades.addGrade(studentName, subject, marks);
                System.out.println("  ✓ Grade added successfully");
                
            } catch (InvalidMarksException e) {
                System.out.println("  ✗ Grade entry failed:");
                System.out.println("    " + e.getErrorMessage());
                System.out.println("    Suggestion: " + e.getSuggestedAction());
                
            } catch (Exception e) {
                System.out.println("  ✗ Unexpected error: " + e.getMessage());
            }
        }
        
        System.out.println("\nValid Grades Summary:");
        grades.displayAllGrades();
    }
    
    public static void interactiveGradeEntry() {
        Scanner scanner = new Scanner(System.in);
        StudentGrades grades = new StudentGrades();
        
        System.out.println("Interactive Grade Entry System");
        System.out.println("Enter student details (or 'quit' to exit)\n");
        
        while (true) {
            try {
                System.out.print("Student name: ");
                String studentName = scanner.nextLine();
                
                if (studentName.equalsIgnoreCase("quit")) {
                    break;
                }
                
                System.out.print("Subject: ");
                String subject = scanner.nextLine();
                
                if (subject.equalsIgnoreCase("quit")) {
                    break;
                }
                
                System.out.print("Marks (0-100): ");
                String marksStr = scanner.nextLine();
                
                if (marksStr.equalsIgnoreCase("quit")) {
                    break;
                }
                
                double marks = Double.parseDouble(marksStr);
                
                grades.addGrade(studentName, subject, marks);
                System.out.println("✓ Grade added successfully!");
                
                // Show grade and GPA
                String grade = grades.calculateGrade(marks);
                double gpa = grades.calculateGPA(marks);
                System.out.println("Grade: " + grade + " (GPA: " + String.format("%.2f", gpa) + ")");
                
            } catch (NumberFormatException e) {
                System.out.println("✗ Invalid marks format. Please enter a number.");
                
            } catch (InvalidMarksException e) {
                System.out.println("✗ Invalid marks:");
                System.out.println("  " + e.getErrorMessage());
                System.out.println("  " + e.getSuggestedAction());
                
            } catch (Exception e) {
                System.out.println("✗ Unexpected error: " + e.getMessage());
            }
            
            System.out.println();
        }
        
        System.out.println("\nFinal Grade Summary:");
        grades.displayAllGrades();
        grades.displayStatistics();
        
        scanner.close();
    }
    
    public static void analyzeGrades() {
        System.out.println("Grade Analysis Features:");
        
        StudentGrades grades = new StudentGrades();
        
        // Add sample valid grades
        grades.addGrade("Test Student 1", "Math", 92.5);
        grades.addGrade("Test Student 2", "Science", 78.0);
        grades.addGrade("Test Student 3", "English", 65.5);
        grades.addGrade("Test Student 4", "History", 88.0);
        grades.addGrade("Test Student 5", "Art", 95.0);
        
        System.out.println("\nSample Data Analysis:");
        grades.displayAllGrades();
        grades.displayStatistics();
        
        System.out.println("\nException Handling Benefits:");
        System.out.println("1. Data Integrity:");
        System.out.println("   ✓ Prevents invalid marks entry");
        System.out.println("   ✓ Ensures data consistency");
        System.out.println("   ✓ Maintains grade standards");
        System.out.println();
        
        System.out.println("2. Error Reporting:");
        System.out.println("   ✓ Specific error messages");
        System.out.println("   ✓ Context information");
        System.out.println("   ✓ Actionable suggestions");
        System.out.println();
        
        System.out.println("3. System Reliability:");
        System.out.println("   ✓ Graceful error handling");
        System.out.println("   ✓ No system crashes");
        System.out.println("   ✓ User-friendly feedback");
        System.out.println();
        
        System.out.println("4. Business Logic Enforcement:");
        System.out.println("   ✓ Enforces grade boundaries");
        System.out.println("   ✓ Validates business rules");
        System.out.println("   ✓ Maintains academic standards");
    }
    
    static class StudentGrades {
        private Map<String, Map<String, Double>> studentGrades = new HashMap<>();
        private int totalValidEntries = 0;
        private int totalInvalidEntries = 0;
        
        public void addGrade(String studentName, String subject, double marks) throws InvalidMarksException {
            validateMarks(marks, subject, studentName);
            
            // Add grade to system
            studentGrades.computeIfAbsent(studentName, k -> new HashMap<>()).put(subject, marks);
            totalValidEntries++;
            
            System.out.println("Grade recorded: " + studentName + " - " + subject + " - " + marks);
        }
        
        private void validateMarks(double marks, String subject, String studentName) throws InvalidMarksException {
            if (marks < MIN_MARKS) {
                totalInvalidEntries++;
                throw new InvalidMarksException(marks, subject, studentName, MIN_MARKS, MAX_MARKS);
            }
            
            if (marks > MAX_MARKS) {
                totalInvalidEntries++;
                throw new InvalidMarksException(marks, subject, studentName, MIN_MARKS, MAX_MARKS);
            }
        }
        
        public String calculateGrade(double marks) {
            if (marks >= 90) return "A";
            else if (marks >= 80) return "B";
            else if (marks >= 70) return "C";
            else if (marks >= 60) return "D";
            else return "F";
        }
        
        public double calculateGPA(double marks) {
            if (marks >= 90) return 4.0;
            else if (marks >= 80) return 3.0;
            else if (marks >= 70) return 2.0;
            else if (marks >= 60) return 1.0;
            else return 0.0;
        }
        
        public void displayAllGrades() {
            System.out.println("All Recorded Grades:");
            System.out.println("------------------");
            
            for (Map.Entry<String, Map<String, Double>> studentEntry : studentGrades.entrySet()) {
                String studentName = studentEntry.getKey();
                Map<String, Double> subjects = studentEntry.getValue();
                
                System.out.println("\nStudent: " + studentName);
                
                double totalMarks = 0;
                int subjectCount = 0;
                
                for (Map.Entry<String, Double> subjectEntry : subjects.entrySet()) {
                    String subject = subjectEntry.getKey();
                    double marks = subjectEntry.getValue();
                    String grade = calculateGrade(marks);
                    double gpa = calculateGPA(marks);
                    
                    System.out.printf("  %s: %.1f (%s, GPA: %.1f)\n", subject, marks, grade, gpa);
                    
                    totalMarks += marks;
                    subjectCount++;
                }
                
                if (subjectCount > 0) {
                    double average = totalMarks / subjectCount;
                    String averageGrade = calculateGrade(average);
                    double averageGPA = calculateGPA(average);
                    
                    System.out.printf("  Average: %.1f (%s, GPA: %.1f)\n", average, averageGrade, averageGPA);
                }
            }
        }
        
        public void displayStatistics() {
            System.out.println("\nSystem Statistics:");
            System.out.println("Valid entries: " + totalValidEntries);
            System.out.println("Invalid entries: " + totalInvalidEntries);
            System.out.println("Total students: " + studentGrades.size());
            
            if (totalValidEntries > 0) {
                double successRate = (totalValidEntries * 100.0) / (totalValidEntries + totalInvalidEntries);
                System.out.printf("Success rate: %.1f%%\n", successRate);
            }
        }
    }
}
