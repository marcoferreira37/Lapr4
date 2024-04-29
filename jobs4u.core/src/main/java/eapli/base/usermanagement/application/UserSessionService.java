package eapli.base.usermanagement.application;

import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class UserSessionService {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    private final Ijobs4UUserRepository ieCourseUserRepository;

    /**
     * Instantiates a new eCourse user service.
     *
     * @param ieCourseUserRepository the eCourse user repository
     */
    public UserSessionService(Ijobs4UUserRepository ieCourseUserRepository) {
        if (ieCourseUserRepository == null) {
            throw new IllegalArgumentException("The iCourseRepository cannot be null.");
        }

        this.ieCourseUserRepository = ieCourseUserRepository;
    }

    /**
     * Find eCourse user that is logged in.
     *
     * @return the eCourse user
     */
    public Optional<Jobs4UUser> getLoggedUser() {
        // verify if the session exists
        if (authorizationService.session().isEmpty())
            throw new IllegalStateException("No session found. Please login first.");

        return ieCourseUserRepository.findByEmail(authorizationService.session().get().authenticatedUser()
                .email().toString());
    }
}
