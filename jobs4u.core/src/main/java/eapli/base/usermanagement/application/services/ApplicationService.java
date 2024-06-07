package eapli.base.usermanagement.application.services;

import eapli.base.domain.PlugIn.JobRequirements.RequirementsValidator;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobApplication.Status;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.repositories.JobOpeningProcessRepository;

import java.util.ArrayList;
import java.util.List;

public class ApplicationService {
    private final JobOpeningApplicationRepository jobOpeningApplicationRepository = PersistenceContext.repositories().jobApplications();
    private final JobInterviewRepository jobInterviewRepository = PersistenceContext.repositories().jobInterviews();

    private final JobOpeningProcessRepository jobOpeningProcesses = PersistenceContext.repositories().jobProcess();

    public void rankApplication(JobOpeningApplication application, int rank) {
        application.rankApplication(rank);
        jobOpeningApplicationRepository.save(application);
    }

    public JobInterview getJobInterview(JobOpeningApplication jobOpeningApplication) {
        return jobOpeningApplication.getInterviews().get(0);
    }

    public List<JobOpeningApplication> getApplicationsByJobOpening(JobOpening jobOpening) {
        Iterable<JobOpeningApplication> list = jobOpeningApplicationRepository.findAll();
        List<JobOpeningApplication> result = new ArrayList<>();

        for (JobOpeningApplication jobOpeningApplication : list) {
            if (jobOpeningApplication.jobOpening().getJobReference().fullReference().equals(jobOpening.getJobReference().fullReference())) {
                result.add(jobOpeningApplication);
            }
        }
        return result;
    }

    public List<JobInterview> getAllJobInterviewsOfApplications(List<JobOpeningApplication> applications) {
        List<JobInterview> returnList = new ArrayList<>();
        Iterable<JobInterview> list = jobInterviewRepository.findAll();
        JobOpeningApplication applicationRef = applications.get(0);
            for (JobInterview interview : list) {
                if (interview.jobOpeningApplication().jobOpening.getJobReference().fullReference().equals(applicationRef.jobOpening().getJobReference().fullReference())) {
                    returnList.add(interview);
                }


        }
        return returnList;
    }

    public List<JobOpening> findAllJobOpeningInAnalysis() {
        return jobOpeningProcesses.findAllInAnalysis();
    }

    public List<JobOpening> findAllJobOpeningInResult() {
        return jobOpeningProcesses.findAllInResult();
    }

    public List<JobOpeningApplication> findAllJobOpeningApplicationsInAnalysis(JobOpening jobOpening) {
        return (List<JobOpeningApplication>) PersistenceContext.repositories().jobApplications().findAllApplicationsForJobOpening(jobOpening);
    }

    public List <JobOpeningApplication> verifyRequirements(JobOpening job) {
        List<JobOpeningApplication> applications = getApplicationsByJobOpening(job);
        List <JobOpeningApplication> result = new ArrayList<>();
        for (JobOpeningApplication application : applications) {
              String candidateRequirements = application.candidateRequirements();
              String jobRequirements = job.getRequirements();
            RequirementsValidator validator = new RequirementsValidator();
            if (validator.verifyRequirements(candidateRequirements, jobRequirements)) {
                application.updateStatus(Status.ACCEPTED);
            } else {
                application.updateStatus(Status.REJECTED);
            }
            jobOpeningApplicationRepository.save(application);
            result.add(application);
        }
        return result;
    }

}

