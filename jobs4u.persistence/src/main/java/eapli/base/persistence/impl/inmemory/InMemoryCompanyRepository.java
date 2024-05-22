package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.company.Company;
import eapli.base.repositories.CompanyRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCompanyRepository extends InMemoryDomainRepository<Company, Long> implements CompanyRepository {
    static {
        InMemoryInitializer.init(); // Assuming this is some initialization method
    }

    @Override
    public Company findByID(Long id) {
        return matchOne(e -> e.identity().equals(id)).orElseThrow(IllegalArgumentException::new);
    }


}
