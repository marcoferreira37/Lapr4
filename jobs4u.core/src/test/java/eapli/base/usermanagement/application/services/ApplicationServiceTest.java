package eapli.base.usermanagement.application.services;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.repositories.JobOpeningProcessRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicationServiceTest {

    private ApplicationService applicationService;
    private JobOpeningApplication application;

    @BeforeEach
    public void setUp() {
        applicationService = new ApplicationService();

        // Criando uma instância real de JobOpeningApplication
        JobReference jobReference = new JobReference(12L, "Company");
        JobOpening jobOpening = new JobOpening(jobReference);
        Candidate candidate = new Candidate();
        application = new JobOpeningApplication(jobOpening, candidate);
    }

    @Test
    public void testRankApplication() {
        applicationService.rankApplication(application, 5);
        assertEquals(5, application.showRank());
    }
}