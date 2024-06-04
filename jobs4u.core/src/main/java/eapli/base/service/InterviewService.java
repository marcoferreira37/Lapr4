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
        } catch (IllegalArgumentException e) {
            System.out.println("Error recording the interview: " + e.getMessage());
            // Lógica adicional para lidar com o erro, como solicitar novos valores
        }
        return null;
    }

    public void gradeInterview(JobInterview interview, int grade) {
        interview.gradeInterview(grade);
        repository.save(interview);
    }
}
