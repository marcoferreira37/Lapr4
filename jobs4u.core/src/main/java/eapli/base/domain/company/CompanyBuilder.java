package eapli.base.domain.company;

import eapli.base.customer.Customer;

public class CompanyBuilder {
    private CompanyName companyName;

    private Customer customer;

    public CompanyBuilder withCompanyName(CompanyName companyName) {
        this.companyName = companyName;
        return this;
    }

    public CompanyBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }


    public Company build() {
        return new Company(companyName, customer);
    }
}
