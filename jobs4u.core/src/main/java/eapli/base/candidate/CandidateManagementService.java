package eapli.base.candidate;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.TelephoneNumber;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class CandidateManagementService {
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidateRepository();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Transactional
    public Candidate registerNewCandidate(final SystemUser newUser, final EmailAddress emailAddress, final TelephoneNumber telephoneNumber, final String curriculum) {
        SystemCandidateBuilder builder = new SystemCandidateBuilder();
        builder.withUser(newUser).withEmail(emailAddress).withTelephoneNumber(telephoneNumber).withCurriculum(curriculum);
        Candidate newCandidate = builder.build();

        return this.candidateRepository.save(newCandidate);
    }

    public Iterable<Candidate> allCandidate() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.OPERATOR, BaseRoles.CUSTOMER_MANAGER);
        return candidateRepository.findAllCandidates();
    }

    public Optional<Candidate> userOfIdentity(final EmailAddress id) {
        return candidateRepository.ofIdentity(id);
    }


    public Iterable<Candidate> getCandidate(JobOpeningApplication jobOpeningApplication) {
        return candidateRepository.getCandidate(jobOpeningApplication);
    }

    public Iterable<Candidate> candidatesOfJobOpening(JobOpening jobOpening) {
        return candidateRepository.findAllCandidates();
    }

    public void enableCandidate(String email) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);
        for (Candidate candidate : candidateRepository.findAll()){
            if (candidate.emailAddress().toString().equals(email)) {
                candidate.user().activate();
                candidateRepository.save(candidate);
                return;
            }
        }
        throw new IllegalArgumentException("Candidate not found.");
    }

    @Transactional
    public Candidate disableCandidate(String email) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);
        for (Candidate user : candidateRepository.findAll()){
            if (user.emailAddress().toString().equals(email)) {
                user.user().deactivate(Calendar.getInstance());
                return candidateRepository.save(user);
            }
        }
        return null;
    }

}

