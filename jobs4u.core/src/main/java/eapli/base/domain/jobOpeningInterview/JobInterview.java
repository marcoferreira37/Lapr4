package eapli.base.domain.jobOpeningInterview;

import eapli.base.domain.candidate.Candidate;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "JobInterview")
@Transactional
public class JobInterview implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INTERVIEWID")
    private long id;
    @ManyToOne
    @JoinColumn(name = "CANDIDATEID")
    private Candidate candidate;


    private final String interviewResult;

    private final String interviewTime;
    private final String interviewLocation;
    private final String interviewType;

    public JobInterview(String interviewDate, String interviewTime, String interviewLocation, String interviewType) {
        this.interviewResult = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewLocation = interviewLocation;
        this.interviewType = interviewType;
    }



    public String getInterviewResult() {
        return interviewResult;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public String getInterviewLocation() {
        return interviewLocation;
    }

    public String getInterviewType() {
        return interviewType;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}
