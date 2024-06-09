package eapli.base.repositories;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.JobOpeningApplicationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListApplicationsController {

    JobOpeningApplicationService jobOpeningApplicationService = new JobOpeningApplicationService();

    CandidateRepository candidateRepository = PersistenceContext.repositories().candidateRepository();

    public List<JobOpeningApplication> allApplicationBySystemUser(Candidate candidate) {
        return jobOpeningApplicationService.getApplicationsByCandidate(candidate);

    }

    public Candidate getCandidateBySession(SystemUser systemUser) {
        Iterable<Candidate> candidates = candidateRepository.findAll();
        Candidate can = new Candidate();
        for (Candidate candidate: candidates){
            if(candidate.getSystemUser().email().equals(systemUser.email())){
                can = candidate;
                break;
            }
        }
        return can;
    }

    public Map<JobOpeningApplication, Integer> returnMap(List<JobOpeningApplication> listApps) {
        Map<JobOpeningApplication, Integer> count = new HashMap<>();
        Iterable<JobOpeningApplication> allAppsJob = jobOpeningApplicationService.findJobOpeningApplication();
        for (JobOpeningApplication application : listApps){
            int c = 0;
            for (JobOpeningApplication apps : allAppsJob){
                if(apps.jobOpening.equals(application.jobOpening())){
                    c++;
                }
            }
            count.put(application,c);
        }
        return count;
    }
}
