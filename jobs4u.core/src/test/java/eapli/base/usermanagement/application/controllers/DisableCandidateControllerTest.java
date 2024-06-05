package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.candidate.Candidate;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.base.repositories.CandidateRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DisableCandidateControllerTest {

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private AuthorizationService authz;

    @InjectMocks
    private DisableCandidateController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        AuthzRegistry.configure((UserRepository) authz, null, null);
    }

    @Test
    public void testDisableExistingCandidate() {
        // Arrange
        EmailAddress email = EmailAddress.valueOf("candidate@example.com");
        SystemUser systemUser = mock(SystemUser.class);
        Candidate candidate = new Candidate(systemUser, email, null, null);
        when(candidateRepository.findAll()).thenReturn(Arrays.asList(candidate));

        // Act
        Candidate result = controller.disableCandidate(email.toString());

        // Assert
        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);
        verify(systemUser, times(1)).deactivate(any(Calendar.class));
        verify(candidateRepository, times(1)).save(candidate);
        assertEquals(candidate, result);
    }

    @Test
    public void testDisableNonExistingCandidate() {
        // Arrange
        String email = "nonexistent@example.com";
        when(candidateRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        Candidate result = controller.disableCandidate(email);

        // Assert
        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);
        verify(candidateRepository, never()).save(any(Candidate.class));
        assertNull(result);
    }

    @Test
    public void testAuthorizationCheck() {
        // Arrange
        EmailAddress email = EmailAddress.valueOf("candidate@example.com");
        SystemUser systemUser = mock(SystemUser.class);
        Candidate candidate = new Candidate(systemUser, email, null, null);
        when(candidateRepository.findAll()).thenReturn(Arrays.asList(candidate));

        // Act
        controller.disableCandidate(email.toString());

        // Assert
        verify(authz, times(1)).ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);
    }
}
