package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.domain.company.Company;
import eapli.base.usermanagement.application.CompanyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Map;
import java.util.Optional;

class JpaCompanyRepository extends JpaAutoTxRepository<Company, Long, Long> implements CompanyRepository{

    public JpaCompanyRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }


    public JpaCompanyRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }
    @Override
    public Company findByID(Long id) {
        final Map<String, Object> params = Map.of("id", id);
        return (matchOne("e.id=:id", params).orElseThrow(IllegalArgumentException::new));
    }
}
