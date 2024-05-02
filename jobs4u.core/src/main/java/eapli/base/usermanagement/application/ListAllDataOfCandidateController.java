package eapli.base.usermanagement.application;

import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.lang.ref.PhantomReference;
import java.util.List;

public class ListAllDataOfCandidateController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    public ListAllDataOfCandidateController() {
    }

}

