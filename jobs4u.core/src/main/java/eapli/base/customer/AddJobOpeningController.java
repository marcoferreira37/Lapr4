package eapli.base.customer;

import eapli.base.domain.jobOpening.ContractType;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.Mode;
import eapli.base.usermanagement.application.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class AddJobOpeningController {
    /**
     * The service to be used to add a job opening
     */
    private JobOpeningService service = new JobOpeningService();
    /**
     * The service to be used to check if the user has permission to add a job opening
     */
    private AuthorizationService autzService = AuthzRegistry.authorizationService();

    /**
     * Method to add a job opening
     * @param description description of the job opening
     * @param address address of the job opening
     * @param mode mode of the job opening
     * @param contract contract of the job opening
     * @param epitaph epitaph of the job opening
     * @param vacancies number of vacancies of the job opening
     * @param companyId id of the company that is offering the job opening
     * @return the job opening that was added
     */
    public JobOpening addJobopening(String description, String address, Mode mode, ContractType contract,
                                    String epitaph, int vacancies, int companyId) {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN, BaseRoles.POWER_USER);
        JobOpening jo = service.create(description, address, mode, contract,
                epitaph, vacancies, companyId);
        return jo;
    }

    /**
     * Method to check if the description is valid
     * @param description description to be checked
     * @return true if the description is valid, false otherwise
     */
    public boolean checkDescription(String description) {
        return description == null || description.trim().isEmpty() || description.matches("\\d+");
    }

    /**
     * Method to check if the address is valid
     * @param address address to be checked
     * @return true if the address is valid, false otherwise
     */
    public boolean checkAddress(String address) {
        return address == null || address.trim().isEmpty() || address.matches("\\d+");
    }

    /**
     * Method to check if the epitaph is valid
     * @param titleOrFunction epitaph to be checked
     * @return true if the epitaph is valid, false otherwise
     */
    public boolean checkTittleOrFunction(String titleOrFunction) {
        return titleOrFunction == null || titleOrFunction.trim().isEmpty() || titleOrFunction.matches("\\d+");
    }

    /**
     * Method to check if the vacancies number is valid
     * @param vacanciesNumber vacancies number to be checked
     * @return true if the vacancies number is valid, false otherwise
     */
    public boolean checkVacanciesNumber(String vacanciesNumber) {
        return vacanciesNumber == null || vacanciesNumber.trim().isEmpty() || !vacanciesNumber.matches("\\d+") || Integer.parseInt(vacanciesNumber) < 0;

    }

    /**
     * Method to check if the company id is valid
     * @param companyIdStr company id to be checked
     * @return true if the company id is valid, false otherwise
     */
    public boolean checkCompanyID(String companyIdStr) {
        return companyIdStr == null || companyIdStr.trim().isEmpty() || !companyIdStr.matches("\\d+") || Integer.parseInt(companyIdStr) < 0;

    }
}
