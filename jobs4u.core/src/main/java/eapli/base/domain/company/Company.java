package eapli.base.domain.company;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.management.ConstructorParameters;

@Entity
@Getter
public class Company implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private CompanyName companyName;

    public Company(CompanyName companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    protected Company() {
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
