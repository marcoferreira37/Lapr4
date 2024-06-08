package eapli.base.domain.jobApplication;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "JobOpeningApplication")
@Transactional
@Getter
@Setter
public class JobOpeningApplication implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPLICATIONID")
    private long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "JOBREFERENCE_COMPANYINDEX", referencedColumnName = "companyIndex"),
            @JoinColumn(name = "JOBREFERENCE_ID", referencedColumnName = "iD"),
            @JoinColumn(name = "JOBREFERENCE_FULLREFERENCE", referencedColumnName = "fullReference"),
    })
    public JobOpening jobOpening;

    @ManyToOne
    @JoinColumn(name = "CANDIDATEID")
    private Candidate candidate;

    @Column(name = "ATTACHEDEMAIL")
    private String attachedEmail;

    @Column(name = "APPLICATIONDATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar applicationData;

    @Column(name = "APPLICATIONSTATUS")
    private String applicationStatus;

    @Column(name = "JOBREFERENCE", insertable = false, updatable = false)
    private String jobReference;

    @Column(name = "CANDIDATE_REQUIREMENTS")
    private String candidateRequirements;

    @Column(name = "RANK")
    private int rank;
    private Status status;


    public JobOpeningApplication() {
        // Construtor vazio necessário para JPA
    }


    public JobOpeningApplication(JobOpening j, Candidate c) {
        this.jobOpening = j;
        this.candidate = c;
        this.candidateRequirements = "N/A";
        this.rank = -1;
        this.status = Status.UNREVIEWED;
    }


    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        JobOpeningApplication that = (JobOpeningApplication) other;
        return id == ((JobOpeningApplication) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    public JobOpening jobOpening() {
        return jobOpening;
    }

    public Candidate candidate() {
        return candidate;
    }


    @Override
    public String toString() {
        return "JobOpeningApplication " +
               "\n Id =" + id +
               "\n Candidate Email:" + candidate.identity() +
               "\n Job Reference :" + jobOpening.getJobReference().fullReference() +
                "\n Status: " + status;
    }

    /**
     * Rank an application for a job opening
     *
     * @param rank the rank to assign to the application
     */
    public void rankApplication(int rank) {
        this.rank = rank;
    }

    /**
     * Show the rank of the application as a string
     *
     * @return the rank of the application
     */
    public String showRank() {
        return String.valueOf(rank);
    }



    /**
     * Show the rank of the application as an integer
     *
     * @return the rank of the application
     */
    public int showRanking() {
        return rank;
    }

    public List<JobInterview> getInterviews() {
        return null;
    }

    public String candidateRequirements(){
        return candidateRequirements;
    }

    public void setCandidateRequirements(String canReq){
        this.candidateRequirements = canReq;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }
    public Status status() {
        return status;
    }
}

