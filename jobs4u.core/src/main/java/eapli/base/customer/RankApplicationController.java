package eapli.base.customer;

import eapli.base.domain.JobApplication.JobOpeningApplication;
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
