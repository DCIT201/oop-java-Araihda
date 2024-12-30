package org.example;

// Represents a car that can be rented, extending Vehicle and implementing Rentable.
public class Car extends Vehicle implements Rentable{

    private String fuelType;
    private int numberOfSeats;

    // Transmission type of the car (e.g., Automatic, Manual).
    private String transmissionType;

    private boolean hasAirConditioning;

    // Constructor
    public Car(String vehicleId, String model, double baseRentalRate, String fuelType, int numberOfSeats, String transmissionType, boolean hasAirConditioning){
        super(vehicleId, model, baseRentalRate);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.transmissionType = transmissionType;
        this.hasAirConditioning = hasAirConditioning;
    }
    //Calculates the rental cost for the specified number of days.
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (days == 7) {
            cost += cost * 0.1;
        }
        if (hasAirConditioning) {
            cost += cost * 2.0;
        }
        if (transmissionType.equals("Automatic")) {
            cost += cost * 1.0;
        }else {
            cost += cost * 0.5;
        }
        return cost;

    }
    // Checks if the car is available for rental.
    public boolean isAvailableForRental() {
        return getIsAvailable();
    }

    // Rents the car to a customer for a specified number of days.
    public void rent(Customer customer, int days) {
        if (!getIsAvailable()) {
            System.out.println("Car is not available for rental.");
            return;
        }
        // Calculate the total rental cost for the given period.
        double cost = calculateRentalCost(days);
        System.out.println("Car rented to " + customer.getName() + " for " + days + " days. Total cost: Cedis " + cost);
        setIsAvailable(false);
    }

    public void returnVehicle() {
        System.out.println("Car returned. Thank you!");
        setIsAvailable(true);
    }

    // Polymorphism through method overloading
    public void rent(Customer customer) {
        rent(customer, 1);
    }
}


