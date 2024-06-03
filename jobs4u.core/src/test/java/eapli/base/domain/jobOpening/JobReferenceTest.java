package eapli.base.domain.jobOpening;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobReferenceTest {

    private JobReference jobReference1;
    private JobReference jobReference2;
    private JobReference jobReference3;

    @BeforeEach
    public void setUp() {
        jobReference1 = new JobReference(1L, "A");
        jobReference2 = new JobReference(2L, "B");
        jobReference3 = new JobReference(3L, "C");
    }

    @Test
    public void testConstructor() {
        JobReference jobReference = new JobReference(4L, "D");
        assertNotNull(jobReference);
        assertEquals("D-4", jobReference.fullReference());
    }

    @Test
    void validateCompanyIndex_nullCompanyIndex() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobReference(1L, null);
        });
        assertEquals("Company index cannot be null", exception.getMessage());
    }

    @Test
    void validateCompanyIndex_emptyCompanyIndex() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobReference(1L, "");
        });
        assertEquals("Company index cannot be empty", exception.getMessage());
    }

    @Test
    void validateJobReference_nullJobReference() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobReference(null, "A");
        });
        assertEquals("Job Reference cannot be null", exception.getMessage());
    }


    @Test
    void validateJobReference_negativeJobReference() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobReference(-1L, "A");
        });
        assertEquals("Job Reference cannot be negative", exception.getMessage());
    }

    @Test
    public void testEquals_sameObject() {
        assertEquals(jobReference1, jobReference1);
    }

    @Test
    public void testEquals_nullObject() {
        assertNotEquals(null, jobReference1);
    }

    @Test
    public void testEquals_differentClass() {
        assertNotEquals("A-1", jobReference1);
    }

    @Test
    public void testEquals_equalObjects() {
        assertEquals(jobReference1, jobReference1);
    }

    @Test
    public void testEquals_differentObjects() {
        assertNotEquals(jobReference1, jobReference2);
    }


}