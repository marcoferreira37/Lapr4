package eapli.base.domain.jobs4uuserbuilders;

import eapli.base.domain.Jobs4UUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * The interface Ie course user builder.
 */
public interface Ijobs4UUserBuilder {

    /**
     * Add system user to the builder.
     *
     * @param systemUser the system user
     * @return the ie course user builder
     */
    Ijobs4UUserBuilder withSystemUser(SystemUser systemUser);


    /**
     * Build the ECourseUser.
     *
     * @return the eCourseUser
     */
    Jobs4UUser build();
}
