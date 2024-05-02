package eapli.base.customer;

import eapli.base.domain.jobOpening.ContractType;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.Mode;
import eapli.base.usermanagement.application.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class AddJobOpeningController {

    private JobOpeningService service = new JobOpeningService();
    private AuthorizationService autzService = AuthzRegistry.authorizationService();

    public JobOpening addJobopening(String description, String address, Mode mode, ContractType contract,
                                    String epitaph, int vacancies, int companyId) {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        JobOpening jo = service.create(description, address, mode, contract,
                epitaph, vacancies, companyId);
        return jo;
    }


}
