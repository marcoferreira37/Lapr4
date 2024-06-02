package eapli.base.domain.candidate;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CandidateTest {

    private SystemUser systemUser;
    private EmailAddress emailAddress;
    private TelephoneNumber telephoneNumber;
    private String curriculum;

    @BeforeEach
    public void setUp() {
        systemUser = mock(SystemUser.class);
        emailAddress = EmailAddress.valueOf("candidate@example.com");
        telephoneNumber = new TelephoneNumber(123456789);
        curriculum = "Sample Curriculum";
    }

    @Test
    public void testCandidateConstructor() {

        Candidate candidate = new Candidate(systemUser, emailAddress, telephoneNumber, curriculum);


        assertNotNull(candidate);
        assertEquals(systemUser, candidate.user());
        assertEquals(emailAddress, candidate.emailAddress());
        assertEquals(telephoneNumber, candidate.telephoneNumber());
        assertEquals(curriculum, candidate.curriculum());
    }

    @Test
    public void testConstructorWithNullSystemUser() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Candidate(null, emailAddress, telephoneNumber, curriculum);
        });
        assertEquals("systemUser cannot be null", exception.getMessage());
    }

    @Test
    public void testConstructorWithNullTelephoneNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Candidate(systemUser, emailAddress, null, curriculum);
        });
        assertEquals("telephoneNumber cannot be null", exception.getMessage());
    }

    @Test
    public void testHashCode() {

        Candidate candidate1 = new Candidate(systemUser, emailAddress, telephoneNumber, curriculum);
        Candidate candidate2 = new Candidate(systemUser, emailAddress, telephoneNumber, curriculum);

        assertEquals(candidate1.hashCode(), candidate2.hashCode());
    }

    @Test
    public void testSameAs() {

        Candidate candidate1 = new Candidate(systemUser, emailAddress, telephoneNumber, curriculum);
        Candidate candidate2 = new Candidate(systemUser, emailAddress, telephoneNumber, curriculum);


        assertTrue(candidate1.sameAs(candidate2));
        assertFalse(candidate1.sameAs(new Object()));
    }

    @Test
    public void testIdentity() {

        Candidate candidate = new Candidate(systemUser, emailAddress, telephoneNumber, curriculum);


        assertEquals(emailAddress, candidate.identity());
    }

    @Test
    public void testToString() {

        Candidate candidate = new Candidate(systemUser, emailAddress, telephoneNumber, curriculum);


        String result = candidate.toString();


        assertNotNull(result);
        assertTrue(result.contains(emailAddress.toString()));
        assertTrue(result.contains(telephoneNumber.toString()));
        assertTrue(result.contains(curriculum));
    }
}
