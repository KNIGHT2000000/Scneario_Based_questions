package unit2.vehicles;

public class AbstractVehicleDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstract Vehicle System Demo ===\n");
        
        System.out.println("=== Creating Vehicle Objects ===\n");
        
        Car car1 = new Car("CAR-001", "Toyota", "Camry", 2023, 4, "Gasoline");
        Car car2 = new Car("CAR-002", "Tesla", "Model 3", 2023, 4, "Electric");
        Car car3 = new Car("CAR-003", "Honda", "CR-V", 2023, 5, "Hybrid");
        
        Bike bike1 = new Bike("BIKE-001", "Honda", "CBR600RR", 2023, 600, "Sport", true);
        Bike bike2 = new Bike("BIKE-002", "Yamaha", "MT-07", 2023, 689, "Standard", true);
        Bike bike3 = new Bike("BIKE-003", "Zero", "SR/F", 2023, 0, "Electric", false);
        
        System.out.println("=== Individual Vehicle Information ===\n");
        
        System.out.println("Cars:");
        car1.displayVehicleInfo();
        System.out.println();
        car2.displayVehicleInfo();
        System.out.println();
        car3.displayVehicleInfo();
        System.out.println();
        
        System.out.println("Bikes:");
        bike1.displayVehicleInfo();
        System.out.println();
        bike2.displayVehicleInfo();
        System.out.println();
        bike3.displayVehicleInfo();
        System.out.println();
        
        System.out.println("=== Abstract Method Implementation ===\n");
        
        System.out.println("Fuel Types (Abstract method implementation):");
        System.out.println(car1.getBrand() + " " + car1.getModel() + ": " + car1.fuelType());
        System.out.println(car2.getBrand() + " " + car2.getModel() + ": " + car2.fuelType());
        System.out.println(bike1.getBrand() + " " + bike1.getModel() + ": " + bike1.fuelType());
        System.out.println(bike3.getBrand() + " " + bike3.getModel() + ": " + bike3.fuelType());
        System.out.println();
        
        System.out.println("Maintenance Procedures (Abstract method implementation):");
        car1.maintain();
        System.out.println();
        bike1.maintain();
        System.out.println();
        
        System.out.println("=== Polymorphism with Base Class Reference ===\n");
        
        Vehicle[] vehicles = {car1, car2, car3, bike1, bike2, bike3};
        
        System.out.println("Using Vehicle reference to call abstract methods:");
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println("Vehicle " + (i + 1) + ":");
            System.out.println("Fuel Type: " + vehicles[i].fuelType());
            System.out.println("Fuel Efficiency: " + vehicles[i].calculateFuelEfficiency() + 
                              (vehicles[i].fuelType().equals("Electric") ? " miles/kWh" : " mpg"));
            vehicles[i].start();
            vehicles[i].stop();
            System.out.println();
        }
        
        System.out.println("=== Abstract Class Concepts ===");
        System.out.println("1. Abstract class Vehicle:");
        System.out.println("   - Cannot be instantiated directly");
        System.out.println("   - Contains both abstract and concrete methods");
        System.out.println("   - Provides common functionality for all vehicles");
        System.out.println("   - Defines contract that subclasses must follow");
        System.out.println();
        
        System.out.println("2. Abstract Methods:");
        System.out.println("   - fuelType(): Must be implemented by each vehicle type");
        System.out.println("   - maintain(): Must be implemented by each vehicle type");
        System.out.println("   - calculateFuelEfficiency(): Must be implemented by each vehicle type");
        System.out.println("   - No method body, just signature");
        System.out.println();
        
        System.out.println("3. Concrete Methods:");
        System.out.println("   - displayVehicleInfo(): Can be used as-is or overridden");
        System.out.println("   - start(): Common to all vehicles");
        System.out.println("   - stop(): Common to all vehicles");
        System.out.println("   - Have implementation and can be inherited");
        System.out.println();
        
        System.out.println("4. Benefits of Abstract Classes:");
        System.out.println("   - Code reusability: Common methods shared");
        System.out.println("   - Consistency: All vehicles have same interface");
        System.out.println("   - Flexibility: Each vehicle can implement specific behavior");
        System.out.println("   - Maintainability: Changes in base class affect all subclasses");
        
        System.out.println("\n=== Runtime Polymorphism ===");
        System.out.println("Vehicle reference can point to any subclass object:");
        System.out.println("- Vehicle v = new Car(...) calls Car's methods");
        System.out.println("- Vehicle v = new Bike(...) calls Bike's methods");
        System.out.println("- Method selection happens at runtime based on actual object");
        
        System.out.println("\n=== Specialized Vehicle Operations ===");
        car2.openTrunk();
        car2.activateCruiseControl();
        bike1.doWheelie();
        bike2.leanIntoTurn();
    }
}
