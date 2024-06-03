package eapli.base.domain.jobOpeningInterview;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.framework.validations.Preconditions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;


class JobInterviewTest {

    private  JobInterview jobInterview;

    @Test
    public void validateInterviewTimeNotNullTest() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DAY_OF_MONTH, 1); // Definindo a data para o futuro
        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(); // Objeto válido

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobInterview(null, futureDate, jobOpeningApplication);
        });

        assertEquals("Interview Time must not be null", exception.getMessage());
    }


    @Test
    public void validateInterviewDateTest() {
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DAY_OF_MONTH, -1); // Definindo a data para o passado
        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(); // Objeto válido

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobInterview("10:00 AM", pastDate, jobOpeningApplication);
        });

        assertEquals("Interview Date must not be in the past", exception.getMessage());
    }

    @Test
    public void validateJobOpeningApplicationTest() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DAY_OF_MONTH, 1); // Definindo a data para o futuro

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobInterview("10:00 AM", futureDate, null);
        });

        assertEquals("Job Opening Application must not be null", exception.getMessage());
    }

    @Test
    public void validateJobOpeningApplication_NullJobOpeningApplication_ThrowsException() {
        JobInterview jobInterview = new JobInterview();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jobInterview.validateJobOpeningApplication(null);
        });
        assertEquals("Job Opening Application must not be null", exception.getMessage());
    }

    @Test
    public void validateInterviewDate_PastDate_ThrowsException() {
        JobInterview jobInterview = new JobInterview();
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DAY_OF_MONTH, -1); // Define a data para o passado
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jobInterview.validateInterviewDate(pastDate);
        });
        assertEquals("Interview Date must not be in the past", exception.getMessage());
    }

    @Test
    public void validateInterviewTimeNotNull_NullInterviewTime_ThrowsException() {
        JobInterview jobInterview = new JobInterview();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jobInterview.validateInterviewTimeNotNull(null);
        });
        assertEquals("Interview Time must not be null", exception.getMessage());
    }

    @Test
    public void validateInterviewTimeTest() {
        JobInterview jobInterview = new JobInterview();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jobInterview.validateInterviewTime("");
        });
        assertEquals("Interview Time must not be null", exception.getMessage());
    }

}