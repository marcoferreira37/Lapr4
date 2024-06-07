package eapli.base.protocol;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;


@Entity
@Table(name = "NOTIFICATIONS")
@Transactional
public class Notifications implements AggregateRoot<Long> {


    @Column(name = "USERNAME")
    String userName;

    @Column(name = "CONTENT")
    String content;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INTERVIEWID")
    private long id;

    public Notifications(String userName, String content) {
        this.userName = userName;
        this.content = content;
    }


    public Notifications() {


    }

    @Override
    public boolean sameAs(Object other) {
        return other instanceof JobOpening && ((JobOpening) other).identity().equals(identity());

    }

    @Override
    public Long identity() {
        return id;
    }
}
