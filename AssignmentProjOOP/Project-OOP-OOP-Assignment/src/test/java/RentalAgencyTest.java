import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
// Unit test for RentalAgency class
public class RentalAgencyTest {

    @Test
    public void testAddVehicle() {
        RentalAgency agency = new RentalAgency("JCAR WORLD LIMITED");
        Motorcycle motorcycle = new Motorcycle("M001", "Yamaha R1", 150.0, "Sport", 220, "Petrol", "Red");

        agency.addVehicle(motorcycle);

        List<Vehicle> vehicles = agency.getVehicles();
        assertEquals(1, vehicles.size(), "Agency should have 1 vehicle in the inventory.");
        assertEquals(motorcycle, vehicles.getFirst(), "The motorcycle added should be in the vehicles list.");
    }

    @Test
    public void testAddTransaction() {
        RentalAgency agency = new RentalAgency("JCAR WORLD LIMITED");
        Customer customer = new Customer("Joe Ansah", "24 Royal Street", "0207933550", "C111", "joeAnsah@gmail.com");
        Motorcycle motorcycle = new Motorcycle("M001", "Yamaha R1", 150.0, "Sport", 220, "Petrol", "Red");

        RentalTransaction transaction = new RentalTransaction(
                "T001", motorcycle, customer, null, null, 3, 450.0
        );
        agency.addTransaction(transaction);

        List<String> transactions = agency.listTransactions();
        assertEquals(1, transactions.size(), "Agency should have 1 transaction recorded.");
        assertTrue(transactions.getFirst().contains("Rental ID: T001"), "Transaction details should include the correct rental ID.");
        assertTrue(transactions.getFirst().contains("Joe Ansah"), "Transaction details should include the customer's name.");
        assertTrue(transactions.getFirst().contains("Yamaha R1"), "Transaction details should include the rented vehicle's model.");
    }
}



