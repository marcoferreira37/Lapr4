package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.repositories.CandidateRepository;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Map;

public class JpaJobProcessRepository extends JpaAutoTxRepository<JobOpeningProcess, Long, Long> implements JobOpeningProcessRepository {

   public JpaJobProcessRepository (TransactionalContext autoTx) {
        super(autoTx,"Id");
    }
    public JpaJobProcessRepository (final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "Id");
    }

    @Override
    public JobOpeningProcess findById(long id) {
        final Map<String, Object> params = Map.of("id", id);
        return (matchOne("e.id=:id", params).orElseThrow(IllegalArgumentException::new));
    }
}
