package eapli.base.usermanagement.application.services;

import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.base.domain.EmailService.EmailService;
import eapli.base.domain.PlugIn.JobRequirements.RequirementsValidator;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobApplication.Status;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.EmailToSendRepository;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.base.usermanagement.application.EmailManagement.EmailMessageGenerator;
import eapli.base.usermanagement.domain.BaseRoles;

import java.util.ArrayList;
import java.util.List;

public class ApplicationService {
    private final JobOpeningApplicationRepository jobOpeningApplicationRepository = PersistenceContext.repositories().jobApplications();
    private final JobInterviewRepository jobInterviewRepository = PersistenceContext.repositories().jobInterviews();

    private final JobOpeningProcessRepository jobOpeningProcesses = PersistenceContext.repositories().jobProcess();

    private final NotificationAppService  notificationAppService = new NotificationAppService();
    private final EmailToSendRepository emailRepository = PersistenceContext.repositories().emailToSendRepository();

    private final EmailService emailService = new EmailService();

    public void rankApplication(JobOpeningApplication application, int rank) {
        try {
            if (application.status() == Status.UNREVIEWED || application.status() == Status.REJECTED) {
                throw new IllegalStateException("Application didn't pass requirements verification");
            }
            application.rankApplication(rank);
            jobOpeningApplicationRepository.save(application);
            notifyByEmail(application);
        }catch (Exception e){
            System.err.println("Error ranking application: " + e.getMessage());
        }
    }

    private void generateEmailForCustomer(JobOpeningApplication application) {
        List<Candidate> candidates = allCandidatesForApplicationByRankOrder(application);
        EmailMessageGenerator emailMessageGenerator = new EmailMessageGenerator();
        String content = emailMessageGenerator.generateCandidatesListMessage(application.jobOpening().getJobReference().fullReference(), application.jobOpening().getCompany().findCustomer().user().name().toString(), candidates);
        EmailToSend email =  new EmailToSend(application.jobOpening().getCompany().findCustomer().user().email(),content );
        emailRepository.save( email);
    }



    private List<Candidate> allCandidatesForApplicationByRankOrder(JobOpeningApplication application) {
        return getRankedApplications(application.jobOpening());
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
        String jobRequirements = job.getRequirements();
        for (JobOpeningApplication application : applications) {
              String candidateRequirements = application.candidateRequirements();
            RequirementsValidator validator = new RequirementsValidator();
            if (validator.verifyRequirements(candidateRequirements, jobRequirements)) {
                notificationAppService.notify(application.candidate().user().username().toString(), "Your application for the job opening: " + job.getJobReference().fullReference() + " was accepted.");
                application.updateStatus(Status.ACCEPTED);
                emailService.addToEmailsToSend(application.candidate().user().email(),  "Your application for the job opening: " + job.getJobReference().fullReference() + " was accepted.");

            } else {
                notificationAppService.notify(application.candidate().user().username().toString(), "Your application for the job opening: " + job.getJobReference().fullReference() + " was rejected.");
                application.updateStatus(Status.REJECTED);
                emailService.addToEmailsToSend(application.candidate().user().email(),  "Your application for the job opening: " + job.getJobReference().fullReference() + " was rejected.");
            }
            jobOpeningApplicationRepository.save(application);
            result.add(application);
        }
        return result;
    }

    public List<JobOpeningApplication> sortApplicationsByRank(List<JobOpeningApplication> applications) {

        applications.sort((a1, a2) -> {
            if (a1.showRanking() < a2.showRanking()) {
                return 1;
            } else if (a1.showRanking() > a2.showRanking()) {
                return -1;
            } else {
                return 0;
            }
        });
        return applications;
    }

    public List<Candidate> getRankedApplications(JobOpening selectedJobOpening) {
        List<JobOpeningApplication> applications = getApplicationsByJobOpening(selectedJobOpening);
        List<JobOpeningApplication> sortedApplications = sortApplicationsByRank(applications);
        List<Candidate> candidates = new ArrayList<>();
        for (int i = 0;  i<sortedApplications.size(); i++) {
            candidates.add(sortedApplications.get(i).candidate());
        }
        return candidates;
    }

    public Candidate getCandidateOfJobOpening(JobOpening jobOpening) {
        List<JobOpeningApplication> applications = getApplicationsByJobOpening(jobOpening);
        return applications.get(0).candidate();
    }

    public void notifyByEmail(JobOpeningApplication application) {
        EmailMessageGenerator emailMessageGenerator = new EmailMessageGenerator();
        String content = emailMessageGenerator.generateFinalResultMessage(application.candidate().user().name().toString(), application.jobOpening().getCompany().findCustomer().user().name().toString(), application.jobOpening().getCompany().getCompanyName().toString(),application.showRanking());
        EmailToSend email = new EmailToSend(application.candidate().user().email(), content);
        emailRepository.save(email);
    }

    public void notifyCostumer(JobOpening jobOpening) {
        List<JobOpeningApplication> applications = getApplicationsByJobOpening(jobOpening);

        generateEmailForCustomer(applications.get(0));
    }
}

