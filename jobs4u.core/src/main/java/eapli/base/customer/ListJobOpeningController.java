package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.time.LocalDateTime;
import java.util.List;

public class ListJobOpeningController {

    private JobOpeningService service = new JobOpeningService();
    private AuthorizationService autzService = AuthzRegistry.authorizationService();

    public List<JobOpening> listJobOpenings(LocalDateTime startDate, LocalDateTime endDate, String nameOrReference) {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        validateDates(startDate, endDate);
        return service.listJobOpenings(startDate, endDate, nameOrReference);

    }

    //controller valida a informação ( datas )


    private void validateDates(LocalDateTime startDate, LocalDateTime endDate) {
        checkNotNull(startDate, "Start date cannot be null.");
        checkNotNull(endDate, "End date cannot be null.");
        checkEndDateAfterStartDate(startDate, endDate);

    }

    private void checkNotNull(LocalDateTime date, String errorMessage) {
        if (date == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void checkEndDateAfterStartDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
    }
}
