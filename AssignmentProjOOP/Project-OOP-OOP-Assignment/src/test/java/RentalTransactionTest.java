import org.example.Customer;
import org.example.RentalTransaction;
import org.example.Vehicle;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class RentalTransactionTest {

    @Test
    void testRentalTransactionCreationAndGetters() {
        // Mock objects for Vehicle and Customer
        Vehicle vehicle = new TestVehicle("VH005", "Kia Carnival", 100.0);
        Customer customer = new Customer("Joshua Addo", " Apple Street", "0504907733", "CUST005", "joshAddo@gmail.com");

        // Create RentalTransaction object
        RentalTransaction transaction = new RentalTransaction("RT005", vehicle, customer, LocalDate.of(2024, 10, 1), null, 7, 700.0);

        // Verify using getters
        assertEquals("RT005", transaction.getRentalId());
        assertEquals(vehicle, transaction.getVehicle());
        assertEquals(customer, transaction.getCustomer());
        assertEquals(LocalDate.of(2024, 10, 1), transaction.getRentalDate());
        assertNull(transaction.getReturnDate());
        assertEquals(7, transaction.getRentalPeriod());
        assertEquals(700.0, transaction.getAmountPaid());
    }

    @Test
    void testSettersAndTransactionDetails() {
        // Mock objects for Vehicle and Customer
        Vehicle vehicle = new TestVehicle("VH006", "Honda Civic", 150.0);
        Customer customer = new Customer("Jane Ampadu", "45 Avenue Strret", "0248080922", "CUST006", "janeAmpadu@gmail.com");

        // Create RentalTransaction object
        RentalTransaction transaction = new RentalTransaction("RT006", vehicle, customer, LocalDate.of(2024, 10, 5), null, 5, 750.0);

        // Test setters
        transaction.setReturnDate(LocalDate.of(2024, 10, 10));
        transaction.setRentalPeriod(6);
        transaction.setAmountPaid(900.0);

        assertEquals(LocalDate.of(2024, 10, 10), transaction.getReturnDate());
        assertEquals(6, transaction.getRentalPeriod());
        assertEquals(900.0, transaction.getAmountPaid());

        // Verify transaction details
        String expectedDetails = "Rental ID: RT006\n" + "Vehicle: Honda Civic\n" + "Customer: Jane Ampadu\n" + "Rental Date: 2024-10-05\n" + "Return Date: 2024-10-10\n" + "Rental Period: 6 days\n" + "Amount Paid: Cedis900.0";

        assertEquals(expectedDetails, transaction.getTransactionDetails());
    }

    // Mock TestVehicle class to satisfy abstract Vehicle implementation
    class TestVehicle extends Vehicle {
        public TestVehicle(String vehicleId, String model, double baseRentalRate) {
            super(vehicleId, model, baseRentalRate);
        }

        @Override
        public double calculateRentalCost(int days) {
            return days * getBaseRentalRate();
        }

        @Override
        public boolean isAvailableForRental() {
            return getIsAvailable();
        }
    }
}

