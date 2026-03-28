package unit3.fileio;

import java.io.*;
import java.util.Scanner;

public class FileIODemo {
    public static void main(String[] args) {
        System.out.println("=== Student Marks File Processing System ===\n");
        
        System.out.println("File Operations:");
        System.out.println("• Read student marks from file");
        System.out.println("• Process and calculate statistics");
        System.out.println("• Handle file-related exceptions");
        System.out.println("• Graceful error recovery\n");
        
        // Demonstrate file operations
        demonstrateFileOperations();
        
        System.out.println("\n=== Exception Handling Analysis ===\n");
        analyzeExceptionHandling();
        
        System.out.println("\n=== Best Practices ===\n");
        demonstrateBestPractices();
    }
    
    public static void demonstrateFileOperations() {
        System.out.println("1. Creating Test Files:");
        createTestFiles();
        
        System.out.println("\n2. Reading Existing File:");
        readStudentMarks("students.txt");
        
        System.out.println("\n3. Attempting to Read Non-existent File:");
        readStudentMarks("nonexistent.txt");
        
        System.out.println("\n4. Attempting to Read Protected File:");
        readStudentMarks("protected.txt");
        
        System.out.println("\n5. Writing to File:");
        writeStudentResults("results.txt");
        
        System.out.println("\n6. Comprehensive File Processing:");
        processStudentData();
    }
    
    public static void createTestFiles() {
        // Create a valid student marks file
        try (PrintWriter writer = new PrintWriter("students.txt")) {
            writer.println("Alice Johnson,85,90,78,92");
            writer.println("Bob Smith,76,82,88,79");
            writer.println("Charlie Brown,92,95,89,94");
            writer.println("Diana Prince,88,91,85,90");
            writer.println("Edward Norton,79,83,77,81");
            System.out.println("✓ Created students.txt");
        } catch (IOException e) {
            System.out.println("✗ Failed to create students.txt: " + e.getMessage());
        }
        
        // Create a file with invalid data
        try (PrintWriter writer = new PrintWriter("invalid.txt")) {
            writer.println("Invalid Student,abc,def,ghi,jkl");
            writer.println("Another Invalid,105,200,-50,300");
            writer.println("Incomplete Data,85,90");
            System.out.println("✓ Created invalid.txt");
        } catch (IOException e) {
            System.out.println("✗ Failed to create invalid.txt: " + e.getMessage());
        }
    }
    
    public static void readStudentMarks(String filename) {
        System.out.println("Reading from: " + filename);
        
        try {
            StudentMarksReader reader = new StudentMarksReader(filename);
            reader.processFile();
            reader.displayStatistics();
            
        } catch (FileNotFoundException e) {
            System.out.println("✗ File not found: " + filename);
            System.out.println("  Action: Please check if the file exists and path is correct");
            System.out.println("  Suggestion: Create the file or use a different filename");
            
        } catch (IOException e) {
            System.out.println("✗ I/O error reading file: " + filename);
            System.out.println("  Error: " + e.getMessage());
            System.out.println("  Action: Check file permissions and disk space");
            
        } catch (SecurityException e) {
            System.out.println("✗ Access denied: " + filename);
            System.out.println("  Error: " + e.getMessage());
            System.out.println("  Action: Check file permissions");
            
        } catch (Exception e) {
            System.out.println("✗ Unexpected error: " + e.getMessage());
            System.out.println("  Action: Contact system administrator");
        }
    }
    
    public static void writeStudentResults(String filename) {
        System.out.println("Writing results to: " + filename);
        
        try {
            StudentResultsWriter writer = new StudentResultsWriter(filename);
            writer.writeResults();
            System.out.println("✓ Results written successfully");
            
        } catch (FileNotFoundException e) {
            System.out.println("✗ Cannot create file: " + filename);
            System.out.println("  Action: Check write permissions and disk space");
            
        } catch (IOException e) {
            System.out.println("✗ Error writing to file: " + e.getMessage());
            System.out.println("  Action: Check disk space and file permissions");
            
        } catch (Exception e) {
            System.out.println("✗ Unexpected error: " + e.getMessage());
        }
    }
    
    public static void processStudentData() {
        System.out.println("Comprehensive Student Data Processing:");
        
        try {
            // Try to process multiple files
            String[] files = {"students.txt", "invalid.txt", "nonexistent.txt"};
            
            for (String file : files) {
                System.out.println("\nProcessing file: " + file);
                
                try {
                    StudentMarksReader reader = new StudentMarksReader(file);
                    reader.processFile();
                    System.out.println("✓ Successfully processed: " + file);
                    
                } catch (FileNotFoundException e) {
                    System.out.println("⚠ File not found, skipping: " + file);
                    
                } catch (IOException e) {
                    System.out.println("⚠ I/O error, skipping: " + file);
                    
                } catch (DataFormatException e) {
                    System.out.println("⚠ Invalid data format, skipping: " + file);
                    System.out.println("  Details: " + e.getMessage());
                    
                } catch (Exception e) {
                    System.out.println("⚠ Unexpected error, skipping: " + file);
                }
            }
            
        } catch (Exception e) {
            System.out.println("✗ Critical error in processing: " + e.getMessage());
        }
    }
    
    public static void analyzeExceptionHandling() {
        System.out.println("File I/O Exception Types:");
        System.out.println();
        
        System.out.println("1. FileNotFoundException:");
        System.out.println("   ✓ Occurs when file doesn't exist");
        System.out.println("   ✓ Checked exception - must be handled");
        System.out.println("   ✓ Common in file operations");
        System.out.println();
        
        System.out.println("2. IOException:");
        System.out.println("   ✓ General I/O operation failure");
        System.out.println("   ✓ Checked exception - must be handled");
        System.out.println("   ✓ Covers various I/O problems");
        System.out.println();
        
        System.out.println("3. SecurityException:");
        System.out.println("   ✓ File access permission denied");
        System.out.println("   ✓ Runtime exception - unchecked");
        System.out.println("   ✓ Security manager blocks access");
        System.out.println();
        
        System.out.println("4. Try-with-Resources Benefits:");
        System.out.println("   ✓ Automatic resource management");
        System.out.println("   ✓ No need for explicit close()");
        System.out.println("   ✓ Prevents resource leaks");
        System.out.println("   ✓ Exception-safe resource handling");
        System.out.println();
        
        System.out.println("5. Exception Handling Strategy:");
        System.out.println("   ✓ Specific exception types");
        System.out.println("   ✓ Meaningful error messages");
        System.out.println("   ✓ Graceful error recovery");
        System.out.println("   ✓ User-friendly feedback");
    }
    
    public static void demonstrateBestPractices() {
        System.out.println("File I/O Best Practices:");
        System.out.println();
        
        // Demonstrate proper resource management
        demonstrateTryWithResources();
        
        System.out.println("\nKey Principles:");
        System.out.println("1. Always use try-with-resources for file operations");
        System.out.println("2. Handle specific exceptions, not just Exception");
        System.out.println("3. Provide meaningful error messages");
        System.out.println("4. Implement graceful error recovery");
        System.out.println("5. Validate file existence before operations");
        System.out.println("6. Check file permissions");
        System.out.println("7. Handle encoding issues");
        System.out.println("8. Implement proper logging");
    }
    
    public static void demonstrateTryWithResources() {
        System.out.println("Try-with-Resources Example:");
        
        // Good practice - automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            int lineCount = 0;
            
            while ((line = reader.readLine()) != null && lineCount < 3) {
                System.out.println("  Line " + (lineCount + 1) + ": " + line);
                lineCount++;
            }
            
            System.out.println("✓ File automatically closed");
            
        } catch (FileNotFoundException e) {
            System.out.println("✗ File not found (handled gracefully)");
            
        } catch (IOException e) {
            System.out.println("✗ I/O error (handled gracefully)");
        }
    }
    
    static class StudentMarksReader {
        private String filename;
        private int totalStudents = 0;
        private double totalMarks = 0;
        private int validRecords = 0;
        private int invalidRecords = 0;
        
        public StudentMarksReader(String filename) {
            this.filename = filename;
        }
        
        public void processFile() throws IOException, DataFormatException {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                int lineNumber = 0;
                
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    totalStudents++;
                    
                    try {
                        processStudentLine(line, lineNumber);
                        validRecords++;
                        
                    } catch (DataFormatException e) {
                        invalidRecords++;
                        System.out.println("  Warning: Invalid data at line " + lineNumber + ": " + e.getMessage());
                    }
                }
            }
        }
        
        private void processStudentLine(String line, int lineNumber) throws DataFormatException {
            String[] parts = line.split(",");
            
            if (parts.length != 5) {
                throw new DataFormatException("Expected 5 fields, found " + parts.length);
            }
            
            String name = parts[0].trim();
            
            try {
                double[] marks = new double[4];
                for (int i = 0; i < 4; i++) {
                    marks[i] = Double.parseDouble(parts[i + 1].trim());
                    
                    if (marks[i] < 0 || marks[i] > 100) {
                        throw new DataFormatException("Invalid mark: " + marks[i] + " (must be 0-100)");
                    }
                    
                    totalMarks += marks[i];
                }
                
                // Process valid student data
                double average = java.util.Arrays.stream(marks).average().orElse(0);
                
            } catch (NumberFormatException e) {
                throw new DataFormatException("Invalid number format in marks");
            }
        }
        
        public void displayStatistics() {
            System.out.println("File Statistics:");
            System.out.println("  Total lines processed: " + totalStudents);
            System.out.println("  Valid records: " + validRecords);
            System.out.println("  Invalid records: " + invalidRecords);
            
            if (validRecords > 0) {
                System.out.printf("  Average marks: %.2f\n", totalMarks / (validRecords * 4));
            }
        }
    }
    
    static class StudentResultsWriter {
        private String filename;
        
        public StudentResultsWriter(String filename) {
            this.filename = filename;
        }
        
        public void writeResults() throws IOException {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                writer.println("Student Results Summary");
                writer.println("=====================");
                writer.println("Generated: " + new java.util.Date());
                writer.println();
                writer.println("Total Students Processed: 5");
                writer.println("Valid Records: 5");
                writer.println("Invalid Records: 0");
                writer.println("Overall Average: 85.6");
                writer.println();
                writer.println("Top Performer: Charlie Brown (92.5)");
                writer.println("Needs Improvement: Edward Norton (80.0)");
            }
        }
    }
    
    static class DataFormatException extends Exception {
        public DataFormatException(String message) {
            super(message);
        }
    }
}
