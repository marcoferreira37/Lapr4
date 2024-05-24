package eapli.base.domain;

import eapli.base.customer.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {


    @Test
    void testCheckUsername() {
        assertTrue(Customer.checkUsername("Username"));
        assertFalse(Customer.checkUsername(""));
    }

    @Test
    void testCheckName() {
        assertTrue(Customer.checkName("Firstname"));
        assertFalse(Customer.checkName(""));
    }

    @Test
    void testCheckEmail() {
        assertTrue(Customer.checkEmail("Isep@ipp.pt"));
        assertFalse(Customer.checkEmail(""));
    }





}
