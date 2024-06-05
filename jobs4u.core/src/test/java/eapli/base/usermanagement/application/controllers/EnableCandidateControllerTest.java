package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.candidate.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.base.repositories.CandidateRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class EnableCandidateControllerTest {

    @Mock
    private AuthorizationService authz;

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private EnableCandidateController controller;

    private List<Candidate> candidates;

    @BeforeEach
    public void setUp() {
        // Initialize the candidate list
        candidates = new ArrayList<>();

        // Mock candidates
        SystemUser inactiveUser = mock(SystemUser.class);
        when(inactiveUser.isActive()).thenReturn(false);

        Candidate candidate = mock(Candidate.class);
        when(candidate.emailAddress()).thenReturn(EmailAddress.valueOf("candidate@example.com"));
        when(candidate.user()).thenReturn(inactiveUser);

        candidates.add(candidate);

        // Mock the candidate repository
        when(candidateRepository.findAll()).thenReturn(candidates);
    }

    @Test
    public void testEnableCandidate() {
        // Mock authorization
        doNothing().when(authz).ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);

        controller.enableCandidate("candidate@example.com");

        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);
        verify(candidateRepository, times(1)).findAll();
        verify(candidateRepository, times(1)).save(any(Candidate.class));
        verify(candidates.get(0).user(), times(1)).activate();
    }

    @Test
    public void testEnableCandidateNotFound() {
        // Mock authorization
        doNothing().when(authz).ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);

        assertThrows(IllegalArgumentException.class, () -> {
            controller.enableCandidate("nonexistent@example.com");
        });

        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);
        verify(candidateRepository, times(1)).findAll();
        verify(candidateRepository, times(0)).save(any(Candidate.class));
    }
}
