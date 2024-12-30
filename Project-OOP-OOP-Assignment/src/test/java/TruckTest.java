import org.example.Customer;
import org.example.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Unit tests for the Truck class.
 * This class covers key functionalities of the Truck class,
 * such as calculating rental costs, managing availability,
 * and handling customer interactions like rentals and returns.
 */
public class TruckTest {

    //Test the calculateRentalCost method.

    @Test
    public void testCalculateRentalCost() {
        // Create a truck instance for testing rental cost
        Truck truck = new Truck("T001", "Volvo VNL", 300.0, "Cargo", 4, 250, 6000.0);

        // Test rental cost for 3 days
        double cost = truck.calculateRentalCost(3);
        assertEquals(40500.0, cost, "Rental cost for 3 days with high engine power and towing capacity.");

        // Test rental cost for 7 days
        cost = truck.calculateRentalCost(7);
        assertEquals(2058000.0, cost, "Rental cost for 7 days with long-term rental adjustment.");

        // Test rental cost for a truck with low towing capacity
        Truck lowTowingTruck = new Truck("T002", "Mack Anthem", 300.0, "Cargo", 2, 180, 4000.0);
        cost = lowTowingTruck.calculateRentalCost(5);
        assertEquals(6000.0, cost, "Rental cost for 5 days with low towing capacity.");
    }

    //Test the isAvailableForRental method.

    @Test
    public void testIsAvailableForRental() {
        // Create a truck instance for testing availability
        Truck truck = new Truck("T003", "Kalmar", 200.0, "Container", 3, 190, 4500.0);

        // Initially, the truck should be available for rental
        assertTrue(truck.isAvailableForRental(), "Truck should be available for rental by default.");
    }

    //Test the rent and return functionality.

    @Test
    public void testRentAndReturn() {

        // Create a truck instance for testing renting and returns
        Truck truck = new Truck("T004", "Freightliner Cascadia", 400.0, "Flatbed", 6, 300, 10000.0);

        // Create a test customer instance
        Customer customer = new Customer("Addy Amaniampong", "Palmer Rd", "0550684400", "CUST001", "addyampong@gmail.com");

        // Rent the truck
        truck.rent(customer, 5);


        // Return the truck
        truck.returnVehicle();
        assertTrue(truck.isAvailableForRental(), "Truck should be available after being returned.");
    }

    //Test invalid rental scenarios.

    @Test
    public void testInvalidRent() {
        // Create a truck instance and set it as unavailable
        Truck truck = new Truck("T005", "Linde", 250.0, "Logistics", 4, 220, 5000.0);
        truck.setIsAvailable(false);
        assertFalse(truck.isAvailableForRental(), "Truck should remain unavailable after a failed rental attempt.");

        //Create a test customer instance
        Customer customer = new Customer("Kofi Tagoe", "Mango street", "0559873300", "CUST002", "tagoeki@gmail.com");

        // Attempt to rent when the truck is unavailable
        assertDoesNotThrow(() -> truck.rent(customer, 3), "Renting an unavailable truck should not throw an exception.");
    }
}


