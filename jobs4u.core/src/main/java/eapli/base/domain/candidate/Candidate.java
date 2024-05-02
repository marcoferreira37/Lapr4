package eapli.base.domain.candidate;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.*;

@Entity
public class Candidate implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CANDIDATENAME")
    private CandidateName name;

    @OneToOne
    private SystemUser user;

    private TelephoneNumber telephoneNumber;
    protected Candidate() {
    }

    public Candidate(Long id, CandidateName name, SystemUser user) {
        this.id = id;
        this.name = name;
        this.user = user;
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
