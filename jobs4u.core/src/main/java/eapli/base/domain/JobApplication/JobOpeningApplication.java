package eapli.base.domain.JobApplication;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Table (name = "JobOpeningApplication")
@Transactional
public class JobOpeningApplication implements AggregateRoot<Long>  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPLICATIONID")
    private long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "JOBREFERENCE_COMPANYINDEX", referencedColumnName = "companyIndex"),
            @JoinColumn(name = "JOBREFERENCE_ID", referencedColumnName = "iD"),
            @JoinColumn(name = "JOBREFERENCE_FULLREFERENCE", referencedColumnName = "fullReference")
    })
    public JobOpening jobOpening;

    @ManyToOne
    @JoinColumn(name = "CANDIDATEID")
    private Candidate candidate;

    public JobOpeningApplication(JobOpening j, Candidate c){
        this.id++;
        this.jobOpening = j;
        this.candidate = c;
    }

    public JobOpeningApplication() {

    }

    @Override
    public String toString() {
        return "JobOpeningApplication{" +
                "id=" + id +
                ", jobOpening=" + jobOpening +
                ", candidate=" + candidate +
                '}';
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