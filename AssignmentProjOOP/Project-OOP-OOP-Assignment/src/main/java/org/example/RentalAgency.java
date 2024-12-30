package org.example;

import java.util.ArrayList;
import java.util.List;
public class RentalAgency {
    private String agencyName; //The rental agency name
    private List<Vehicle> vehicles; //The list of vehicles the agency has
    private List<RentalTransaction> transactions;


    //Constructors
    public RentalAgency(String agencyName) {
        this.agencyName = agencyName;
        this.vehicles = new ArrayList<Vehicle>();
        this.transactions = new ArrayList<>();
    }

    public String getAgencyName() {
        return agencyName;
    }
    public String toString() {
        return agencyName;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addTransaction(RentalTransaction transaction){
        transactions.add(transaction);
    }
    public List<String> listTransactions() {
        List<String> transactionDetails = new ArrayList<>();
        for (RentalTransaction transaction : transactions) {
            transactionDetails.add(transaction.getTransactionDetails());
        }
        return transactionDetails;
    }



}



