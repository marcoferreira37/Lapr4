package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListJobOpeningController {

    private static final List<JobOpeningFilteringStrategy> FILTERING_STRATEGIES = new ArrayList<>() {{
        add(new CodeFilteringStrategy());
        add(new DescriptionFilteringStrategy());
        add(new DateFilteringStrategy());
        add(new NoFilteringStrategy());
    }};

    private JobOpeningService service = new JobOpeningService();
    private AuthorizationService autzService = AuthzRegistry.authorizationService();


    //controller valida a informação ( datas )

    public List<JobOpeningFilteringStrategy> filteringStrategies(){
        return FILTERING_STRATEGIES;
    }

    public JobOpeningFilteringStrategy filteringStrategy(int index) {
        if (index < 0 || index >= FILTERING_STRATEGIES.size()) {
            throw new IllegalArgumentException("Invalid index.");
        }
        return FILTERING_STRATEGIES.get(index);
    }

    public List<JobOpening> listFilteredJobOpenings(JobOpeningFilteringStrategy strategy, List<Criteria<?>> criteria) {
        return service.listFilteredJobOpenings(strategy, criteria);
    }

    private void validateDates(Date startDate, Date endDate) {
        checkNotNull(startDate, "Start date cannot be null.");
        checkNotNull(endDate, "End date cannot be null.");
        checkEndDateAfterStartDate(startDate, endDate);
    }

    private void checkNotNull(Date date, String errorMessage) {
        if (date == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void checkEndDateAfterStartDate(Date startDate, Date endDate) {
        if (endDate.before(startDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
    }
}
