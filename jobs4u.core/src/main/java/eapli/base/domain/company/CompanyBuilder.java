package eapli.base.domain.company;

public class CompanyBuilder {
    private CompanyName companyName;

    public CompanyBuilder withCompanyName(CompanyName companyName) {
        this.companyName = companyName;
        return this;
    }

    public Company build() {
        return new Company(companyName);
    }
}
