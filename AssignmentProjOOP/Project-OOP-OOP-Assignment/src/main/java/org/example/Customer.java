package org.example;

import java.util.List;
import java.util.ArrayList;


public class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private String customerId;
    private String email;
    private List<RentalTransaction> rentalHistory;

    //Constructor
    public Customer(String name, String address, String phoneNumber, String customerId, String email){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.customerId = customerId;
        this.email = email;
        this.rentalHistory = new ArrayList<RentalTransaction>();
    }
    //Getters and Setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getCustomerId(){
        return customerId;
    }
    public String getEmail(){
        return email;
    }
    public List<RentalTransaction> getRentalHistory(){
        return rentalHistory;
    }
    public void addRentalTransaction(RentalTransaction rentalTransaction){
        rentalHistory.add(rentalTransaction);
    }





}



