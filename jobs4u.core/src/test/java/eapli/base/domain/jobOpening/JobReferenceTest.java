package eapli.base.domain.jobOpening;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobReferenceTest {
    private JobReference jobReference1;
    private JobReference jobReference2;
    private JobReference jobReference3;

    @BeforeEach
    void setUp() {
        jobReference1 = new JobReference(123L, "COMP");
        jobReference2 = new JobReference(456L, "COMP");
        jobReference3 = new JobReference(123L, "COMP");
    }

    @Test
    void testConstructor() {
        JobReference jobRef = new JobReference(789L, "ABC");
        assertNotNull(jobRef);
        assertEquals("ABC-789", jobRef.fullReference());
    }

    @Test
    void testConstructor_nullJobReference() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobReference(null, "COMP");
        });
        assertEquals("Job Reference cannot be null", exception.getMessage());
    }

    @Test
    void testConstructor_negativeJobReference() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobReference(-1L, "COMP");
        });
        assertEquals("Job Reference cannot be negative", exception.getMessage());
    }

    @Test
    void testConstructor_nullCompanyIndex() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobReference(123L, null);
        });
        assertEquals("Company index cannot be null", exception.getMessage());
    }

    @Test
    void testConstructor_emptyCompanyIndex() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobReference(123L, "");
        });
        assertEquals("Company index cannot be empty", exception.getMessage());
    }

    @Test
    void testID() {
        assertEquals(123L, jobReference1.iD());
    }

    @Test
    void testFullReference() {
        assertEquals("COMP-123", jobReference1.fullReference());
    }

    @Test
    void testToString() {
        assertEquals("JobReference{COMP-123}", jobReference1.toString());
    }

    @Test
    void testCompareTo_same() {
        assertEquals(0, jobReference1.compareTo(jobReference3));
    }

    @Test
    void testCompareTo_different() {
        assertTrue(jobReference1.compareTo(jobReference2) < 0);
    }

    @Test
    void testEquals_sameObject() {
        assertEquals(jobReference1, jobReference1);
    }

    @Test
    void testEquals_equalObjects() {
        assertEquals(jobReference1, jobReference1);
    }

    @Test
    void testEquals_null() {
        assertNotEquals(null, jobReference1);
    }

    @Test
    void testEquals_differentClass() {
        assertNotEquals(jobReference1, "COMP-123");
    }

    @Test
    void testEquals_differentObjects() {
        assertNotEquals(jobReference1, jobReference2);
    }

    @Test
    void testHashCode_different() {
        assertNotEquals(jobReference1.hashCode(), jobReference2.hashCode());
    }
}