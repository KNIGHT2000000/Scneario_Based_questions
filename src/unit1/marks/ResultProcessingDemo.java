package unit1.marks;

public class ResultProcessingDemo {
    public static void main(String[] args) {
        System.out.println("=== Result Processing System Demo ===\n");
        
        ResultProcessor mathProcessor = new ResultProcessor("Mathematics");
        ResultProcessor scienceProcessor = new ResultProcessor("Science");
        
        System.out.println("=== Adding Marks to Mathematics ===");
        mathProcessor.addMarks(85);
        mathProcessor.addMarks(92);
        mathProcessor.addMarks(78);
        mathProcessor.addMarks(95);
        mathProcessor.addMarks(88);
        mathProcessor.addMarks(73);
        
        System.out.println("\n=== Adding Marks to Science ===");
        scienceProcessor.addMarks(90);
        scienceProcessor.addMarks(87);
        scienceProcessor.addMarks(93);
        scienceProcessor.addMarks(82);
        scienceProcessor.addMarks(89);
        
        System.out.println("\n=== Displaying All Marks ===");
        mathProcessor.displayAllMarks();
        System.out.println();
        scienceProcessor.displayAllMarks();
        
        System.out.println("\n=== Calculating Statistics ===");
        mathProcessor.displayStatistics();
        scienceProcessor.displayStatistics();
        
        System.out.println("\n=== Demonstrating ArrayList Operations ===");
        System.out.println("Removing marks from Mathematics:");
        mathProcessor.removeMarks(2); // Remove 78
        mathProcessor.displayAllMarks();
        
        System.out.println("\nUpdating marks in Science:");
        scienceProcessor.updateMarks(1, 95); // Update 87 to 95
        scienceProcessor.displayAllMarks();
        
        System.out.println("\n=== Updated Statistics ===");
        mathProcessor.displayStatistics();
        scienceProcessor.displayStatistics();
        
        System.out.println("\n=== Autoboxing and Unboxing Demonstration ===");
        mathProcessor.demonstrateAutoboxing();
        
        System.out.println("\n=== Key Concepts Summary ===");
        System.out.println("1. ArrayList<Integer> stores Integer wrapper objects");
        System.out.println("2. Autoboxing: int -> Integer conversion is automatic");
        System.out.println("3. Unboxing: Integer -> int conversion is automatic");
        System.out.println("4. Wrapper classes provide object-oriented benefits");
        System.out.println("5. ArrayList can only store objects, not primitives");
        System.out.println("6. Performance consideration: wrapper objects have overhead");
        
        System.out.println("\n=== Performance Comparison ===");
        demonstratePerformanceComparison();
    }
    
    private static void demonstratePerformanceComparison() {
        System.out.println("Primitive vs Wrapper Performance:");
        System.out.println("- Primitive int: Direct storage, faster operations");
        System.out.println("- Integer wrapper: Object overhead, slower but flexible");
        System.out.println("- ArrayList requires wrapper objects");
        System.out.println("- Use primitive arrays for performance-critical code");
        System.out.println("- Use ArrayList for dynamic collections with flexibility");
    }
}
