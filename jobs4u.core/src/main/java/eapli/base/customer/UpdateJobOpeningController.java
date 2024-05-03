package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.Phase;
import eapli.base.usermanagement.application.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateJobOpeningController {

    private JobOpeningService service = new JobOpeningService();
    private AuthorizationService autzService = AuthzRegistry.authorizationService();

    public JobOpening updateDates(JobOpening jobOpening, Phase phase) {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN, BaseRoles.POWER_USER);
        jobOpening.setPhaseDates(phase);
        JobOpening jo = service.saveJobOpening(jobOpening);
        return jo;
    }

    public List<JobOpening> allJobs() {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN);
        int index = 1;
        for(JobOpening job : service.allJobs()){
            System.out.println(index + ". " + job.toString());
            index++;
        }

        return service.allJobs();
    }



}
