package eapli.base.domain.jobOpeningProcess;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.base.domain.jobOpening.Phase;
import jakarta.persistence.*;


@Entity
public class RecruitmentProcess  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long processId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "JOBREFERENCE_COMPANYINDEX", referencedColumnName = "companyIndex"),
            @JoinColumn(name = "JOBREFERENCE_ID", referencedColumnName = "iD"),
            @JoinColumn(name = "JOBREFERENCE_FULLREFERENCE", referencedColumnName = "fullReference"),
    })
    public JobOpening jobOpening;
    private PhaseType currentPhase;
    private Phase phaseDate;
    private boolean status;


    public RecruitmentProcess(Phase phase) {
        this.currentPhase = PhaseType.APPLICATION;
        this.phaseDate = phase;
        this.status = true;
    }

    protected RecruitmentProcess() {
    }

    public PhaseType currentPhase() {
        return currentPhase;
    }

    public void advanceToNextPhase(boolean interviewPhase) {
        currentPhase = currentPhase.nextPhase(interviewPhase);
    }

    public void goBackToPreviousPhase(boolean interviewPhase) {
        currentPhase = currentPhase.previousPhase(interviewPhase);
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
