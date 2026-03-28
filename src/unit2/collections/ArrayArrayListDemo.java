package unit2.collections;

import java.util.ArrayList;

public class ArrayArrayListDemo {
    public static void main(String[] args) {
        System.out.println("=== Array vs ArrayList Comparison Demo ===\n");
        
        System.out.println("=== Array Operations ===");
        demonstrateArrayOperations();
        
        System.out.println("\n=== ArrayList Operations ===");
        demonstrateArrayListOperations();
        
        System.out.println("\n=== Comparison Summary ===");
        displayComparison();
        
        System.out.println("\n=== Performance Analysis ===");
        analyzePerformance();
    }
    
    public static void demonstrateArrayOperations() {
        System.out.println("Working with Arrays:");
        
        // Create and initialize array
        String[] studentNames = new String[5];
        System.out.println("Created array of size: " + studentNames.length);
        
        // Add elements
        studentNames[0] = "Alice";
        studentNames[1] = "Bob";
        studentNames[2] = "Charlie";
        studentNames[3] = "David";
        studentNames[4] = "Eva";
        
        System.out.println("Initial array size: " + studentNames.length);
        System.out.println("Array contents:");
        displayArray(studentNames);
        
        // Access elements
        System.out.println("Element at index 2: " + studentNames[2]);
        
        // Modify elements
        studentNames[1] = "Robert";
        System.out.println("After modification at index 1:");
        displayArray(studentNames);
        
        // Remove elements (requires creating new array)
        System.out.println("Removing element at index 3...");
        String[] newArray = new String[studentNames.length - 1];
        int newIndex = 0;
        for (int i = 0; i < studentNames.length; i++) {
            if (i != 3) {
                newArray[newIndex] = studentNames[i];
                newIndex++;
            }
        }
        studentNames = newArray;
        System.out.println("Array after removal:");
        displayArray(studentNames);
        System.out.println("New array size: " + studentNames.length);
        
        // Add element (requires creating new array)
        System.out.println("Adding new element...");
        String[] expandedArray = new String[studentNames.length + 1];
        for (int i = 0; i < studentNames.length; i++) {
            expandedArray[i] = studentNames[i];
        }
        expandedArray[studentNames.length] = "Frank";
        studentNames = expandedArray;
        System.out.println("Array after addition:");
        displayArray(studentNames);
        System.out.println("Final array size: " + studentNames.length);
    }
    
    public static void demonstrateArrayListOperations() {
        System.out.println("Working with ArrayList:");
        
        // Create ArrayList
        ArrayList<String> studentList = new ArrayList<>();
        System.out.println("Created ArrayList, initial size: " + studentList.size());
        
        // Add elements
        studentList.add("Alice");
        studentList.add("Bob");
        studentList.add("Charlie");
        studentList.add("David");
        studentList.add("Eva");
        
        System.out.println("After adding 5 elements, size: " + studentList.size());
        System.out.println("ArrayList contents:");
        displayArrayList(studentList);
        
        // Access elements
        System.out.println("Element at index 2: " + studentList.get(2));
        
        // Modify elements
        studentList.set(1, "Robert");
        System.out.println("After modification at index 1:");
        displayArrayList(studentList);
        
        // Remove elements
        System.out.println("Removing element at index 3...");
        studentList.remove(3);
        System.out.println("ArrayList after removal:");
        displayArrayList(studentList);
        System.out.println("Size after removal: " + studentList.size());
        
        // Add elements dynamically
        System.out.println("Adding new element...");
        studentList.add("Frank");
        System.out.println("ArrayList after addition:");
        displayArrayList(studentList);
        System.out.println("Final size: " + studentList.size());
        
        // Additional ArrayList operations
        System.out.println("Additional ArrayList features:");
        System.out.println("Contains 'Alice': " + studentList.contains("Alice"));
        System.out.println("Index of 'Charlie': " + studentList.indexOf("Charlie"));
        System.out.println("Is empty: " + studentList.isEmpty());
        
        // Insert at specific position
        studentList.add(2, "Grace");
        System.out.println("After inserting 'Grace' at index 2:");
        displayArrayList(studentList);
        System.out.println("Size: " + studentList.size());
        
        // Clear all elements
        System.out.println("Clearing ArrayList...");
        studentList.clear();
        System.out.println("Size after clear: " + studentList.size());
        System.out.println("Is empty: " + studentList.isEmpty());
    }
    
    public static void displayArray(String[] array) {
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void displayArrayList(ArrayList<String> list) {
        System.out.print("ArrayList: [");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void displayComparison() {
        System.out.println("=== Array vs ArrayList Comparison ===\n");
        
        System.out.println("Size:");
        System.out.println("Array: Fixed size, defined at creation");
        System.out.println("ArrayList: Dynamic size, can grow/shrink");
        System.out.println();
        
        System.out.println("Performance:");
        System.out.println("Array: Faster access (no overhead)");
        System.out.println("ArrayList: Slightly slower due to object overhead");
        System.out.println();
        
        System.out.println("Data Types:");
        System.out.println("Array: Can hold primitives and objects");
        System.out.println("ArrayList: Can only hold objects (uses wrapper classes)");
        System.out.println();
        
        System.out.println("Operations:");
        System.out.println("Array: Manual implementation for add/remove");
        System.out.println("ArrayList: Built-in methods for add/remove/modify");
        System.out.println();
        
        System.out.println("Memory:");
        System.out.println("Array: Contiguous memory allocation");
        System.out.println("ArrayList: May not be contiguous, can have gaps");
        System.out.println();
        
        System.out.println("Length/Size:");
        System.out.println("Array: .length property");
        System.out.println("ArrayList: .size() method");
        System.out.println();
        
        System.out.println("Type Safety:");
        System.out.println("Array: Can store mixed types with Object[]");
        System.out.println("ArrayList: Type-safe with generics");
    }
    
    public static void analyzePerformance() {
        System.out.println("=== Performance Analysis ===\n");
        
        System.out.println("Time Complexity:");
        System.out.println("Access by index:");
        System.out.println("  Array: O(1) - Direct memory access");
        System.out.println("  ArrayList: O(1) - Direct access with slight overhead");
        System.out.println();
        
        System.out.println("Insertion/Deletion:");
        System.out.println("  Array: O(n) - Need to shift elements");
        System.out.println("  ArrayList: O(n) - Need to shift elements");
        System.out.println();
        
        System.out.println("Resize operation:");
        System.out.println("  Array: O(n) - Create new array and copy");
        System.out.println("  ArrayList: O(n) - Internal array resize and copy");
        System.out.println();
        
        System.out.println("Memory Usage:");
        System.out.println("Array:");
        System.out.println("  - Primitives: Actual value size");
        System.out.println("  - Objects: Reference size (4-8 bytes)");
        System.out.println("  - No additional overhead");
        System.out.println();
        
        System.out.println("ArrayList:");
        System.out.println("  - Objects: Reference + object overhead");
        System.out.println("  - Additional internal array overhead");
        System.out.println("  - Capacity management overhead");
        System.out.println();
        
        System.out.println("When to use Array:");
        System.out.println("- Fixed size known in advance");
        System.out.println("- Performance critical applications");
        System.out.println("- Working with primitives");
        System.out.println("- Memory constrained environments");
        System.out.println();
        
        System.out.println("When to use ArrayList:");
        System.out.println("- Dynamic size requirements");
        System.out.println("- Frequent insertions/deletions");
        System.out.println("- Need built-in methods");
        System.out.println("- Type safety with generics");
        System.out.println("- Readability and maintainability");
    }
}
