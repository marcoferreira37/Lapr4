package eapli.base.domain.candidate;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Candidate implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "CANDIDATENAME")
    private String name;

    @OneToOne
    private SystemUser user;

    private TelephoneNumber telephoneNumber;
    protected Candidate() {
    }

    public Candidate(String name, SystemUser user) {
        this.id++;
        this.name = name;
        this.user = user;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", telephoneNumber=" + telephoneNumber +
                '}';
    }
}
