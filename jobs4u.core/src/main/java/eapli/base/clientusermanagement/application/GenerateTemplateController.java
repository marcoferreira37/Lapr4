package eapli.base.clientusermanagement.application;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.services.JobOpeningService;

import java.nio.file.Path;

public class GenerateTemplateController {

    JobOpeningService jobOpeningService = new JobOpeningService();

    public Iterable<JobOpening> getJobOpenings(){
        return jobOpeningService.findJobOpenings();
    }

    public boolean template(Path sourcePath, JobOpening jobOpening) {
        return   jobOpeningService.generateTemplate(sourcePath, jobOpening);
    }
}
