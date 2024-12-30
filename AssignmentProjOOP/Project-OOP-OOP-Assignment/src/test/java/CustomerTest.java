import org.example.Customer;
import org.example.RentalTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Unit test for Customer class
public class CustomerTest {

    @Test
    public void testCustomerDetailsAndRentalHistory() {
        Customer customer = new Customer("Joe Ansah", " 24 Royal Street", "0207933550", "C111", "joeAnsah@gmail.com");
        RentalTransaction rentalTransaction = new RentalTransaction(
                "R001", null, customer, null, null, 5, 100.0
        );

        customer.addRentalTransaction(rentalTransaction);

        assertEquals("Joe Ansah", customer.getName());
        assertEquals(1, customer.getRentalHistory().size());
        assertEquals(rentalTransaction, customer.getRentalHistory().getFirst());
    }
}

