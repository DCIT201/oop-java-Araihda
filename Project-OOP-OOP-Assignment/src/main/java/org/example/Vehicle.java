package org.example;

//Abstract class representing a general Vehicle.This class provides a blueprint for specific vehicle types.

public abstract class Vehicle {

    // A unique identifier for each vehicle.
    private String vehicleId;

    //The model name of the vehicle.
    private String model;

    //The base daily rental rate for the vehicle.
    private double baseRentalRate;

    //Shows if the vehicle is available for rental.
    private boolean isAvailable;

    //Constructor to initialize a vehicle

    public Vehicle(String vehicleId, String model, double baseRentalRate){
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
    }

    //Retrieves the unique vehicle identifier.
    public String getVehicleId(){
        return vehicleId;
    }

    //Retrieves the model name of the vehicle.
    public String getModel(){
        return model;
    }

    //Retrieves the base rental rate for the vehicle.
    public double getBaseRentalRate(){
        return baseRentalRate;
    }

    //Checks if the vehicle is currently available.
    public boolean getIsAvailable(){
        return isAvailable;
    }

    //Sets the availability status of the vehicle.
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    //Abstract method to calculate the total rental cost for a given number of days.
    public abstract double calculateRentalCost(int days);

    //Abstract method to determine if the vehicle is eligible for rental.
    public abstract boolean isAvailableForRental();
}



