package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.repositories.JobOpeningRepository;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class AddJobApplicationControllerTest {

    @InjectMocks
    private AddJobApplicationController controller;

    @Mock
    private JobOpeningApplicationRepository jobApplicationRepo;

    @Mock
    private JobOpeningRepository jobOpeningRepo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddJobOpeningApplication() {
        JobOpening jobOpening = mock(JobOpening.class);
        Candidate candidate = mock(Candidate.class);
        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(jobOpening, candidate);

        when(jobApplicationRepo.save(any(JobOpeningApplication.class))).thenReturn(jobOpeningApplication);

        JobOpeningApplication result = controller.addJobOpeningApplication(jobOpening, candidate);
        assertNotNull(result);
        assertEquals(jobOpening, result.jobOpening());
        assertEquals(candidate, result.candidate());

        verify(jobApplicationRepo).save(any(JobOpeningApplication.class));
    }

    @Test
    void testListJobOpenings() {
        List<JobOpening> jobOpenings = Arrays.asList(mock(JobOpening.class), mock(JobOpening.class));

        when(jobOpeningRepo.findAll()).thenReturn(jobOpenings);

        List<JobOpening> result = controller.listJobOpenings();
        assertNotNull(result);
        assertEquals(jobOpenings.size(), result.size());

        verify(jobOpeningRepo).findAll();
    }

    @Test
    void testReadFile() throws IOException {
        String fileName = "testFile.txt";

        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("jobReference", "test@example.com", "John Doe", "123456789");

        JobOpening jobOpening = mock(JobOpening.class);
        when(jobOpeningRepo.findJobOpeningByFullReference("jobReference")).thenReturn(jobOpening);

        Candidate candidate = mock(Candidate.class);
        AddCandidateController addCandidateController = mock(AddCandidateController.class);
        when(addCandidateController.addCandidate("John", "Doe", "test@example.com", any(Calendar.class), 123456789L)).thenReturn(candidate);

        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(jobOpening, candidate);
        when(jobApplicationRepo.save(any(JobOpeningApplication.class))).thenReturn(jobOpeningApplication);

        try (MockedStatic<BufferedReader> mockedReader = mockStatic(BufferedReader.class)) {
            mockedReader.when(() -> new BufferedReader(new FileReader(fileName))).thenReturn(reader);

            JobOpeningApplication result = controller.readFile(fileName);
            assertNotNull(result);
            assertEquals(jobOpening, result.jobOpening());
            assertEquals(candidate, result.candidate());

            verify(reader, times(4)).readLine();
            verify(jobOpeningRepo).findJobOpeningByFullReference("jobReference");
            verify(addCandidateController).addCandidate("John", "Doe", "test@example.com", any(Calendar.class), 123456789L);
            verify(jobApplicationRepo).save(any(JobOpeningApplication.class));
        }
    }
}
