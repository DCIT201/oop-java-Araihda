package org.example;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create Rental Agency
        RentalAgency agency = new RentalAgency(" JCAR WORLD LIMITED");
        System.out.println("Agency Name: " + agency);
        System.out.println(" Details of Vehicles Rented :" +"");

        // Create Vehicles
        Car car = new Car("C001", " Toyota Land Cruiser Prado", 100.0, "Petrol", 5, "Automatic", true);
        Truck truck = new Truck("T001", "Ford F-150", 200.0, "Heavy Load", 2, 250, 6000);
        Motorcycle motorcycle = new Motorcycle("M001", "Yamaha R1", 50.0, "Sport", 220, "Petrol", "Red and Black");

        // Add Vehicles to Agency
        agency.addVehicle(car);
        agency.addVehicle(truck);
        agency.addVehicle(motorcycle);

        // Create Customers
        Customer customer1 = new Customer(" Nana Adjei", " Mango Street", "0552007879", "C001", "nanaAj@gmail.com");
        Customer customer2 = new Customer(" Audrey Hayfron", "46 Avenue", "0208909342", "C002", "audHay@gmail.com");

        // Rent Vehicles
        car.rent(customer1, 7);
        agency.addTransaction(new RentalTransaction("T001", car, customer1, LocalDate.now(), null, 7, car.calculateRentalCost(7)));

        motorcycle.rent(customer2, 5);
        agency.addTransaction(new RentalTransaction("T002", motorcycle, customer2, LocalDate.now(), null, 5, motorcycle.calculateRentalCost(5)));


        // List Transactions
        System.out.println("All Transactions:");
        for (String transaction : agency.listTransactions()) {
            System.out.println(transaction + "\n");
        }

        // Return Vehicles
        car.returnVehicle();
        motorcycle.returnVehicle();
        System.out.println("Vehicles have been returned. Enjoy your day!" + "");
    }
}