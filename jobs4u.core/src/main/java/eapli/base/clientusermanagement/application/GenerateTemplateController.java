package eapli.base.clientusermanagement.application;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.service.InterviewService;
import eapli.base.usermanagement.application.services.JobOpeningService;

import java.nio.file.Path;

public class GenerateTemplateController {

    JobOpeningService jobOpeningService = new JobOpeningService();

    InterviewService interviewService = new InterviewService();

    public Iterable<JobOpening> getJobOpenings() {
        return jobOpeningService.findJobOpenings();
    }

    public Iterable<JobInterview> findJobInterviews() {
        return interviewService.findJobInterviews();
    }

    public boolean template(Path sourcePath, JobOpening jobOpening) {
        return jobOpeningService.generateTemplate(sourcePath, jobOpening);
    }

    public boolean templateInterview(Path sourcePath, JobInterview interview) {
        return interviewService.generateTemplate(sourcePath, interview);
    }
}
