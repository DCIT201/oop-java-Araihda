package org.example;

public class Truck extends Vehicle implements Rentable {
    private String loadType; //The type of Load the truck takes
    private int numberOfAxles; //The number of axles the truck has
    private int enginePower; //The engine power of the truck
    private double towingCapacity; //The towing capacity of the truck

    //Constructors
    public Truck(String vehicleId, String model, double baseRentalRate, String loadType, int numberOfAxles, int enginePower, double towingCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadType = loadType;
        this.numberOfAxles = numberOfAxles;
        this.enginePower = enginePower;
        this.towingCapacity = towingCapacity;
    }

    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (days >= 7) {
            cost = cost * 4;
        }
        if (enginePower > 200) {
            cost = cost * 2.5 * days;
        }
        if (towingCapacity > 5000) {
            cost = cost * 2 * days;
        } else {
            cost = cost * 0.8 * days;
        }
        return cost;
    }

    public boolean isAvailableForRental() {
        return getIsAvailable();
    }

    public void rent(Customer customer, int days) {
        if (!getIsAvailable()) {
            System.out.println("Truck is not available for rental.");
            return;
        }

        double cost = calculateRentalCost(days);
        System.out.println("Truck rented to " + customer.getName() + " for " + days + " days. Total cost: Cedis " + cost);
        setIsAvailable(false);
    }

    public void returnVehicle() {
        System.out.println("Truck returned. Thank you!");
        setIsAvailable(true);
    }

}


