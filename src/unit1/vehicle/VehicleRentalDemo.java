package unit1.vehicle;

public class VehicleRentalDemo {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Rental System Demo ===\n");
        
        Car car1 = new Car("CAR-001", 50.0, "Sedan", 4);
        Car car2 = new Car("CAR-002", 80.0, "Luxury", 4);
        Car car3 = new Car("CAR-003", 60.0, "SUV", 5);
        
        Bike bike1 = new Bike("BIKE-001", 25.0, "Sport", 600);
        Bike bike2 = new Bike("BIKE-002", 20.0, "Cruiser", 350);
        Bike bike3 = new Bike("BIKE-003", 15.0, "Standard", 150);
        
        System.out.println("Available Cars:");
        car1.displayVehicleInfo();
        System.out.println();
        car2.displayVehicleInfo();
        System.out.println();
        car3.displayVehicleInfo();
        System.out.println();
        
        System.out.println("Available Bikes:");
        bike1.displayVehicleInfo();
        System.out.println();
        bike2.displayVehicleInfo();
        System.out.println();
        bike3.displayVehicleInfo();
        System.out.println();
        
        System.out.println("=== Rent Calculations ===\n");
        
        int rentalDays = 5;
        
        System.out.println("Car Rentals for " + rentalDays + " days:");
        car1.displayRentDetails(rentalDays);
        car2.displayRentDetails(rentalDays);
        car3.displayRentDetails(rentalDays);
        
        System.out.println("Bike Rentals for " + rentalDays + " days:");
        bike1.displayRentDetails(rentalDays);
        bike2.displayRentDetails(rentalDays);
        bike3.displayRentDetails(rentalDays);
        
        System.out.println("=== Inheritance Demonstration ===");
        System.out.println("- Vehicle is the base class with common properties");
        System.out.println("- Car and Bike inherit from Vehicle class");
        System.out.println("- Each derived class adds specific features");
        System.out.println("- Method overriding provides specialized behavior");
        System.out.println("- Code reusability achieved through inheritance");
        
        System.out.println("\n=== Polymorphism Demonstration ===");
        Vehicle[] vehicles = {car1, car2, bike1, bike2};
        System.out.println("Using base class reference for different vehicle types:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();
            System.out.println("Rent for 3 days: $" + vehicle.calculateRent(3));
            System.out.println();
        }
    }
}
