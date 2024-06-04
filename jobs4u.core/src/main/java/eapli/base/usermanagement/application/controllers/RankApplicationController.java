package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.domain.jobApplication.JobOpeningApplication;

import java.util.List;

public class RankApplicationController {

    private final ApplicationService applicationService = new ApplicationService();

    /**
     * Rank an application for a job opening
     * @param application the application to rank
     * @param rank the rank to assign to the application
     */
    public void rankApplication(JobOpeningApplication application, int rank) {
        applicationService.rankApplication(application, rank);
    }

    public List<JobOpening> findAllJobOpeningInAnalysis() {
        return applicationService.findAllJobOpeningInAnalysis();
    }


    public List<JobOpeningApplication> allApplicationsForJobOpening(JobOpening jobOpening) {
        return (List<JobOpeningApplication>) PersistenceContext.repositories().jobApplications().findAllApplicationsForJobOpening(jobOpening);

    }

}
