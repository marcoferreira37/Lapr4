package eapli.base.clientusermanagement.domain.jobOpening;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;

@Entity
@Table(name = "JOB_OPENING")

public class JobOpening implements AggregateRoot<JobReference> {

    @EmbeddedId
    @Column(name = "JOB_REFERENCE")
    private JobReference jobReference;

    @Column (name = "DESCRIPTION")
    private Description description;

    @Column (name = "ADDRESS")
    private Address address;

    @Column (name = "MODE")
    private Mode mode;

    @Column (name = "TITLEORFUNCTION")
    private TitleOrFunction titleOrFunction;

    @Column (name = "VACANCIESNUMBER")
    private VacanciesNumber vacanciesNumber;

    protected JobOpening() {

    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobReference identity() {
        return null;
    }
}
