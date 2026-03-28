package unit1.cpu;

public class CPU {
    private String brand;
    private String model;
    private double clockSpeed; // in GHz
    private int cores;
    private boolean isRunning;
    
    public CPU(String brand, String model, double clockSpeed, int cores) {
        this.brand = brand;
        this.model = model;
        this.clockSpeed = clockSpeed;
        this.cores = cores;
        this.isRunning = false;
    }
    
    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " " + model + " CPU started");
            ALU alu = new ALU();
            alu.initialize();
            Cache cache = new Cache(8, 3); // 8MB L3 cache, 3 levels
            cache.initialize();
        } else {
            System.out.println("CPU is already running");
        }
    }
    
    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println(brand + " " + model + " CPU stopped");
        } else {
            System.out.println("CPU is already stopped");
        }
    }
    
    public void displayCPUInfo() {
        System.out.println("CPU Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Clock Speed: " + clockSpeed + " GHz");
        System.out.println("Cores: " + cores);
        System.out.println("Status: " + (isRunning ? "Running" : "Stopped"));
        System.out.println("------------------------");
    }
    
    public void performCalculation(int a, int b) {
        if (isRunning) {
            ALU alu = new ALU();
            System.out.println("Performing calculation on " + brand + " " + model);
            int sum = alu.add(a, b);
            int product = alu.multiply(a, b);
            System.out.println("Results: " + a + " + " + b + " = " + sum);
            System.out.println("Results: " + a + " * " + b + " = " + product);
        } else {
            System.out.println("Cannot perform calculation. CPU is not running.");
        }
    }
    
    public void accessCache() {
        if (isRunning) {
            Cache cache = new Cache(8, 3);
            cache.displayCacheInfo();
            cache.storeData("Sample data");
            cache.retrieveData();
        } else {
            System.out.println("Cannot access cache. CPU is not running.");
        }
    }
    
    // Inner class ALU (Arithmetic Logic Unit)
    private class ALU {
        private String aluType;
        private boolean isInitialized;
        
        public ALU() {
            this.aluType = "64-bit";
            this.isInitialized = false;
        }
        
        public void initialize() {
            isInitialized = true;
            System.out.println("ALU initialized for " + brand + " " + model);
            System.out.println("ALU Type: " + aluType);
            System.out.println("Accessing outer class data from inner class:");
            System.out.println("- CPU Brand: " + brand);
            System.out.println("- CPU Model: " + model);
            System.out.println("- CPU Cores: " + cores);
        }
        
        public int add(int a, int b) {
            if (isInitialized) {
                System.out.println("ALU performing addition: " + a + " + " + b);
                return a + b;
            }
            return -1;
        }
        
        public int multiply(int a, int b) {
            if (isInitialized) {
                System.out.println("ALU performing multiplication: " + a + " * " + b);
                return a * b;
            }
            return -1;
        }
        
        public void displayALUInfo() {
            System.out.println("ALU Information:");
            System.out.println("Type: " + aluType);
            System.out.println("Initialized: " + isInitialized);
            System.out.println("Part of CPU: " + brand + " " + model);
        }
    }
    
    // Inner class Cache
    private class Cache {
        private int sizeMB;
        private int levels;
        private String[] storedData;
        private int dataCount;
        
        public Cache(int sizeMB, int levels) {
            this.sizeMB = sizeMB;
            this.levels = levels;
            this.storedData = new String[10];
            this.dataCount = 0;
        }
        
        public void initialize() {
            System.out.println("Cache initialized for " + brand + " " + model);
            System.out.println("Cache Size: " + sizeMB + " MB");
            System.out.println("Cache Levels: " + levels);
            System.out.println("Accessing outer class clock speed: " + clockSpeed + " GHz");
        }
        
        public void storeData(String data) {
            if (dataCount < storedData.length) {
                storedData[dataCount] = data;
                System.out.println("Stored in cache: " + data);
                dataCount++;
            } else {
                System.out.println("Cache is full");
            }
        }
        
        public void retrieveData() {
            if (dataCount > 0) {
                System.out.println("Retrieved from cache: " + storedData[dataCount - 1]);
            } else {
                System.out.println("No data in cache");
            }
        }
        
        public void displayCacheInfo() {
            System.out.println("Cache Information:");
            System.out.println("Size: " + sizeMB + " MB");
            System.out.println("Levels: " + levels);
            System.out.println("Data stored: " + dataCount + "/" + storedData.length);
            System.out.println("Associated with: " + brand + " " + model);
        }
    }
    
    // Static nested class
    public static class CPUSpecification {
        private String architecture;
        private String instructionSet;
        
        public CPUSpecification(String architecture, String instructionSet) {
            this.architecture = architecture;
            this.instructionSet = instructionSet;
        }
        
        public void displaySpecification() {
            System.out.println("CPU Specification:");
            System.out.println("Architecture: " + architecture);
            System.out.println("Instruction Set: " + instructionSet);
        }
        
        public static void displayGeneralInfo() {
            System.out.println("General CPU Information:");
            System.out.println("- Static nested class can be accessed without outer class instance");
            System.out.println("- Cannot access non-static members of outer class directly");
            System.out.println("- Used for grouping related functionality");
        }
    }
}
