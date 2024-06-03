package eapli.base.domain.jobOpeningProcess;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JobOpeningProcessTest {

    private JobOpeningProcess jobOpeningProcess;
    private JobOpening jobOpening;

    @BeforeEach
    void setUp() {
        jobOpening = new JobOpening(new JobReference());
        jobOpeningProcess = new JobOpeningProcess(jobOpening, new Phase(Date.from(new Date().toInstant()), Date.from(new Date().toInstant()), Date.from(new Date().toInstant()), Date.from(new Date().toInstant()), Date.from(new Date().toInstant())));
    }

    @DisplayName("Advance to next phase")
    @Test
    void shouldAdvanceToNextPhase() {
        jobOpeningProcess.advanceToNextPhase(false);
        assertEquals(PhaseType.APPLICATION, jobOpeningProcess.currentPhase());
    }

    @DisplayName("Go back to previous phase from application phase")
    @Test
    void shouldThrowExceptionWhenGoBackToPreviousPhaseFromApplicationPhase() {
        assertThrows(RuntimeException.class, () -> jobOpeningProcess.goBackToPreviousPhase(false));
    }

    @DisplayName("Change current phase")
    @Test
    void shouldChangeCurrentPhase() {
        jobOpeningProcess.changeCurrentPhase(PhaseType.RESULT);
        assertEquals(PhaseType.RESULT, jobOpeningProcess.currentPhase());
    }

    @DisplayName("Skip to next phase")
    @Test
    void shouldSkipToNextPhase() {
        jobOpeningProcess.skipToNextPhase();
        assertEquals(PhaseType.APPLICATION, jobOpeningProcess.currentPhase());
    }

    @DisplayName("Deactivate process")
    @Test
    void shouldDeactivateProcess() {
        jobOpeningProcess.deactivateProcess();
        assertEquals(Status.CLOSED, jobOpeningProcess.status());
    }

    @DisplayName("Activate process")
    @Test
    void shouldActivateProcess() {
        jobOpeningProcess.activateProcess();
        assertEquals(Status.ACTIVE, jobOpeningProcess.status());
    }
}
