package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.repositories.CandidateRepository;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;
import java.util.Map;

public class JpaJobProcessRepository extends JpaAutoTxRepository<JobOpeningProcess, Long, Long> implements JobOpeningProcessRepository {

    public JpaJobProcessRepository(TransactionalContext autoTx) {
        super(autoTx, "Id");
    }

    public JpaJobProcessRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "Id");
    }

    @Override
    public JobOpeningProcess findById(long id) {
        final Map<String, Object> params = Map.of("id", id);
        return (matchOne("e.id=:id", params).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public JobOpeningProcess findJobProcessByJobOpening(JobOpening job) {
        final Map<String, Object> params = Map.of("jobOpening", job);
        List<JobOpeningProcess> result = match("e.jobOpening=:jobOpening", params);
        return result.get(result.size()-1);
    }

    @Override
    public List<JobOpening> findAllInAnalysis() {
        return (match("e.currentPhase='ANALYSIS'")).stream().map(JobOpeningProcess::jobOpening).toList();
    }

    @Override
    public List<JobOpening> findAllInResult() {
        return (match("e.currentPhase='RESULT'")).stream().map(JobOpeningProcess::jobOpening).toList();
    }
}
