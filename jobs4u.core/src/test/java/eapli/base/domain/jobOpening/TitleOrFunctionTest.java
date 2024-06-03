package eapli.base.domain.jobOpening;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TitleOrFunctionTest {

    private TitleOrFunction titleOrFunction1;
    private TitleOrFunction titleOrFunction2;
    private TitleOrFunction titleOrFunction3;

    @BeforeEach
    public void setUp() {
        titleOrFunction1 = new TitleOrFunction("A");
        titleOrFunction2 = new TitleOrFunction("A");
        titleOrFunction3 = new TitleOrFunction("B");
    }

    @Test
    public void testConstructor() {
        TitleOrFunction titleOrFunction = new TitleOrFunction("D");
        assertNotNull(titleOrFunction);
        assertEquals("TitleOrFunction{titleOrFunction='D'}", titleOrFunction.toString());
    }

    @Test
    public void testConstructor_nullTitleOrFunction() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TitleOrFunction(null);
        });
        assertEquals("Title or Function cannot be null", exception.getMessage());
    }

    @Test
    public void testConstructor_emptyTitleOrFunction() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TitleOrFunction("");
        });
        assertEquals("Title or Function cannot be empty", exception.getMessage());
    }

    @Test
    public void testEquals_sameObject() {
        assertEquals(titleOrFunction1, titleOrFunction1);
    }

    @Test
    public void testEquals_nullObject() {
        assertNotEquals(null, titleOrFunction1);
    }

    @Test
    public void testEquals_differentClass() {
        assertNotEquals("A", titleOrFunction1);
    }

    @Test
    public void testEquals_equalObjects() {
        assertEquals(titleOrFunction1, titleOrFunction2);
    }

    @Test
    public void testEquals_differentObjects() {
        assertNotEquals(titleOrFunction1, titleOrFunction3);
    }

    @Test
    public void testHashCode_sameObjects() {
        assertEquals(titleOrFunction1.hashCode(), titleOrFunction2.hashCode());
    }

    @Test
    public void testHashCode_differentObjects() {
        assertNotEquals(titleOrFunction1.hashCode(), titleOrFunction3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("TitleOrFunction{titleOrFunction='A'}", titleOrFunction1.toString());
    }
}