package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.service.JobOpeningApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UploadTextFileControllerTest {

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configure the AuthorizationService
        UserRepository authzService = mock(UserRepository.class);
        AuthzRegistry.configure(authzService, null, null);

        // Other setup code...
    }

    @Mock
    private AuthorizationService authz;

    @Mock
    private CandidateManagementService candidateSvc;

    @Mock
    private JobOpeningApplicationService jobOpeningApplicationService;

    @Mock
    private JobOpeningApplicationRepository applicationRepo;

    @InjectMocks
    private UploadTextFileController controller;
    @Test
    public void testAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        when(candidateSvc.allCandidate()).thenReturn(candidates);

        Iterable<Candidate> result = controller.allCandidates();

        assertEquals(candidates, result);
        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(any());
    }

    @Test
    public void testGetAppByCandidate() {
        Candidate candidate = mock(Candidate.class);
        List<JobOpeningApplication> applications = new ArrayList<>();
        when(jobOpeningApplicationService.getApplicationsByCandidate(candidate)).thenReturn(applications);

        List<JobOpeningApplication> result = controller.getAppByCandidate(candidate);

        assertEquals(applications, result);
    }

    @Test
    public void testUploadFile() {
        JobOpeningApplication app = mock(JobOpeningApplication.class);
        String file = "test.txt";

        controller.uploadFile(app, file);

        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(any());
        verify(applicationRepo, times(1)).save(app);
    }
}