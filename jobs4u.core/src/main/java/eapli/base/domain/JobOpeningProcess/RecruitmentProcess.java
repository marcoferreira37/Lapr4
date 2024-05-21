package eapli.base.domain.JobOpeningProcess;

import eapli.base.domain.jobOpening.Phase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class RecruitmentProcess  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long processId;
    private PhaseType currentPhase;
    private Phase phase;
    private boolean status;


    public RecruitmentProcess(Phase phase) {
        this.currentPhase = PhaseType.APPLICATION;
        this.phase = phase;
        this.status = true;
    }

    protected RecruitmentProcess() {
    }

    public PhaseType currentPhase() {
        return currentPhase;
    }

    public void skipToNextPhase() {
        switch (currentPhase) {
            case APPLICATION:
                currentPhase = PhaseType.SCREENING;
                break;
            case SCREENING:
                currentPhase = PhaseType.INTERVIEWS;
                break;
            case INTERVIEWS:
                currentPhase = PhaseType.ANALYSIS;
                break;
            case ANALYSIS:
                currentPhase = PhaseType.RESULT;
                break;
            default:
                status = false;
                break;
        }
    }

    public void skipToPhase(PhaseType phaseType) {
        currentPhase = phaseType;
    }

    public void deactivateProcess() {
        status = false;
    }
    public void activateProcess() {
        status = true;
    }
}
