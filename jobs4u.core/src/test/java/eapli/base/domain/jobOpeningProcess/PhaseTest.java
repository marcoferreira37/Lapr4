package eapli.base.domain.jobOpeningProcess;

import eapli.base.domain.jobOpeningProcess.Phase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class PhaseTest {

    private Phase phase;
    private Date applicationDate;
    private Date screeningDate;
    private Date interviewDate;
    private Date analysisDate;
    private Date resultsDate;

    @BeforeEach
    void setUp() {
        Calendar calendar = Calendar.getInstance();
        applicationDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        screeningDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        interviewDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        analysisDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        resultsDate = calendar.getTime();
        phase = Phase.from(applicationDate, screeningDate, interviewDate, analysisDate, resultsDate);
    }

    @DisplayName("Phase creation with valid dates")
    @Test
    void shouldCreatePhaseWithValidDates() {
        assertNotNull(phase);
    }

    @DisplayName("Phase creation with invalid dates")
    @Test
    void shouldThrowExceptionWhenCreatePhaseWithInvalidDates() {
        assertThrows(IllegalArgumentException.class, () -> Phase.from(resultsDate, analysisDate, interviewDate, screeningDate, applicationDate));
    }

    @DisplayName("Phase equality")
    @Test
    void shouldReturnTrueWhenPhasesAreEqual() {
        Phase anotherPhase = Phase.from(applicationDate, screeningDate, interviewDate, analysisDate, resultsDate);
        assertEquals(phase, anotherPhase);
    }

    @DisplayName("Phase inequality")
    @Test
    void shouldReturnFalseWhenPhasesAreNotEqual() {
            //implement this test
        Calendar calendar = Calendar.getInstance();
        Date applicationDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date screeningDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date interviewDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date analysisDate = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date resultsDate = calendar.getTime();
        Phase anotherPhase = Phase.from(applicationDate, screeningDate, interviewDate, analysisDate, resultsDate);
        assertNotEquals(phase, anotherPhase);
    }
}