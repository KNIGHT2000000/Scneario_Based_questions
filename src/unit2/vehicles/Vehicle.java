package unit2.vehicles;

public abstract class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected String model;
    protected int year;
    
    public Vehicle(String vehicleNumber, String brand, String model, int year) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.model = model;
        this.year = year >= 1900 ? year : 2023;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract String fuelType();
    
    // Concrete method - can be used as-is or overridden
    public void displayVehicleInfo() {
        System.out.println("Vehicle Information:");
        System.out.println("Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Type: " + fuelType());
    }
    
    // Concrete method
    public void start() {
        System.out.println(brand + " " + model + " is starting...");
        System.out.println("Fuel type: " + fuelType());
    }
    
    // Concrete method
    public void stop() {
        System.out.println(brand + " " + model + " is stopping.");
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void maintain();
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateFuelEfficiency();
}
