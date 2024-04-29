package eapli.base.clientusermanagement.domain.jobs4uuserbuilders;

import eapli.base.clientusermanagement.domain.Jobs4UUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class LanguageEngineerBuilder implements Ijobs4UUserBuilder{

    private SystemUser systemUser;

    @Override
    public LanguageEngineerBuilder withSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    /**
     * Build the "Manager".
     *
     * @return the eCourseUser
     */
    @Override
    public Jobs4UUser build() {
        return new Jobs4UUser(this.systemUser);
    }

}
