package eapli.base.domain.JobOpeningApplication;

import eapli.base.domain.candidate.CandidateId;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;

@Entity
@Table (name = "Application")
public class JobOpeningApplication implements AggregateRoot<ApplicationId> {
    @Id
    @Column(name = "APPLICATIONID")
    private ApplicationId id;

    @Column(name = "JOBREFERENCE")
    @ManyToOne
    private JobReference jobReference;

    @Column(name = "CANDIDATEID")
    private CandidateId candidateId;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public ApplicationId identity() {
        return id;
    }
}
