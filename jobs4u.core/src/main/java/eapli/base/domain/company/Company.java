package eapli.base.domain.company;

import eapli.base.customer.Customer;
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

    @JoinColumn
    @OneToOne
    private Customer customer;

    public Company(CompanyName companyName, Customer customer) {
        this.companyName = companyName;
        this.customer = customer;
    }

    public Company(Customer costumer) {
        this.customer = costumer;
    }

    public Company() {

    }

    public Customer findCustomer() {
        return customer;

    }

    public String companyIndex() {
        return companyName.companyName().substring(0, 3).toUpperCase();
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
        return "================= Company =================" +
               "\nCompany Id: " + id +
               "\nCompany Name:" + companyName.companyName() +
               "\n============================================";
    }

    public void modCustomer(Customer customer) {
        this.customer = customer;

    }
}
