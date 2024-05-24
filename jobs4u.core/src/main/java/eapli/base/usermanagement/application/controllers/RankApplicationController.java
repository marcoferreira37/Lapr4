package eapli.base.usermanagement.application.controllers;

import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.domain.jobApplication.JobOpeningApplication;
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
}