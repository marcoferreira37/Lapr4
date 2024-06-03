package eapli.base.domain.jobOpening;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    private Address address1;
    private Address address2;
    private Address address3;

    @BeforeEach
    public void setUp() {
        address1 = new Address("123 Main St");
        address2 = new Address("123 Main St");
        address3 = new Address("456 Elm St");
    }

    @Test
    public void testConstructor() {
        Address address = new Address("789 Oak St");
        assertNotNull(address);
        assertEquals("789 Oak St", address.toString());
    }

    @Test
    public void testConstructor_nullAddress() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Address(null);
        });
        assertEquals("Address cannot be null", exception.getMessage());
    }

    @Test
    public void testConstructor_emptyAddress() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Address("");
        });
        assertEquals("Address cannot be empty", exception.getMessage());
    }

    @Test
    public void testEquals_sameObject() {
        assertEquals(address1, address1);
    }

    @Test
    public void testEquals_nullObject() {
        assertNotEquals(null, address1);
    }

    @Test
    public void testEquals_differentClass() {
        assertNotEquals("123 Main St", address1);
    }

    @Test
    public void testEquals_equalObjects() {
        assertEquals(address1, address2);
    }

    @Test
    public void testEquals_differentObjects() {
        assertNotEquals(address1, address3);
    }

    @Test
    public void testHashCode_sameObjects() {
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void testHashCode_differentObjects() {
        assertNotEquals(address1.hashCode(), address3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("123 Main St", address1.toString());
    }

    @Test
    public void testIsNull() {
        Address address = new Address("Test");
        assertTrue(address.isNull(null));
        assertFalse(address.isNull("Not null"));
    }

    @Test
    public void testIsEmpty() {
        Address address = new Address("Test");
        assertTrue(address.isEmpty(""));
        assertFalse(address.isEmpty("Not empty"));
    }

    @Test
    public void testIsString() {
        Address address = new Address("Test");
        assertTrue(address.isString("String"));
        assertFalse(address.isString(123));
    }

    @Test
    public void testValidateAddress_valid() {
        Address address = new Address("Valid Address");
        assertNotNull(address);
    }

    @Test
    public void testValidateAddress_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Address(null);
        });
        assertEquals("Address cannot be null", exception.getMessage());
    }

    @Test
    public void testValidateAddress_empty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Address("");
        });
        assertEquals("Address cannot be empty", exception.getMessage());
    }

}