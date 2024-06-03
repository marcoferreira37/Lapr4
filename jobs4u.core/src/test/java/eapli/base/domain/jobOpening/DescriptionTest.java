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
    public void testHashCode_differentObjects() {
        assertNotEquals(description1.hashCode(), description3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Bombeiro de fogos", description2.toString());
    }

}