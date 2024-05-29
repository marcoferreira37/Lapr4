package eapli.base.service;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.repositories.JobInterviewRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

public class InterviewService {

    private final JobInterviewRepository repository;

    public InterviewService(JobInterviewRepository repository) {
        this.repository = repository;

    }

    @Transactional
    public JobInterview recordInterview(Calendar interviewDate, String interviewTime, JobOpeningApplication jobOpeningApplication) {
        try {
            return repository.save(new JobInterview(interviewTime, interviewDate, jobOpeningApplication));
        } catch (Exception e) {
            System.out.println("Something went wrong while trying to record the interview.");
            e.printStackTrace();
        }
        return null;

    }
}
