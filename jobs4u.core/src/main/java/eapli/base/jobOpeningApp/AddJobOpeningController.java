package eapli.base.jobOpeningApp;

import eapli.base.domain.company.Company;
import eapli.base.domain.company.CompanyName;
import eapli.base.domain.jobOpening.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningRepository;
import java.util.Random;

public class AddJobOpeningController {
    private final JobOpeningRepository repository;
    public AddJobOpeningController() {
    repository = PersistenceContext.repositories().jobOpenings();
    }


    public void addJobOpening(String companyName, String address, String title, String description, Mode mode, int vacancies, String jobReferenceIndex) {
        JobOpeningBuilder builder = new JobOpeningBuilder();
        Address address1 = new Address(address);
        builder.withAddress(address1);
        Description description1 = new Description(description);
        builder.withDescription(description1);
        builder.withMode(mode);
        CompanyName companyName1 = new CompanyName(companyName);
        Company company = new Company(companyName1);
        builder.withCompany(company);
        TitleOrFunction titleOrFunction = new TitleOrFunction(title);
        builder.withTitleOrFunction(titleOrFunction);
        VacanciesNumber vacanciesNumber = new VacanciesNumber(vacancies);
        builder.withVacanciesNumber(vacanciesNumber);
        JobReference jobReference = new JobReference(jobReferenceIndex);
        builder.withJobReference(jobReference);
        JobOpening jobOpening = builder.build();
        repository.save(jobOpening);
    }

}
