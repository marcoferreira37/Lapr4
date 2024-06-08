package eapli.base.domain.jobOpeningProcess;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.Instant;
import java.util.Date;


@Entity
@Table(name = "JOB_OPENING_PROCESS")
public class JobOpeningProcess implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
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


    public JobOpeningProcess(JobOpening jobOpening, Phase phase) {
        this.jobOpening = jobOpening;
        this.currentPhase = PhaseType.DRAFT;
        this.phaseDate = phase;
        status = Status.OPENED;
    }

    public JobOpeningProcess(JobOpening jobOpening, PhaseType currentPhase) {
        this.jobOpening = jobOpening;
        this.currentPhase = currentPhase;

    }

    protected JobOpeningProcess() {
    }

    public PhaseType currentPhase() {
        return currentPhase;
    }

    public void advanceToNextPhase(boolean interviewPhase) {
        currentPhase = currentPhase.nextPhase(interviewPhase);
        status = Status.OPENED;
    }

    public void goBackToPreviousPhase(boolean interviewPhase) {
        if (currentPhase == PhaseType.DRAFT) {
            throw new RuntimeException("Can't go back to previous phase, already in the first phase.");
        }
        if (status == Status.ACTIVE) {
            throw new RuntimeException("Can't go back to previous phase, process is already active.");
        }
        currentPhase = currentPhase.previousPhase(interviewPhase);
        skipPhaseDate(currentPhase);
        status = Status.OPENED;
    }

    private void skipPhaseDate(PhaseType currentPhase) {
        switch (currentPhase) {
            case APPLICATION:
                phaseDate.setAnalysisDate((Date.from(Instant.now())));
                break;
            case SCREENING:
                phaseDate.setScreeningDate((Date.from(Instant.now())));
                break;
            case INTERVIEWS:
                phaseDate.setInterviewDate((Date.from(Instant.now())));
                break;
            case ANALYSIS:
                phaseDate.setAnalysisDate((Date.from(Instant.now())));
                break;
            case RESULT:
                phaseDate.setResultsDate((Date.from(Instant.now())));
                break;
        }
    }

    public void changeCurrentPhase(PhaseType phaseType) {
        currentPhase = phaseType;
    }

    public void skipToNextPhase() {
        switch (currentPhase) {
            case DRAFT:
                currentPhase = PhaseType.APPLICATION;
                break;
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

    public void updatePhaseDate(Phase phase) {
        this.phaseDate = phase;
    }

    public Status status() {
        return status;
    }

    public Phase phaseDate() {
        return phaseDate;
    }

    @Override
    public String toString() {
        String result = "JobOpeningProcess" +
                        "\n id: " + id +
                        "\n Job Reference: " + jobOpening.getJobReference().fullReference() +
                        "\n Current Phase: " + currentPhase +
                        "\n Status: " + status;
        if (checkIfDatesWerentSetup()) {
            result += "\n Phase Dates:  Not setup yet!";
        } else {
            result += "\n Phase Dates: " + phaseDate;
        }
        return result;
    }

    public boolean checkIfDatesWerentSetup() {
        return phaseDate.getApplicationDate().equals(phaseDate.getAnalysisDate());
    }

    public boolean isInAnalysis() {
        return currentPhase == PhaseType.ANALYSIS;
    }

    public boolean isInResult() {
        return currentPhase == PhaseType.RESULT;
    }

    public JobOpening obtainAssociatedJobOpening(){
        return jobOpening;
    }
}
