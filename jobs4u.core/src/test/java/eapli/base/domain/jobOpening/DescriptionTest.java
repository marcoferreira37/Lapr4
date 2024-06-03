package eapli.base.domain.jobOpening;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionTest {

    private Description description1;
    private Description description2;
    private Description description3;

    @BeforeEach
    public void setUp() {
        description1 = new Description("Pedreiro de massas");
        description2 = new Description("Bombeiro de fogos");
        description3 = new Description("Agricultor da terra");
    }

    @Test
    public void testConstructor() {
        Description description = new Description("Pistoleiro de aluguel");
        assertNotNull(description);
        assertEquals("Pistoleiro de aluguel", description.toString());
    }

    @Test
    public void testConstructor_nullDescription() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Description(null);
        });
        assertEquals("Description cannot be null", exception.getMessage());
    }

    @Test
    public void testConstructor_emptyDescription() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Description("");
        });
        assertEquals("Description cannot be empty", exception.getMessage());
    }

    @Test
    public void testEquals_sameObject() {
        assertEquals(description1, description1);
    }

    @Test
    public void testEquals_nullObject() {
        assertNotEquals(null, description1);
    }

    @Test
    public void testEquals_differentClass() {
        assertNotEquals("Cozinheiro", description1);
    }

    @Test
    public void testEquals_differentObjects() {
        assertNotEquals(description1, description3);
    }

    @Test
    public void testEquals_equalObjects() {
        Description description = new Description("Pedreiro de massas");
        assertEquals(description1, description);
    }

    @Test
    public void testHashCode_sameObjects() {
        assertEquals(description1.hashCode(), description1.hashCode());
    }

    @Test
    public void testHashCode_differentObjects() {
        assertNotEquals(description1.hashCode(), description3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Bombeiro de fogos", description2.toString());
    }

    @Test
    public void testIsNull() {
        assertTrue(description1.isNull(null));
        assertFalse(description1.isNull("Not null"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(description1.isEmpty(""));
        assertFalse(description1.isEmpty("Not empty"));
    }

    @Test
    public void testIsString() {
        assertTrue(description1.isString("String"));
        assertFalse(description1.isString(123));
    }

    @Test
    public void testValidateDescription_valid() {
        Description description = new Description("Valid Description");
        assertNotNull(description);
    }

    @Test
    public void testValidateDescription_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Description(null);
        });
        assertEquals("Description cannot be null", exception.getMessage());
    }

    @Test
    public void testValidateDescription_empty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Description("");
        });
        assertEquals("Description cannot be empty", exception.getMessage());
    }

}