package eapli.base.domain.candidate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TelephoneNumberTest {

    @Test
    public void testConstructor() {
        long expectedNumber = 123456789L;
        TelephoneNumber telephoneNumber = new TelephoneNumber(expectedNumber);
        assertNotNull(telephoneNumber, "TelephoneNumber instance should not be null");
        assertEquals(expectedNumber, telephoneNumber.telephoneNumber(), "TelephoneNumber should be initialized with the correct value");
    }

    @Test
    public void testGetter() {
        long expectedNumber = 987654321L;
        TelephoneNumber telephoneNumber = new TelephoneNumber(expectedNumber);
        assertEquals(expectedNumber, telephoneNumber.telephoneNumber(), "Getter should return the correct telephone number");
    }

    @Test
    public void testToString() {
        long number = 5551234567L;
        TelephoneNumber telephoneNumber = new TelephoneNumber(number);
        String expectedString = "TelephoneNumber{telephoneNumber=" + number + "}";
        assertEquals(expectedString, telephoneNumber.toString(), "toString should return the correct string representation");
    }

    @Test
    public void testEmptyConstructor() {
        TelephoneNumber telephoneNumber = new TelephoneNumber();
        assertNotNull(telephoneNumber, "TelephoneNumber instance should not be null even when using the empty constructor");
    }
}
