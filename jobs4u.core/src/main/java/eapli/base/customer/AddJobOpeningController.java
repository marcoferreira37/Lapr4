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
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN, BaseRoles.POWER_USER);
        JobOpening jo = service.create(description, address, mode, contract,
                epitaph, vacancies, companyId);
        return jo;
    }


    public boolean checkDescription(String description) {
        return description == null || description.trim().isEmpty() || description.matches("\\d+");
    }

    public boolean checkAddress(String address) {
        return address == null || address.trim().isEmpty() || address.matches("\\d+");
    }

    public boolean checkTittleOrFunction(String titleOrFunction) {
        return titleOrFunction == null || titleOrFunction.trim().isEmpty() || titleOrFunction.matches("\\d+");
    }

    public boolean checkVacanciesNumber(String vacanciesNumber) {
        return vacanciesNumber == null || vacanciesNumber.trim().isEmpty() || !vacanciesNumber.matches("\\d+") || Integer.parseInt(vacanciesNumber) < 0;

    }

    public boolean checkCompanyID(String companyIdStr) {
        return companyIdStr == null || companyIdStr.trim().isEmpty() || !companyIdStr.matches("\\d+") || Integer.parseInt(companyIdStr) < 0;

    }
}
