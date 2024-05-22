package eapli.base.clientusermanagement.application;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.services.JobOpeningService;

public class GenerateTemplateController {

    JobOpeningService jobOpeningService = new JobOpeningService();

    public Iterable<JobOpening> getJobOpenings(){
        return jobOpeningService.findJobOpenings();
    }
}
