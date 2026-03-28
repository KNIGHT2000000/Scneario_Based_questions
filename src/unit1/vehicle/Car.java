package unit1.vehicle;

public class Car extends Vehicle {
    private String carType;
    private int numberOfDoors;
    
    public Car(String vehicleNumber, double rentPerDay, String carType, int numberOfDoors) {
        super(vehicleNumber, rentPerDay);
        this.carType = carType;
        this.numberOfDoors = numberOfDoors >= 2 ? numberOfDoors : 4;
    }
    
    public String getCarType() {
        return carType;
    }
    
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    @Override
    public double calculateRent(int days) {
        double baseRent = super.calculateRent(days);
        // Cars have additional charges based on type
        if (carType.equalsIgnoreCase("Luxury")) {
            return baseRent * 1.5; // 50% extra for luxury cars
        } else if (carType.equalsIgnoreCase("SUV")) {
            return baseRent * 1.2; // 20% extra for SUVs
        }
        return baseRent;
    }
    
    @Override
    public void displayVehicleInfo() {
        System.out.println("Car Information:");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Car Type: " + carType);
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Rent Per Day: $" + rentPerDay);
    }
    
    public void displayCarFeatures() {
        System.out.println("Car Features:");
        System.out.println("- Type: " + carType);
        System.out.println("- Doors: " + numberOfDoors);
        System.out.println("- Air Conditioning: Yes");
        System.out.println("- Music System: Yes");
    }
}
