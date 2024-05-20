package eapli.base.domain.company;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Company implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private CompanyName companyName;

    public Company(CompanyName companyName) {
        this.companyName = companyName;
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

    public String toString() {
        return    "================= Company =================" +
                "\nCompany Id: " + id +
                "\nCompany Name:" + companyName.companyName() +
                "\n============================================";
    }

}
