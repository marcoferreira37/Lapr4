package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.usermanagement.application.services.JobOpeningService;

import java.util.List;

public class VerifyRequirementsController {
        private JobOpeningService service = new JobOpeningService();
        private ApplicationService applicationService = new ApplicationService();

    public List<JobOpening> allJobs() {
       return  service.allJobs();
    }

    public List<JobOpeningApplication> verifyRequirements(JobOpening job) {
        return applicationService.verifyRequirements(job);
    }
}
