package org.example;

//The Motorcycle class which extends the Vehicle class and implements the Rentable interface.

public class Motorcycle extends Vehicle implements Rentable{
    private String type;
    private int topSpeed;
    private String fuelType;
    private String colour;

    //Constructor to initialize a Motorcycle object.
    public Motorcycle(String vehicleId, String model, double baseRentalRate, String type, int topSpeed, String fuelType, String colour) {
        super(vehicleId, model, baseRentalRate);
        this.type = type;
        this.topSpeed = topSpeed;
        this.fuelType = fuelType;
        this.colour = colour;
    }

    //Calculates the rental cost for the motorcycle
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (days >= 7) {
            cost = cost * 3;
        }
        if (topSpeed > 200) {
            cost = cost * 2;
        }
        if (fuelType.equals("Petrol")) {
            cost = cost * 1.5;
        } else if ("Electric".equals(fuelType)) {
            cost = cost * 2;
        } else {
            cost = cost * 1;
        }
        return cost;
    }

    public boolean isAvailableForRental() {
        return getIsAvailable();
    }

    //Rents the motorcycle to a customer for a specified number of days.

    public void rent(Customer customer, int days) {
        if (!getIsAvailable()) {
            System.out.println("Motorcycle is not available for rental.");
            return;
        }

        double cost = calculateRentalCost(days);
        System.out.println("Motorcycle rented to " + customer.getName() + " for " + days + " days. Total cost: Cedis " + cost);
        setIsAvailable(false);
    }

    //Handles the return of the motorcycle and updates its availability.
    public void returnVehicle() {
        System.out.println("Motorcycle returned. Thank you!");
        setIsAvailable(true);
    }

}


