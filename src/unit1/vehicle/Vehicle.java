package unit1.vehicle;

public class Vehicle {
    protected String vehicleNumber;
    protected double rentPerDay;
    
    public Vehicle(String vehicleNumber, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.rentPerDay = rentPerDay >= 0 ? rentPerDay : 0.0;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public double getRentPerDay() {
        return rentPerDay;
    }
    
    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay >= 0 ? rentPerDay : 0.0;
    }
    
    public double calculateRent(int days) {
        if (days > 0) {
            return rentPerDay * days;
        }
        return 0.0;
    }
    
    public void displayVehicleInfo() {
        System.out.println("Vehicle Information:");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Rent Per Day: $" + rentPerDay);
    }
    
    public void displayRentDetails(int days) {
        System.out.println("Rent Details:");
        displayVehicleInfo();
        System.out.println("Rental Days: " + days);
        System.out.println("Total Rent: $" + calculateRent(days));
        System.out.println("------------------------");
    }
}
