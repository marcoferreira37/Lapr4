package eapli.base.domain.jobOpening;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VacanciesNumberTest {
    private VacanciesNumber vacanciesNumber1;
    private VacanciesNumber vacanciesNumber2;
    private VacanciesNumber vacanciesNumber3;

    @BeforeEach
    public void setUp() {
        vacanciesNumber1 = new VacanciesNumber(1);
        vacanciesNumber2 = new VacanciesNumber(1);
        vacanciesNumber3 = new VacanciesNumber(2);
    }

    @Test
    public void testConstructor() {
        VacanciesNumber vacanciesNumber = new VacanciesNumber(3);
        assertNotNull(vacanciesNumber);
        assertEquals(3, vacanciesNumber.number());
    }

    @Test
    public void testConstructor_negativeVacanciesNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new VacanciesNumber(-1);
        });
        assertEquals("Number of vacancies cannot be negative", exception.getMessage());
    }

    @Test
    public void testEquals_sameObject() {
        assertEquals(vacanciesNumber1, vacanciesNumber1);
    }

    @Test
    public void testEquals_nullObject() {
        assertNotEquals(null, vacanciesNumber1);
    }

    @Test
    public void testEquals_differentClass() {
        assertNotEquals("1", vacanciesNumber1);
    }

    @Test
    public void testEquals_equalObjects() {
        assertEquals(vacanciesNumber1, vacanciesNumber2);
    }

    @Test
    public void testEquals_differentObjects() {
        assertNotEquals(vacanciesNumber1, vacanciesNumber3);
    }

    @Test
    public void testHashCode_sameObjects() {
        assertEquals(vacanciesNumber1.hashCode(), vacanciesNumber2.hashCode());
    }

    @Test
    public void testHashCode_differentObjects() {
        assertNotEquals(vacanciesNumber1.hashCode(), vacanciesNumber3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("VacanciesNumber{number=1}", vacanciesNumber1.toString());
    }

    @Test
    public void testNumber() {
        assertEquals(1, vacanciesNumber1.number());
    }
}