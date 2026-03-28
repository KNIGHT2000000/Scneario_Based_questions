package unit2.collections;

import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;

public class VectorDemo {
    public static void main(String[] args) {
        System.out.println("=== Vector Class Methods Demonstration ===\n");
        
        System.out.println("=== Creating and Initializing Vector ===");
        demonstrateVectorCreation();
        
        System.out.println("\n=== Basic Vector Operations ===");
        demonstrateBasicOperations();
        
        System.out.println("\n=== Vector Iteration Methods ===");
        demonstrateIterationMethods();
        
        System.out.println("\n=== Vector Search Operations ===");
        demonstrateSearchOperations();
        
        System.out.println("\n=== Vector Capacity Management ===");
        demonstrateCapacityManagement();
        
        System.out.println("\n=== Vector vs ArrayList Comparison ===");
        compareVectorArrayList();
    }
    
    public static void demonstrateVectorCreation() {
        System.out.println("1. Default constructor (capacity 10):");
        Vector<String> vector1 = new Vector<>();
        System.out.println("   Initial capacity: " + vector1.capacity());
        System.out.println("   Initial size: " + vector1.size());
        
        System.out.println("\n2. Constructor with initial capacity:");
        Vector<String> vector2 = new Vector<>(5);
        System.out.println("   Initial capacity: " + vector2.capacity());
        System.out.println("   Initial size: " + vector2.size());
        
        System.out.println("\n3. Constructor with initial capacity and capacity increment:");
        Vector<String> vector3 = new Vector<>(3, 2);
        System.out.println("   Initial capacity: " + vector3.capacity());
        System.out.println("   Capacity increment: 2");
        System.out.println("   Initial size: " + vector3.size());
        
        System.out.println("\n4. Constructor from collection:");
        Vector<String> vector4 = new Vector<>(java.util.Arrays.asList("A", "B", "C"));
        System.out.println("   Elements: " + vector4);
        System.out.println("   Size: " + vector4.size());
        System.out.println("   Capacity: " + vector4.capacity());
    }
    
    public static void demonstrateBasicOperations() {
        Vector<String> products = new Vector<>();
        
        System.out.println("=== Add Operations ===");
        products.add("P001");
        products.add("P002");
        products.add("P003");
        System.out.println("After add(): " + products);
        System.out.println("Size: " + products.size());
        System.out.println("Capacity: " + products.capacity());
        
        // Add at specific position
        products.add(1, "P001.5");
        System.out.println("After add(1, element): " + products);
        
        // Add all elements from another collection
        Vector<String> moreProducts = new Vector<>();
        moreProducts.add("P004");
        moreProducts.add("P005");
        products.addAll(moreProducts);
        System.out.println("After addAll(): " + products);
        
        System.out.println("\n=== Access Operations ===");
        System.out.println("Element at index 2: " + products.get(2));
        System.out.println("First element: " + products.firstElement());
        System.out.println("Last element: " + products.lastElement());
        
        System.out.println("\n=== Modify Operations ===");
        products.set(2, "P002-Updated");
        System.out.println("After set(2, element): " + products);
        
        System.out.println("\n=== Remove Operations ===");
        products.remove(1);
        System.out.println("After remove(1): " + products);
        
        products.remove("P003");
        System.out.println("After remove(element): " + products);
        
        products.removeAll(moreProducts);
        System.out.println("After removeAll(): " + products);
        
        System.out.println("\n=== Clear Operations ===");
        products.clear();
        System.out.println("After clear(): " + products);
        System.out.println("Size: " + products.size());
        System.out.println("Is empty: " + products.isEmpty());
    }
    
    public static void demonstrateIterationMethods() {
        Vector<Integer> numbers = new Vector<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i * 10);
        }
        
        System.out.println("Vector content: " + numbers);
        
        System.out.println("\n1. Using for loop with get():");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        
        System.out.println("\n2. Using enhanced for loop:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println("\n3. Using Enumeration (legacy):");
        Enumeration<Integer> enumeration = numbers.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();
        
        System.out.println("\n4. Using Iterator:");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        System.out.println("\n5. Using ListIterator (bidirectional):");
        ListIterator<Integer> listIterator = numbers.listIterator();
        System.out.println("Forward iteration:");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println("\nBackward iteration:");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
    }
    
    public static void demonstrateSearchOperations() {
        Vector<String> names = new Vector<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eva");
        
        System.out.println("Vector: " + names);
        
        System.out.println("\n=== Search Methods ===");
        System.out.println("Contains 'Alice': " + names.contains("Alice"));
        System.out.println("Contains 'Frank': " + names.contains("Frank"));
        
        System.out.println("Index of 'Charlie': " + names.indexOf("Charlie"));
        System.out.println("Last index of 'Alice': " + names.lastIndexOf("Alice"));
        
        Vector<String> searchList = new Vector<>();
        searchList.add("Bob");
        searchList.add("David");
        System.out.println("ContainsAll [Bob, David]: " + names.containsAll(searchList));
        
        System.out.println("\n=== Sublist Operations ===");
        Vector<String> subVector = new Vector<>(names.subList(1, 4));
        System.out.println("Sublist (1, 4): " + subVector);
        
        System.out.println("\n=== Copy Operations ===");
        Vector<String> copy = new Vector<>();
        copy.addAll(names);
        System.out.println("Copy of vector: " + copy);
        System.out.println("Are they equal? " + names.equals(copy));
    }
    
    public static void demonstrateCapacityManagement() {
        Vector<Integer> vector = new Vector<>(2, 3); // initial capacity 2, increment 3
        
        System.out.println("Initial capacity: " + vector.capacity());
        System.out.println("Initial size: " + vector.size());
        
        System.out.println("\nAdding elements to trigger capacity increase:");
        for (int i = 1; i <= 8; i++) {
            vector.add(i);
            System.out.println("Added " + i + " - Size: " + vector.size() + 
                             ", Capacity: " + vector.capacity());
        }
        
        System.out.println("\n=== Capacity Management Methods ===");
        System.out.println("Current capacity: " + vector.capacity());
        System.out.println("Current size: " + vector.size());
        
        vector.trimToSize();
        System.out.println("After trimToSize() - Capacity: " + vector.capacity());
        
        vector.ensureCapacity(20);
        System.out.println("After ensureCapacity(20) - Capacity: " + vector.capacity());
        
        System.out.println("Size remains unchanged: " + vector.size());
    }
    
    public static void compareVectorArrayList() {
        System.out.println("=== Vector vs ArrayList Comparison ===\n");
        
        System.out.println("Synchronization:");
        System.out.println("Vector: Synchronized (thread-safe)");
        System.out.println("ArrayList: Not synchronized (not thread-safe)");
        System.out.println();
        
        System.out.println("Performance:");
        System.out.println("Vector: Slower due to synchronization overhead");
        System.out.println("ArrayList: Faster in single-threaded environments");
        System.out.println();
        
        System.out.println("Legacy:");
        System.out.println("Vector: Legacy class (Java 1.0)");
        System.out.println("ArrayList: Introduced in Java 1.2 as part of Collections Framework");
        System.out.println();
        
        System.out.println("Capacity Growth:");
        System.out.println("Vector: Doubles by default, can specify increment");
        System.out.println("ArrayList: Increases by 50% (1.5x)");
        System.out.println();
        
        System.out.println("Iterator Behavior:");
        System.out.println("Vector: Iterator is fail-fast");
        System.out.println("ArrayList: Iterator is fail-fast");
        System.out.println();
        
        System.out.println("Enumeration Support:");
        System.out.println("Vector: Has elements() method for Enumeration");
        System.out.println("ArrayList: No Enumeration support (only Iterator)");
        System.out.println();
        
        System.out.println("When to use Vector:");
        System.out.println("- Need thread-safe operations");
        System.out.println("- Working with legacy code");
        System.out.println("- Need Enumeration interface");
        System.out.println("- Want explicit capacity control");
        System.out.println();
        
        System.out.println("When to use ArrayList:");
        System.out.println("- Single-threaded environment");
        System.out.println("- Better performance needed");
        System.out.println("- Modern Java applications");
        System.out.println("- Collections Framework compatibility");
    }
}
