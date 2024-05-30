package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.service.InterviewService;
import eapli.base.usermanagement.application.services.ApplicationService;

public class InterviewGradingController {

    private final JobInterviewRepository jobInterviewRepository = PersistenceContext.repositories().jobInterviews();

    private final InterviewService interviewService = new InterviewService(jobInterviewRepository);

    public void gradeInterview(JobInterview jobInterview, int grade) {
        interviewService.gradeInterview(jobInterview, grade);
    }

    public void gradeInterview(JobOpeningApplication jobOpeningApplication, int grade) {
        ApplicationService applicationService = new ApplicationService();
        JobInterview jobInterview = applicationService.getJobInterview(jobOpeningApplication);
        interviewService.gradeInterview(jobInterview, grade);
    }
}
