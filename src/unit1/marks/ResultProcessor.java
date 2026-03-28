package unit1.marks;

import java.util.ArrayList;

public class ResultProcessor {
    private ArrayList<Integer> marksList;
    private String subjectName;
    
    public ResultProcessor(String subjectName) {
        this.subjectName = subjectName;
        this.marksList = new ArrayList<>();
    }
    
    public void addMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            marksList.add(marks); // Autoboxing: int -> Integer
            System.out.println("Added marks: " + marks);
        } else {
            System.out.println("Invalid marks: " + marks + ". Must be between 0 and 100.");
        }
    }
    
    public void removeMarks(int index) {
        if (index >= 0 && index < marksList.size()) {
            int removedMarks = marksList.remove(index); // Unboxing: Integer -> int
            System.out.println("Removed marks at index " + index + ": " + removedMarks);
        } else {
            System.out.println("Invalid index: " + index);
        }
    }
    
    public void updateMarks(int index, int newMarks) {
        if (index >= 0 && index < marksList.size()) {
            if (newMarks >= 0 && newMarks <= 100) {
                int oldMarks = marksList.set(index, newMarks); // Unboxing and Autoboxing
                System.out.println("Updated marks at index " + index + " from " + oldMarks + " to " + newMarks);
            } else {
                System.out.println("Invalid new marks: " + newMarks + ". Must be between 0 and 100.");
            }
        } else {
            System.out.println("Invalid index: " + index);
        }
    }
    
    public double calculateAverage() {
        if (marksList.isEmpty()) {
            return 0.0;
        }
        
        int sum = 0;
        for (Integer marks : marksList) {
            sum += marks; // Unboxing: Integer -> int
        }
        
        return (double) sum / marksList.size();
    }
    
    public int findHighest() {
        if (marksList.isEmpty()) {
            return -1;
        }
        
        int highest = marksList.get(0); // Unboxing
        for (int i = 1; i < marksList.size(); i++) {
            int current = marksList.get(i); // Unboxing
            if (current > highest) {
                highest = current;
            }
        }
        return highest;
    }
    
    public int findLowest() {
        if (marksList.isEmpty()) {
            return -1;
        }
        
        int lowest = marksList.get(0); // Unboxing
        for (int i = 1; i < marksList.size(); i++) {
            int current = marksList.get(i); // Unboxing
            if (current < lowest) {
                lowest = current;
            }
        }
        return lowest;
    }
    
    public void displayAllMarks() {
        System.out.println("Marks for " + subjectName + ":");
        if (marksList.isEmpty()) {
            System.out.println("No marks available.");
        } else {
            for (int i = 0; i < marksList.size(); i++) {
                int marks = marksList.get(i); // Unboxing
                System.out.println("Student " + (i + 1) + ": " + marks);
            }
        }
    }
    
    public void displayStatistics() {
        System.out.println("=== Statistics for " + subjectName + " ===");
        System.out.println("Total Students: " + marksList.size());
        System.out.println("Average Marks: " + calculateAverage());
        System.out.println("Highest Marks: " + findHighest());
        System.out.println("Lowest Marks: " + findLowest());
        
        if (!marksList.isEmpty()) {
            int aboveAverage = 0;
            int belowAverage = 0;
            double average = calculateAverage();
            
            for (Integer marks : marksList) {
                if (marks > average) {
                    aboveAverage++;
                } else if (marks < average) {
                    belowAverage++;
                }
            }
            
            System.out.println("Students Above Average: " + aboveAverage);
            System.out.println("Students Below Average: " + belowAverage);
        }
        System.out.println("------------------------");
    }
    
    public void demonstrateAutoboxing() {
        System.out.println("=== Autoboxing and Unboxing Demonstration ===");
        System.out.println();
        
        System.out.println("1. Autoboxing (Primitive -> Wrapper):");
        int primitiveInt = 85;
        Integer wrapperInteger = primitiveInt; // Autoboxing
        System.out.println("int " + primitiveInt + " -> Integer " + wrapperInteger);
        
        System.out.println("\n2. Unboxing (Wrapper -> Primitive):");
        Integer wrapperInt2 = 90;
        int primitiveInt2 = wrapperInt2; // Unboxing
        System.out.println("Integer " + wrapperInt2 + " -> int " + primitiveInt2);
        
        System.out.println("\n3. Autoboxing in ArrayList operations:");
        marksList.add(75); // int -> Integer automatically
        marksList.add(80); // int -> Integer automatically
        System.out.println("Added primitive ints to ArrayList<Integer> automatically");
        
        System.out.println("\n4. Unboxing in arithmetic operations:");
        Integer marks = marksList.get(0);
        int doubled = marks * 2; // Unboxing before multiplication
        System.out.println("Integer " + marks + " * 2 = int " + doubled);
        
        System.out.println("\n5. Autoboxing in method parameters:");
        processMarks(95); // int -> Integer automatically
        System.out.println("Passed primitive int to method expecting Integer");
        
        System.out.println("\n6. Unboxing in method return:");
        Integer result = getMarks();
        int primitiveResult = result; // Unboxing
        System.out.println("Returned Integer " + result + " -> int " + primitiveResult);
    }
    
    private void processMarks(Integer marks) {
        System.out.println("Processing marks: " + marks);
    }
    
    private Integer getMarks() {
        return 88; // int -> Integer autoboxing
    }
}
