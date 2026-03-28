package unit2.vehicles;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String carType;
    
    public Car(String vehicleNumber, String brand, String model, int year, int numberOfDoors, String carType) {
        super(vehicleNumber, brand, model, year);
        this.numberOfDoors = numberOfDoors >= 2 ? numberOfDoors : 4;
        this.carType = carType;
    }
    
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    public String getCarType() {
        return carType;
    }
    
    @Override
    public String fuelType() {
        // Most cars use gasoline, but we can make it more specific
        if (carType.equalsIgnoreCase("Electric")) {
            return "Electric";
        } else if (carType.equalsIgnoreCase("Hybrid")) {
            return "Hybrid";
        } else if (carType.equalsIgnoreCase("Diesel")) {
            return "Diesel";
        } else {
            return "Gasoline";
        }
    }
    
    @Override
    public void maintain() {
        System.out.println("Car Maintenance Checklist:");
        System.out.println("- Check oil level and change if needed");
        System.out.println("- Check tire pressure and rotate tires");
        System.out.println("- Check brake pads and fluid");
        System.out.println("- Check battery and electrical system");
        System.out.println("- Replace air filter");
        System.out.println("- Check coolant level");
        System.out.println("Car type: " + carType + " - Specialized maintenance applied");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        String fuel = fuelType();
        if (fuel.equals("Electric")) {
            return 4.5; // miles per kWh
        } else if (fuel.equals("Hybrid")) {
            return 45.0; // miles per gallon
        } else if (fuel.equals("Diesel")) {
            return 35.0; // miles per gallon
        } else {
            return 30.0; // miles per gallon for gasoline
        }
    }
    
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Car Type: " + carType);
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Efficiency: " + calculateFuelEfficiency() + 
                          (fuelType().equals("Electric") ? " miles/kWh" : " mpg"));
    }
    
    public void openTrunk() {
        System.out.println("Car trunk is opening...");
    }
    
    public void activateCruiseControl() {
        System.out.println("Cruise control activated for " + brand + " " + model);
    }
}
