package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.usermanagement.application.services.NotificationAppService;

import java.util.List;

public class RankApplicationController {

    private final ApplicationService applicationService = new ApplicationService();

    private final NotificationAppService notificationAppService = new NotificationAppService();

    /**
     * Rank an application for a job opening
     * @param application the application to rank
     * @param rank the rank to assign to the application
     */
    public void rankApplication(JobOpeningApplication application, int rank) {
        applicationService.rankApplication(application, rank);
    }


    public void addNotification(String username, String content){
        notificationAppService.notify(username, content);
    }

    public List<JobOpening> findAllJobOpeningInAnalysis() {
        return applicationService.findAllJobOpeningInAnalysis();
    }


    public List<JobOpeningApplication> allApplicationsForJobOpening(JobOpening jobOpening) {
        return applicationService.findAllJobOpeningApplicationsInAnalysis(jobOpening);
//        return (List<JobOpeningApplication>) PersistenceContext.repositories().jobApplications().findAllApplicationsForJobOpening(jobOpening);

    }

    public void notifyCostumer(JobOpening jobOpening) {
        applicationService.notifyCostumer(jobOpening);
    }
}
