package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.TelephoneNumber;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;


import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class AddCandidateController {

    private final UserManagementService userSvc= AuthzRegistry.userService();

    private final CandidateManagementService candidateSvc = new CandidateManagementService();

    public Candidate addCandidate(final String firstname, final String lastname, final String email, final Calendar createdOn, final long telephoneNumber){
        Set<Role> role = new HashSet<>();
        role.add(BaseRoles.CANDIDATE);
        final SystemUser newUser = createSystemUser(firstname, lastname, email, role, createdOn);

        return candidateSvc.registerNewCandidate(newUser, EmailAddress.valueOf(email), new TelephoneNumber(telephoneNumber), null);
    }
    private SystemUser createSystemUser(final String firstName, final String lastName, final String email, final Set<Role> roles, final Calendar createdOn) {
        Preconditions.nonNull(firstName);
        Preconditions.nonNull(lastName);
        Preconditions.nonNull(email);


        roles.add(BaseRoles.CANDIDATE);
        String password = BasePasswordPolicy.generatePassword(firstName);

        return userSvc.registerNewUser(email, password, firstName, lastName, email, roles, createdOn);
    }
}
