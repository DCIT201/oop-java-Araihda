import org.example.Customer;
import org.example.Motorcycle;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
// Unit test for Motorcycle class
public class MotorcycleTest {

    @Test
    public void testCalculateRentalCost() {
        Motorcycle motorcycle = new Motorcycle("M001", "Yamaha R1", 150.0, "Sport", 220, "Petrol", "Red");

        // Test rental cost for 3 days (Petrol, topSpeed > 200)
        double cost = motorcycle.calculateRentalCost(3);
        assertEquals(1350.0, cost, "Rental cost for 3 days with sports motorcycle and petrol.");

        // Test rental cost for 7 days (Petrol, topSpeed > 200)
        cost = motorcycle.calculateRentalCost(7);
        assertEquals(9450.0, cost, "Rental cost for 7 days with sports motorcycle and petrol.");

        // Test rental cost with electric motorcycle
        Motorcycle electricMotorcycle = new Motorcycle("M002", "Zero SR/F", 150.0, "Cruiser", 150, "Electric", "Black");
        cost = electricMotorcycle.calculateRentalCost(5);
        assertEquals(1500.0, cost, "Rental cost for 5 days with electric motorcycle.");
    }

    @Test
    public void testIsAvailableForRental() {
        Motorcycle motorcycle = new Motorcycle("M001", "Yamaha R1", 100.0, "Sport", 220, "Petrol", "Red");

        // Initially, the motorcycle should be available for rental
        assertTrue(motorcycle.isAvailableForRental(), "Motorcycle should be available for rental by default.");

        // Simulate the motorcycle being rented
        motorcycle.setIsAvailable(false);
        assertFalse(motorcycle.isAvailableForRental(), "Motorcycle should not be available after being rented.");
    }

    @Test
    public void testRentAndReturn() {
        Motorcycle motorcycle = new Motorcycle("M003", "Harley Davidson", 200.0, "Cruiser", 180, "Petrol", "Black");

        // Create a test customer instance
        Customer customer = new Customer("Mike Gentle", "26 Madina Street", "0559506900", "CUST001", "mkgentle@gmail.com");

        // Rent the motorcycle
        motorcycle.rent(customer, 3); // Renting for 3 days

        // Verify if the motorcycle is no longer available
        assertFalse(motorcycle.isAvailableForRental(), "Motorcycle should not be available after being rented.");

        // Return the motorcycle
        motorcycle.returnVehicle();

        // Verify if the motorcycle is now available
        assertTrue(motorcycle.isAvailableForRental(), "Motorcycle should be available after being returned.");
    }
}


