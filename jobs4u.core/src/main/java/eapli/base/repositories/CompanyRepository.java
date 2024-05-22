package eapli.base.repositories;

import eapli.base.domain.company.Company;
import eapli.framework.domain.repositories.DomainRepository;

public interface CompanyRepository extends DomainRepository<Long,Company> {
    Company findByID(Long id);
}
