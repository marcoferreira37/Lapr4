package eapli.base.domain.jobOpeningProcess;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "JOB_OPENING_PROCESS")
public class JobOpeningProcess implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumns({
            @JoinColumn(name = "JOBREFERENCE_COMPANYINDEX", referencedColumnName = "companyIndex"),
            @JoinColumn(name = "JOBREFERENCE_ID", referencedColumnName = "iD"),
            @JoinColumn(name = "JOBREFERENCE_FULLREFERENCE", referencedColumnName = "fullReference"),
    })
    public JobOpening jobOpening;
    @Enumerated(EnumType.STRING)
    private PhaseType currentPhase;

    private Phase phaseDate;
    @Enumerated(EnumType.STRING)
    private Status status;


    public JobOpeningProcess(JobOpening jobOpening,Phase phase) {
        this.currentPhase = PhaseType.DRAFT;
        this.phaseDate = phase;
        status = Status.OPENED;
    }

    protected JobOpeningProcess() {
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
    public void changeCurrentPhase(PhaseType phaseType) {
        currentPhase = phaseType;
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
                status = Status.CLOSED;
                break;
        }
    }

    public void skipToPhase(PhaseType phaseType) {
        currentPhase = phaseType;
    }

    public void deactivateProcess() {
        status = Status.CLOSED;
    }
    public void activateProcess() {
        status = Status.ACTIVE;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }

    public JobOpening jobOpening() {
        return jobOpening;
    }
}
