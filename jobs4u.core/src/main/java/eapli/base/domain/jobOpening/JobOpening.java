package eapli.base.domain.jobOpening;

import eapli.base.domain.company.Company;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    @Enumerated(EnumType.STRING)
    private Mode mode;

    @Column (name = "CONTRACTTYPE")
    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @Column (name = "TITLEORFUNCTION")
    private TitleOrFunction titleOrFunction;

    @Column (name = "VACANCIESNUMBER")
    private VacanciesNumber vacanciesNumber;

    @Column (name = "COMPANY")
    @ManyToOne
    private Company company;

    protected JobOpening() {}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobReference identity() {
        return null;
    }

}
