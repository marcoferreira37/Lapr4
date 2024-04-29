package eapli.base.domain.company;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Company implements AggregateRoot<Long> {
    @Id
    private Long id;
    private CompanyName companyName;


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
