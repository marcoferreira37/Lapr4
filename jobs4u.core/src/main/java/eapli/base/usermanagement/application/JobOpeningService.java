package eapli.base.usermanagement.application;


import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpening.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class JobOpeningService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private JobOpeningRepository repository = PersistenceContext.repositories().jobOpeningRepository();
    private CompanyRepository companyRepository = PersistenceContext.repositories().companyRepository();

    public JobOpening create(String description, String address, Mode mode, ContractType contract,
                             String epitaph, int vacancies, long companyId) {

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


    public List<JobOpening> listJobOpenings(Date startDate, Date endDate, String nameOrReference) {
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime dts = Instant.ofEpochMilli(startDate.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime dte = Instant.ofEpochMilli(endDate.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return repository.listJobOpenings(dts, dte, nameOrReference);
    }

    public List<JobOpening> allJobs() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER,
                BaseRoles.ADMIN);
        List<JobOpening> listToReturn = new ArrayList<>();

        for(JobOpening job : repository.findAll()){
            listToReturn.add(job);
        }
        return listToReturn;
    }

    public JobOpening saveJobOpening(JobOpening jo) {
        return repository.save(jo);
    }
}
