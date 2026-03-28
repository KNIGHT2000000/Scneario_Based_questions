package unit1.vehicle;

public class Bike extends Vehicle {
    private String bikeType;
    private int engineCC;
    
    public Bike(String vehicleNumber, double rentPerDay, String bikeType, int engineCC) {
        super(vehicleNumber, rentPerDay);
        this.bikeType = bikeType;
        this.engineCC = engineCC > 0 ? engineCC : 150;
    }
    
    public String getBikeType() {
        return bikeType;
    }
    
    public int getEngineCC() {
        return engineCC;
    }
    
    @Override
    public double calculateRent(int days) {
        double baseRent = super.calculateRent(days);
        // Bikes have different pricing based on engine capacity
        if (engineCC >= 500) {
            return baseRent * 1.3; // 30% extra for high-performance bikes
        } else if (engineCC >= 350) {
            return baseRent * 1.15; // 15% extra for medium-performance bikes
        }
        return baseRent;
    }
    
    @Override
    public void displayVehicleInfo() {
        System.out.println("Bike Information:");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Bike Type: " + bikeType);
        System.out.println("Engine Capacity: " + engineCC + " CC");
        System.out.println("Rent Per Day: $" + rentPerDay);
    }
    
    public void displayBikeFeatures() {
        System.out.println("Bike Features:");
        System.out.println("- Type: " + bikeType);
        System.out.println("- Engine: " + engineCC + " CC");
        System.out.println("- Fuel Type: Petrol");
        System.out.println("- Helmet Included: Yes");
    }
}
