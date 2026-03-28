package unit1.cpu;

public class CPUSimulationDemo {
    public static void main(String[] args) {
        System.out.println("=== CPU Simulation Program Demo ===\n");
        
        System.out.println("=== Creating CPU Objects ===");
        CPU intelCPU = new CPU("Intel", "Core i7-12700K", 3.6, 12);
        CPU amdCPU = new CPU("AMD", "Ryzen 9 5900X", 3.7, 12);
        
        System.out.println("\n=== CPU Information ===");
        intelCPU.displayCPUInfo();
        amdCPU.displayCPUInfo();
        
        System.out.println("\n=== Starting CPUs ===");
        intelCPU.start();
        amdCPU.start();
        
        System.out.println("\n=== Performing Calculations ===");
        intelCPU.performCalculation(10, 20);
        amdCPU.performCalculation(15, 25);
        
        System.out.println("\n=== Accessing Cache ===");
        intelCPU.accessCache();
        amdCPU.accessCache();
        
        System.out.println("\n=== Stopping CPUs ===");
        intelCPU.stop();
        amdCPU.stop();
        
        System.out.println("\n=== Inner Class Demonstration ===");
        System.out.println("1. Inner classes have access to outer class members");
        System.out.println("2. Inner classes cannot exist without outer class instance");
        System.out.println("3. Inner classes can access private members of outer class");
        System.out.println("4. Used to implement components that are logically related");
        
        System.out.println("\n=== Static Nested Class Demonstration ===");
        CPU.CPUSpecification spec = new CPU.CPUSpecification("x86-64", "x86-64");
        spec.displaySpecification();
        
        CPU.CPUSpecification.displayGeneralInfo();
        
        System.out.println("\n=== Key Differences ===");
        System.out.println("Inner Class:");
        System.out.println("- Has access to outer class members (including private)");
        System.out.println("- Requires outer class instance");
        System.out.println("- Cannot have static members");
        System.out.println("- Used for implementing components");
        
        System.out.println("\nStatic Nested Class:");
        System.out.println("- No access to outer class instance members");
        System.out.println("- Can be accessed without outer class instance");
        System.out.println("- Can have static members");
        System.out.println("- Used for grouping related classes");
        
        System.out.println("\n=== Object Creation of Inner Classes ===");
        System.out.println("Inner class objects are created within outer class methods");
        System.out.println("ALU and Cache objects are created when CPU starts");
        System.out.println("They have direct access to CPU's private members");
        System.out.println("This demonstrates encapsulation and information hiding");
        
        System.out.println("\n=== Real-world Analogy ===");
        System.out.println("CPU is like a computer processor");
        System.out.println("ALU is like the calculator inside the processor");
        System.out.println("Cache is like temporary memory inside the processor");
        System.out.println("All components work together but are internally hidden");
    }
}
