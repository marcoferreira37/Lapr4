package eapli.base.candidate;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.TelephoneNumber;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CandidateManagementServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateManagementService candidateManagementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterNewCandidate() {
        SystemUser newUser = mock(SystemUser.class);
        EmailAddress emailAddress = mock(EmailAddress.class);
        TelephoneNumber telephoneNumber = mock(TelephoneNumber.class);
        String curriculum = "Test curriculum";

        Candidate savedCandidate = mock(Candidate.class);
        when(candidateRepository.save(any())).thenReturn(savedCandidate);

        Candidate result = candidateManagementService.registerNewCandidate(newUser, emailAddress, telephoneNumber, curriculum);

        assertEquals(savedCandidate, result);

        verify(candidateRepository, times(1)).save(any());
    }

    @Test
    void testAllCandidate() {
        List<Candidate> candidates = new ArrayList<>();
        when(candidateRepository.findAllCandidates()).thenReturn(candidates);

        Iterable<Candidate> result = candidateManagementService.allCandidate();

        assertEquals(candidates, result);

        verify(candidateRepository, times(1)).findAllCandidates();
    }

    @Test
    void testUserOfIdentity() {
        EmailAddress emailAddress = mock(EmailAddress.class);
        Optional<Candidate> candidate = Optional.of(mock(Candidate.class));
        when(candidateRepository.ofIdentity(emailAddress)).thenReturn(candidate);

        Optional<Candidate> result = candidateManagementService.userOfIdentity(emailAddress);

        assertEquals(candidate, result);

        verify(candidateRepository, times(1)).ofIdentity(emailAddress);
    }

    @Test
    void testGetCandidate() {
        JobOpeningApplication jobOpeningApplication = mock(JobOpeningApplication.class);
        List<Candidate> candidates = new ArrayList<>();
        when(candidateRepository.getCandidate(jobOpeningApplication)).thenReturn(candidates);

        Iterable<Candidate> result = candidateManagementService.getCandidate(jobOpeningApplication);

        assertEquals(candidates, result);

        verify(candidateRepository, times(1)).getCandidate(jobOpeningApplication);
    }

    @Test
    void testCandidatesOfJobOpening() {
        JobOpening jobOpening = mock(JobOpening.class);
        List<Candidate> candidates = new ArrayList<>();
        when(candidateRepository.findAllCandidates()).thenReturn(candidates);

        Iterable<Candidate> result = candidateManagementService.candidatesOfJobOpening(jobOpening);

        assertEquals(candidates, result);

        verify(candidateRepository, times(1)).findAllCandidates();
    }
}
