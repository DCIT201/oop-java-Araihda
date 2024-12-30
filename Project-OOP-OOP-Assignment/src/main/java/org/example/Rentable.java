package org.example;

public interface Rentable {
    void rent(Customer customer, int days); // For renting a vehicle
    void returnVehicle(); // For returning a rented vehicle
}

