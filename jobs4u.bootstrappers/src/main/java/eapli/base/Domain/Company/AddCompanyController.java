package eapli.base.Domain.Company;

import eapli.base.domain.company.Company;
import eapli.base.domain.company.CompanyBuilder;
import eapli.base.domain.company.CompanyName;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CompanyRepository;

public class AddCompanyController {
    private CompanyRepository repository = PersistenceContext.repositories().companyRepository();

    public Company addCompany(String comapnyName) {
        CompanyBuilder builder = new CompanyBuilder();
        builder.withCompanyName(new CompanyName(comapnyName));
        Company c = builder.build();
        return repository.save(c);
    }
}
