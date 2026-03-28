package unit2.garbage;

public class GarbageCollectionDemo {
    private static int objectCount = 0;
    private final int objectId;
    private String name;
    
    public GarbageCollectionDemo(String name) {
        this.objectId = ++objectCount;
        this.name = name;
        System.out.println("Created object " + objectId + ": " + name);
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalizing object " + objectId + ": " + name);
            System.out.println("  - This method is called by garbage collector");
            System.out.println("  - Before object memory is reclaimed");
            System.out.println("  - Object count before cleanup: " + objectCount);
            objectCount--;
            System.out.println("  - Object count after cleanup: " + objectCount);
        } finally {
            super.finalize(); // Always call superclass finalize
        }
    }
    
    public void displayInfo() {
        System.out.println("Object " + objectId + ": " + name + " is active");
    }
    
    public static void demonstrateGarbageCollection() {
        System.out.println("=== Garbage Collection Demonstration ===\n");
        
        System.out.println("1. Creating objects in a loop:");
        GarbageCollectionDemo[] objects = new GarbageCollectionDemo[10];
        
        for (int i = 0; i < 10; i++) {
            objects[i] = new GarbageCollectionDemo("Object-" + i);
            if (i % 3 == 2) {
                objects[i].displayInfo();
            }
        }
        
        System.out.println("\n2. Making references eligible for garbage collection:");
        System.out.println("Setting references to null...");
        
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) { // Make even-numbered objects eligible
                System.out.println("Setting object " + objects[i].objectId + " to null");
                objects[i] = null;
            }
        }
        
        System.out.println("\n3. Suggesting garbage collection:");
        System.out.println("Calling System.gc() - suggestion to JVM");
        System.gc();
        
        System.out.println("Calling System.runFinalization() - suggests running finalizers");
        System.runFinalization();
        
        // Give some time for garbage collection to occur
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        
        System.out.println("\n4. Creating more objects to trigger GC:");
        for (int i = 10; i < 20; i++) {
            new GarbageCollectionDemo("TempObject-" + i);
            if (i % 3 == 0) {
                // Create temporary objects and lose references
                new GarbageCollectionDemo("LostObject-" + i);
            }
        }
        
        System.out.println("\n5. Final garbage collection suggestion:");
        System.gc();
        System.runFinalization();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        
        System.out.println("\n6. Checking remaining objects:");
        int remainingObjects = 0;
        for (GarbageCollectionDemo obj : objects) {
            if (obj != null) {
                remainingObjects++;
                obj.displayInfo();
            }
        }
        System.out.println("Total remaining objects: " + remainingObjects);
    }
    
    public static void demonstrateMemoryManagement() {
        System.out.println("\n=== Memory Management Concepts ===\n");
        
        Runtime runtime = Runtime.getRuntime();
        
        System.out.println("Memory Information:");
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        System.out.println("Max Memory: " + (maxMemory / 1024 / 1024) + " MB");
        System.out.println("Total Memory: " + (totalMemory / 1024 / 1024) + " MB");
        System.out.println("Free Memory: " + (freeMemory / 1024 / 1024) + " MB");
        System.out.println("Used Memory: " + (usedMemory / 1024 / 1024) + " MB");
        
        System.out.println("\nCreating large number of objects...");
        String[] stringArray = new String[10000];
        for (int i = 0; i < 10000; i++) {
            stringArray[i] = "String-" + i + "-" + System.currentTimeMillis();
        }
        
        totalMemory = runtime.totalMemory();
        freeMemory = runtime.freeMemory();
        usedMemory = totalMemory - freeMemory;
        
        System.out.println("After creating objects:");
        System.out.println("Total Memory: " + (totalMemory / 1024 / 1024) + " MB");
        System.out.println("Free Memory: " + (freeMemory / 1024 / 1024) + " MB");
        System.out.println("Used Memory: " + (usedMemory / 1024 / 1024) + " MB");
        
        System.out.println("\nMaking objects eligible for GC...");
        stringArray = null;
        
        System.out.println("Suggesting garbage collection...");
        System.gc();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        
        totalMemory = runtime.totalMemory();
        freeMemory = runtime.freeMemory();
        usedMemory = totalMemory - freeMemory;
        
        System.out.println("After garbage collection:");
        System.out.println("Total Memory: " + (totalMemory / 1024 / 1024) + " MB");
        System.out.println("Free Memory: " + (freeMemory / 1024 / 1024) + " MB");
        System.out.println("Used Memory: " + (usedMemory / 1024 / 1024) + " MB");
    }
    
    public static void main(String[] args) {
        demonstrateGarbageCollection();
        demonstrateMemoryManagement();
        
        System.out.println("\n=== Garbage Collection Summary ===\n");
        
        System.out.println("Key Points:");
        System.out.println("1. Garbage collection is automatic in Java");
        System.out.println("2. System.gc() is only a suggestion, not guarantee");
        System.out.println("3. finalize() method is called before object destruction");
        System.out.println("4. Objects become eligible when no references exist");
        System.out.println("5. Memory is reclaimed for future use");
        System.out.println();
        
        System.out.println("Best Practices:");
        System.out.println("- Don't rely on finalize() for critical cleanup");
        System.out.println("- Use try-with-resources for automatic cleanup");
        System.out.println("- Set large object references to null when done");
        System.out.println("- Avoid calling System.gc() unnecessarily");
        System.out.println("- Monitor memory usage in applications");
        System.out.println();
        
        System.out.println("finalize() Method:");
        System.out.println("- Called by garbage collector before object reclamation");
        System.out.println("- Not guaranteed to be called");
        System.out.println("- Performance overhead");
        System.out.println("- Deprecated in favor of try-with-resources");
        System.out.println("- Always call super.finalize() if overridden");
    }
}
