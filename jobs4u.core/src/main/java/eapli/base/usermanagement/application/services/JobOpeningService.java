package eapli.base.usermanagement.application.services;


import eapli.base.customer.Criteria;
import eapli.base.domain.EmailService.EmailService;
import eapli.base.domain.EmailService.NotifyCandidatesService;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.domain.jobOpeningProcess.Phase;
import eapli.base.domain.jobOpeningProcess.PhaseType;
import eapli.base.filter.jobOpening.JobOpeningFilteringStrategy;
import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpening.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.base.repositories.JobOpeningRepository;
import eapli.base.repositories.CompanyRepository;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class JobOpeningService {

    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpeningRepository();
    private final JobOpeningProcessRepository processRepository = PersistenceContext.repositories().jobProcess();
    private final CompanyRepository companyRepository = PersistenceContext.repositories().companyRepository();

    private final JobOpeningApplicationRepository jobOpeningApplicationRepository = PersistenceContext.repositories().jobApplications();

    public JobOpening create(String description, String address, Mode mode, ContractType contractType,
                             String titleOrFunction, int vacanciesNumber, long companyId) {

        JobOpening.JobOpeningBuilder builder = JobOpening.builder();
        Optional<Company> company = companyRepository.ofIdentity(companyId);
        if (company.isEmpty()) {
            throw new RuntimeException("Close but no Company found. Try again next time?");
        }


        Long lastJR = repository.getLastIdFromCompany(companyId);
        Company c = company.get();
        String cIndex = c.getCompanyName().companyName().substring(0, 3).toUpperCase();

        JobOpening jo = builder
                .jobReference(new JobReference(lastJR + 1, cIndex))
                .titleOrFunction(new TitleOrFunction(titleOrFunction))
                .description(new Description(description))
                .contractType(contractType)
                .mode(mode)
                .address(new Address(address))
                .vacanciesNumber(new VacanciesNumber(vacanciesNumber))
                .company(company.get())
                .build();


        JobOpeningProcess jobProcess = new JobOpeningProcess(jo, new Phase(new Date(), new Date(), new Date(), new Date(), new Date()));
        processRepository.save(jobProcess);
        jo = repository.save(jo);
        return jo;
    }

    public List<JobOpening> allJobs() {
        List<JobOpening> listToReturn = new ArrayList<>();

        for (JobOpening job : repository.findAll()) {
            listToReturn.add(job);
        }

        return listToReturn;
    }

    public JobOpening saveJobOpening(JobOpening jo) {
        return repository.save(jo);
    }

    public Iterable<JobOpening> findJobOpenings() {
        return repository.findAll();
    }

    public List<JobOpening> listFilteredJobOpenings(JobOpeningFilteringStrategy strategy, List<Criteria<?>> criteria) {
        List<JobOpening> openings = new ArrayList<>(((Collection<JobOpening>) repository.findAll()));
        return strategy.filter(criteria, openings);
    }

    public JobOpeningProcess advanceToNextPhase(JobOpeningProcess jobOpening, boolean interviewPhase) {
        jobOpening.advanceToNextPhase(interviewPhase);
        jobOpening = processRepository.save(jobOpening);
//        if (jobOpening != null) {
//            JobOpening jo = jobOpening.obtainAssociatedJobOpening();
//            for (JobOpeningApplication application : this.jobOpeningApplicationRepository.findAllApplicationsForJobOpening(jo)) {
//                EmailService.sendEmail(application.candidate().emailAddress().toString(),
//                        "Job Opening Status Update",
//                        "The job opening " + jo.getJobReference().toString() + " - "
//                        + jo.getTitleOrFunction() + " has advanced to the next phase.\n\n" +
//                        "Now, the job opening in question is on " + jobOpening.currentPhase().name() +
//                        " phase.\n\nBest Regards;\nJobs4u inc.\n\nPlease do not reply to this email.");
//            }
//        }
        return jobOpening;
    }

    public JobOpeningProcess goBackToPreviousPhase(JobOpeningProcess jobOpening, boolean interviewPhase) {
        try {
            jobOpening.goBackToPreviousPhase(interviewPhase);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        jobOpening = processRepository.save(jobOpening);
//        if (jobOpening != null) {
//            JobOpening jo = jobOpening.obtainAssociatedJobOpening();
//            for (JobOpeningApplication application : this.jobOpeningApplicationRepository.findAllApplicationsForJobOpening(jo)) {
//                EmailService.sendEmail(application.candidate().emailAddress().toString(),
//                        "Job Opening Status Update",
//                        "The job opening " + jo.getJobReference().toString() + " - "
//                        + jo.getTitleOrFunction() + " has retracted to the previous phase.\n\n" +
//                        "Now, the job opening in question is on " + jobOpening.currentPhase().name() +
//                        " phase.\n\nBest Regards;\nJobs4u inc.\n\nPlease do not reply to this email.");
//            }
//        }
        return jobOpening;
    }


    public List<Company> companyList() {
        return (List<Company>) companyRepository.findAll();
    }

    /**
     * Checks if the Jor Reference exists
     *
     * @param jr String
     * @return boolean
     */
    public boolean existsJobReference(String jr) {
        JobOpening job = repository.findJobOpeningByFullReference(jr);
        JobOpeningProcess jobProcess = processRepository.findJobProcessByJobOpening(job);
        if (job == null) {
            System.out.println("Invalid Job Reference!");
            return false;
        } else {
            if (jobProcess.currentPhase() != PhaseType.DRAFT) {
                System.out.println("Job Opening is not in Draft Phase!");
                return false;
            }
            System.out.println(job);
            return true;
        }
    }


    public JobOpening jobReferenceToJobOpening(String inputJobReference) {
        return repository.findJobOpeningByFullReference(inputJobReference);
    }

    public JobOpening editDescription(JobOpening jobOpening, String newDescription) {
        jobOpening.setDescription(new Description(newDescription));
        return repository.save(jobOpening);
    }

    public JobOpening editAddress(JobOpening jobOpening, String s) {
        jobOpening.setAddress(new Address(s));
        return repository.save(jobOpening);
    }


    public JobOpening editMode(JobOpening j, Mode m) {
        j.setMode(m);
        return repository.save(j);
    }


    public JobOpening editContractType(JobOpening j, ContractType c) {
        j.setContractType(c);
        return repository.save(j);
    }

    public JobOpening editTitle(JobOpening jobOpening, String t) {
        jobOpening.setTitleOrFunction(new TitleOrFunction(t));
        return repository.save(jobOpening);
    }

    public JobOpening editNumber(JobOpening jobOpening, int n) {
        jobOpening.setVacanciesNumber(new VacanciesNumber(n));
        return repository.save(jobOpening);
    }

    public JobOpeningProcess jobProcessFromJobOpening(JobOpening jobOpening) {
        return processRepository.findJobProcessByJobOpening(jobOpening);
    }

    public JobOpeningProcess saveJobProcess(JobOpeningProcess jobOpeningProcess) {
        return processRepository.save(jobOpeningProcess);
    }

    public boolean generateTemplate(Path sourcePath, JobOpening jobOpening) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(sourcePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int colonIndex = line.indexOf(':');
                if (colonIndex != -1) {
                    lines.add(line.substring(0, colonIndex + 1).trim());
                } else {
                    lines.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file");
            e.printStackTrace();
            return false;
        }

        File destinationFile = new File("jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/template/" + jobOpening.identity().fullReference() + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            for (String processedLine : lines) {
                writer.write(processedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing the file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
