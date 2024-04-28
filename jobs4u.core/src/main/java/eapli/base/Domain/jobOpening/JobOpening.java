package eapli.base.Domain.jobOpening;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;

@Entity
@Table(name= "JobOpening")
public class JobOpening implements AggregateRoot<JobReference> {

    @EmbeddedId
    private JobReference jobReference;
    private JobTitle jobTitle;
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
    @Enumerated(EnumType.STRING)
    private Mode mode;
    private Vancancies numberOfVacancies;
    private JobDescription jobDescription;



    public JobTitle JobTitle() {
        return jobTitle;
    }

    public ContractType ContractType() {
        return contractType;
    }

    public Mode Mode() {
        return mode;
    }


    public Vancancies NumberOfVacancies() {
        return numberOfVacancies;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }
    @Override
    public JobReference identity() {
        return this.jobReference;
    }
}
