package eapli.base.domain.company;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Company implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private CompanyName companyName;

    public Company(CompanyName companyName) {
        this.companyName = companyName;
        this.id++;
    }

    protected Company() {
    }

    public String companyIndex(){
        return companyName.companyName().substring(0,3).toUpperCase();
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
