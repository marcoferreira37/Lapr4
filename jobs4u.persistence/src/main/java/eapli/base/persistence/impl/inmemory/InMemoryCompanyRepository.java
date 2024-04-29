package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.company.Company;
import eapli.base.usermanagement.application.CompanyRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCompanyRepository extends InMemoryDomainRepository<Company, Long> implements CompanyRepository {
}
