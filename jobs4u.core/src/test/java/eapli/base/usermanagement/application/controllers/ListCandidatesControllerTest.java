package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.candidate.Candidate;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class ListCandidatesControllerTest {

    @Mock
    private AuthorizationService authz;

    @Mock
    private UserManagementService userSvc;

    @Mock
    private CandidateManagementService candidateSvc;

    @InjectMocks
    private ListCandidatesController controller;

    private List<Candidate> allCandidates;

    @BeforeEach
    public void setUp() {
        // Initialize the candidate list
        allCandidates = new ArrayList<>();

        // Mock active and inactive candidates
        SystemUser activeUser = mock(SystemUser.class);
        when(activeUser.isActive()).thenReturn(true);

        SystemUser inactiveUser = mock(SystemUser.class);
        when(inactiveUser.isActive()).thenReturn(false);

        Candidate activeCandidate = mock(Candidate.class);
        when(activeCandidate.user()).thenReturn(activeUser);

        Candidate inactiveCandidate = mock(Candidate.class);
        when(inactiveCandidate.user()).thenReturn(inactiveUser);

        allCandidates.add(activeCandidate);
        allCandidates.add(inactiveCandidate);

        // Mock the candidate service
        when(candidateSvc.allCandidate()).thenReturn(allCandidates);
    }

    @Test
    public void testAllCandidates() {
        // Mock authorization
        doNothing().when(authz).ensureAuthenticatedUserHasAnyOf(any());

        Iterable<Candidate> candidates = controller.allCandidates();

        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(any());
        assertEquals(allCandidates, candidates);
    }

    @Test
    public void testEnabledCandidates() {
        // Mock authorization
        doNothing().when(authz).ensureAuthenticatedUserHasAnyOf(any());

        Iterable<Candidate> candidates = controller.enabledCandidates();
        List<Candidate> enabledCandidates = new ArrayList<>();
        candidates.forEach(enabledCandidates::add);

        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(any());
        assertEquals(1, enabledCandidates.size());
        assertTrue(enabledCandidates.get(0).user().isActive());
    }

    @Test
    public void testDisabledCandidates() {
        // Mock authorization
        doNothing().when(authz).ensureAuthenticatedUserHasAnyOf(any());

        Iterable<Candidate> candidates = controller.disabledCandidates();
        List<Candidate> disabledCandidates = new ArrayList<>();
        candidates.forEach(disabledCandidates::add);

        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(any());
        assertEquals(1, disabledCandidates.size());
        assertTrue(!disabledCandidates.get(0).user().isActive());
    }
}
