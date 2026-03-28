package unit2.vehicles;

public class Bike extends Vehicle {
    private int engineCC;
    private String bikeType;
    private boolean hasABS;
    
    public Bike(String vehicleNumber, String brand, String model, int year, int engineCC, String bikeType, boolean hasABS) {
        super(vehicleNumber, brand, model, year);
        this.engineCC = engineCC > 0 ? engineCC : 150;
        this.bikeType = bikeType;
        this.hasABS = hasABS;
    }
    
    public int getEngineCC() {
        return engineCC;
    }
    
    public String getBikeType() {
        return bikeType;
    }
    
    public boolean hasABS() {
        return hasABS;
    }
    
    @Override
    public String fuelType() {
        // Most bikes use gasoline
        if (bikeType.equalsIgnoreCase("Electric")) {
            return "Electric";
        } else {
            return "Gasoline";
        }
    }
    
    @Override
    public void maintain() {
        System.out.println("Bike Maintenance Checklist:");
        System.out.println("- Check chain tension and lubrication");
        System.out.println("- Check tire pressure and condition");
        System.out.println("- Check brake pads and fluid");
        System.out.println("- Check oil level and change if needed");
        System.out.println("- Check air filter");
        System.out.println("- Check spark plug");
        if (hasABS) {
            System.out.println("- Check ABS system");
        }
        System.out.println("Bike type: " + bikeType + " - Specialized maintenance applied");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        String fuel = fuelType();
        if (fuel.equals("Electric")) {
            return 8.0; // miles per kWh
        } else {
            // Bikes generally have better fuel efficiency than cars
            if (engineCC <= 150) {
                return 75.0; // miles per gallon
            } else if (engineCC <= 350) {
                return 60.0; // miles per gallon
            } else {
                return 45.0; // miles per gallon
            }
        }
    }
    
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Bike Type: " + bikeType);
        System.out.println("Engine Capacity: " + engineCC + " CC");
        System.out.println("ABS: " + (hasABS ? "Yes" : "No"));
        System.out.println("Fuel Efficiency: " + calculateFuelEfficiency() + 
                          (fuelType().equals("Electric") ? " miles/kWh" : " mpg"));
    }
    
    public void doWheelie() {
        System.out.println(brand + " " + model + " is doing a wheelie! ( stunt only )");
    }
    
    public void leanIntoTurn() {
        System.out.println("Leaning into turn with " + brand + " " + model);
    }
}
