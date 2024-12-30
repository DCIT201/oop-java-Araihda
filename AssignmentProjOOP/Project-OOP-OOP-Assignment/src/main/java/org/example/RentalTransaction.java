package org.example;

import java.time.LocalDate;


public class RentalTransaction {
    private String rentalId;
    private Vehicle vehicle;
    private Customer customer;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private int rentalPeriod;
    private double amountPaid;

    //Constructors
    public RentalTransaction(String rentalId, Vehicle vehicle, Customer customer, LocalDate rentalDate, LocalDate returnDate, int rentalPeriod, double amountPaid) {
        this.rentalId = rentalId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = null;
        this.rentalPeriod = rentalPeriod;
        this.amountPaid = amountPaid;
    }

    public String getRentalId() {
        return rentalId;
    }
    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public Customer getCustomer() {
        return customer;
    }
    public LocalDate getRentalDate() {
        return rentalDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public int getRentalPeriod() {
        return rentalPeriod;
    }
    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }
    public double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public String getTransactionDetails() {
        return "Rental ID: " + rentalId + "\nVehicle: " + vehicle.getModel() + "\nCustomer: " + customer.getName() + "\nRental Date: " + rentalDate + "\nReturn Date: " + returnDate + "\nRental Period: " + rentalPeriod + " days" + "\nAmount Paid: Cedis" + amountPaid;
    }
}




