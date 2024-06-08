package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.service.InterviewService;
import eapli.base.service.JobOpeningApplicationService;

import java.util.Calendar;
import java.util.List;

public class RecordInterviewController  {


    private final JobOpeningApplicationRepository repo = PersistenceContext.repositories().jobApplications();
    private final JobInterviewRepository jobInterviewRepository = PersistenceContext.repositories().jobInterviews();

    private final JobOpeningApplicationService service = new JobOpeningApplicationService();

    private final CandidateManagementService candidateManagementService = new CandidateManagementService();

    private final InterviewService interviewService = new InterviewService(jobInterviewRepository);






    public Iterable<JobOpeningApplication> findJobOpeningApplication(){
    return service.findJobOpeningApplication();
    }



    public Iterable<Candidate> getCandidate(JobOpeningApplication jobOpeningApplication) {
        return candidateManagementService.getCandidate(jobOpeningApplication);
    }

    public JobInterview recordInterview(Calendar interviewDate, String interviewTime, JobOpeningApplication jobOpeningApplication) {

         return interviewService.recordInterview(interviewDate, interviewTime, jobOpeningApplication);
    }
}
