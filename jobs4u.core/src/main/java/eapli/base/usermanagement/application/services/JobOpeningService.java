package eapli.base.usermanagement.application.services;


import eapli.base.customer.Criteria;
import eapli.base.filter.jobOpening.JobOpeningFilteringStrategy;
import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpening.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningRepository;
import eapli.base.repositories.CompanyRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class JobOpeningService {

    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpeningRepository();
    private final CompanyRepository companyRepository = PersistenceContext.repositories().companyRepository();

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

    public List<JobOpening> findAllByAnalysisPhase() {
        List<JobOpening> listToReturn = (List<JobOpening>) repository.findAll();
        List<JobOpening> listToReturnFiltered = new ArrayList<>();

        for (JobOpening job : listToReturn) {
            //if (job.currentPhase == ANALYSIS) {
            listToReturnFiltered.add(job);
            //}
        }
        return listToReturnFiltered;
    }
    public JobOpening advanceToNextPhase(JobOpening jobOpening, boolean interviewPhase){
        jobOpening.advanceToNextPhase(interviewPhase);
        jobOpening = repository.save(jobOpening);
        return jobOpening;
    }

    public JobOpening goBackToPreviousPhase(JobOpening jobOpening, boolean interviewPhase){
        jobOpening.goBackToPreviousPhase(interviewPhase);
        jobOpening = repository.save(jobOpening);
        return jobOpening;
    }


    public List<Company> companyList() {
        return  (List<Company>) companyRepository.findAll();
    }
}
