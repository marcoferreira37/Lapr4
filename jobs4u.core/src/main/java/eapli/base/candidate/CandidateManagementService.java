package eapli.base.candidate;

import eapli.base.domain.candidate.Candidate;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class CandidateManagementService {
    private final CandidateRepository candidateRepository ;
    private final PasswordEncoder encoder  ;
    private final PasswordPolicy policy ;


    @Autowired
    public CandidateManagementService(CandidateRepository customerRepo, final PasswordPolicy policy, PasswordEncoder encoder) {
        this.candidateRepository = customerRepo;
        this.encoder = encoder;
        this.policy = policy;
    }


    @Transactional
    public Candidate registerNewCandidate(final SystemUser newUser, final EmailAddress emailAddress) {
        SystemCandidateBuilder builder = new SystemCandidateBuilder();
        builder.withUser(newUser).withEmail(emailAddress);
        Candidate newCandidate = builder.build();

        return candidateRepository.save(newCandidate);
    }

    public Iterable<Candidate> allCandidate() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> userOfIdentity(final EmailAddress id) {
        return candidateRepository.ofIdentity(id);
    }


}

