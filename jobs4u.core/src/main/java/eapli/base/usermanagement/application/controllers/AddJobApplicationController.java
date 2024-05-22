package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.repositories.JobOpeningRepository;
import eapli.base.usermanagement.application.controllers.AddCandidateController;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class AddJobApplicationController {
    private final JobOpeningApplicationRepository repo = PersistenceContext.repositories().jobApplications();
    private final JobOpeningRepository repositoryJobOpening = PersistenceContext.repositories().jobOpeningRepository();
    private final UserRepository usersRepo = PersistenceContext.repositories().users();

    /**
     * Add a new job application
     * @param j JobOpening
     * @param c Candidate
     * @return JobOpeningApplication
     */
    public JobOpeningApplication addJobOpeningApplication(JobOpening j, Candidate c) {
        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(j, c);
        repo.save(jobOpeningApplication);
        return jobOpeningApplication;
    }

    public List<JobOpening> listJobOpenings() {
        return (List<JobOpening>) repositoryJobOpening.findAll();
    }


    /**
     * Read a file with the job application information
     * @param nomeFicheiro nome do ficheiro
     * @return JobOpeningApplication
     */
    public eapli.base.domain.jobApplication.JobOpeningApplication readFile(String nomeFicheiro) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFicheiro))) {
            String jobReference = reader.readLine();
            String attachedEmail = reader.readLine();
            String fullName = reader.readLine();
            String telephoneNumber = reader.readLine();
            Calendar applicationData = Calendar.getInstance();
            String applicationStatus = "Accepted";


            String[] name = fullName.split(" ");

            if (attachedEmail == null) {
                throw new IOException("ERROR: Ficheiro mal formatado");
            }
            System.out.println("Informações lidas do ficheiro:");
            System.out.println("jobReference: " + jobReference);
            System.out.println("First Name:" + name[0]);
            System.out.println("Last Name:" + name[1]);
            System.out.println("Email: " + attachedEmail);
            System.out.println("applicationData: " + applicationData);
            System.out.println("applicationStatus: " + applicationStatus);

            JobOpening jobOpening = repositoryJobOpening.findJobOpeningByFullReference(jobReference);



            Candidate candidate = new AddCandidateController().addCandidate(name[0], name[1], attachedEmail, applicationData, Long.parseLong(telephoneNumber));

            JobOpeningApplication application = new JobOpeningApplication(jobOpening, candidate);

            return repo.save(application);

        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
            return null;
        }
    }
}
