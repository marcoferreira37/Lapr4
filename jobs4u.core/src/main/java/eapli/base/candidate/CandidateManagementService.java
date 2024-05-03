package eapli.base.candidate;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.TelephoneNumber;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class CandidateManagementService {
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidateRepository();

    @Transactional
    public Candidate registerNewCandidate(final SystemUser newUser, final EmailAddress emailAddress, final TelephoneNumber telephoneNumber) {
        SystemCandidateBuilder builder = new SystemCandidateBuilder();
        builder.withUser(newUser).withEmail(emailAddress).withTelephoneNumber(telephoneNumber);
        Candidate newCandidate = builder.build();

        return this.candidateRepository.save(newCandidate);
    }

    public Iterable<Candidate> allCandidate() {
        return candidateRepository.findAllCandidates();
    }

    public Optional<Candidate> userOfIdentity(final EmailAddress id) {
        return candidateRepository.ofIdentity(id);
    }


}

