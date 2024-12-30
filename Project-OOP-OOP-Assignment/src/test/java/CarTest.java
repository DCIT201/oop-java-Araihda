import org.example.Car;
import org.example.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCalculateRentalCost() {
        Car car = new Car("C001", "Hyundai Elantra", 150.0, "Petrol", 5, "Automatic", true);

        // Test rental cost for less than 7 days
        double cost = car.calculateRentalCost(3);
        assertEquals(2700.0, cost, "Rental cost calculation for 3 days with automatic car and air conditioning.");

        // Test rental cost for 7 or more days
        cost = car.calculateRentalCost(7);
        assertEquals(6930.0, cost,"Rental cost calculation for 7 days with automatic car and air conditioning.");
    }

    @Test
    public void testIsAvailableForRental() {
        Car car = new Car("C001", "Hyundai Elantra", 100.0, "Petrol", 5, "Manual", false);

        // Initially, the car should be available
        assertTrue(car.isAvailableForRental(), "Car should be available for rental by default.");

        // Simulate renting a car
        car.setIsAvailable(false);
        assertFalse(car.isAvailableForRental(), "Car should not be available after setting availability to false.");
    }

    @Test
    public void testRentAndReturn() {
        Car car = new Car("C001", "Hyundai Elantra", 100.0, "Petrol", 5, "Automatic", true);

        // Create a test customer instance
        Customer customer = new Customer("Sharon Stone", "24 Royal Palm Street", "0242788940", "CUST001", "sharon@gmail.com");

        // Rent the car
        car.rent(customer, 2); // Renting for 2 days

        // Verify the car is no longer available
        assertFalse(car.isAvailableForRental(), "Car should not be available after being rented.");

        // Returning the car
        car.returnVehicle();

        // Verify the car is now available
        assertTrue(car.isAvailableForRental(), "Car should be available after being returned.");
    }
}

