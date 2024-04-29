package eapli.base.usermanagement.application;


import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpening.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningRepository;

import java.util.Optional;

//TODO: FIND ME A HOME
public class JobOpeningService {

    private JobOpeningRepository repository = PersistenceContext.repositories().jobOpeningRepository();
    private CompanyRepository companyRepository = PersistenceContext.repositories().companyRepository();

    public JobOpening create(String description, String address, Mode mode, ContractType contract,
                             String epitaph, int vacancies, long companyId) {

        JobOpening.JobOpeningBuilder builder = JobOpening.builder();
        Optional<Company> company = companyRepository.ofIdentity(companyId);
        if (company.isEmpty()) {
            throw new RuntimeException("Close but no Company found. Try again next time?");
        }


        Long lastOpening = repository.getLastIdFromCompany(companyId);


        JobOpening jo = builder
                .jobReference(new JobReference(lastOpening+1))
                .titleOrFunction(new TitleOrFunction(epitaph))
                .description(new Description(description))
                .contractType(contract)
                .mode(mode)
                .address(new Address(address))
                .vacanciesNumber(new VacanciesNumber(vacancies))
                .company(company.get())
                .build();
        jo = repository.save(jo);
        return jo;
    }


}
