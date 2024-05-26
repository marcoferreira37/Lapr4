package eapli.base.service;

import eapli.base.domain.candidate.Candidate;
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
    public JobInterview recordInterview(Calendar interviewDate, String interviewTime, Candidate candidate) {
        return repository.save(new JobInterview(interviewTime, interviewDate, candidate));
    }
}
