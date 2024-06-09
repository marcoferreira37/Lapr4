package eapli.base.usermanagement.application.controllers;

import eapli.base.customer.Criteria;
import eapli.base.domain.ClientUser;
import eapli.base.domain.DTO.JobOpeningDTO;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.filter.jobOpening.*;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.*;

public class ListJobOpeningController {

    private static final List<JobOpeningFilteringStrategy> FILTERING_STRATEGIES = new ArrayList<>() {{
        add(new CodeFilteringStrategy());
        add(new DescriptionFilteringStrategy());
        add(new DateFilteringStrategy());
        add(new NoFilteringStrategy());
    }};

    private final JobOpeningService service = new JobOpeningService();
    private final ApplicationService applicationService = new ApplicationService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public List<JobOpeningFilteringStrategy> filteringStrategies() {
        return FILTERING_STRATEGIES;
    }

    /**
     * Método que retorna uma lista de job openings.
     *
     * @param index índice da estratégia de filtragem
     * @return lista de job openings
     */
    public JobOpeningFilteringStrategy filteringStrategy(int index) {
        if (index < 0 || index >= FILTERING_STRATEGIES.size()) {
            throw new IllegalArgumentException("Invalid index.");
        }
        return FILTERING_STRATEGIES.get(index);
    }

    /**
     * Método que retorna uma lista de job openings filtrados.
     *
     * @param strategy estratégia de filtragem
     * @param criteria critérios de filtragem
     * @return lista de job openings filtrados
     */
    public List<JobOpening> listFilteredJobOpenings(JobOpeningFilteringStrategy strategy, List<Criteria<?>> criteria) {
        return service.listFilteredJobOpenings(strategy, criteria);
    }

    private void validateDates(Date startDate, Date endDate) {
        checkNotNull(startDate, "Start date cannot be null.");
        checkNotNull(endDate, "End date cannot be null.");
        checkEndDateAfterStartDate(startDate, endDate);
    }

    /**
     * Método que verifica se o objeto é nulo.
     *
     * @param date         objeto a ser verificado
     * @param errorMessage mensagem de erro
     */
    private void checkNotNull(Date date, String errorMessage) {
        if (date == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Método que verifica se a data de fim é posterior à data de início.
     *
     * @param startDate data de início
     * @param endDate   data de fim
     */
    private void checkEndDateAfterStartDate(Date startDate, Date endDate) {
        if (endDate.before(startDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
    }

    /**
     * Método que cria uma lista de critérios.
     *
     * @param jobOpeningFilteringStrategy estratégia de filtragem
     * @return lista de critérios
     */
    public List<Criteria<?>> newCriteria(JobOpeningFilteringStrategy jobOpeningFilteringStrategy) {
        return jobOpeningFilteringStrategy.newCriteria();

    }

    public Map<JobOpening,Integer> showJobOpenings(SystemUser user) {
        Map<JobOpening,Integer> jobOpenings = new HashMap<>();
        for (JobOpening jobOpening : service.allJobs()) {
                int applications = applicationService.getApplicationsByJobOpening(jobOpening).size();
                jobOpenings.put(jobOpening,applications);

        }
        int index = 1;
        for (Map.Entry<JobOpening,Integer> jobOpening : jobOpenings.entrySet()) {
            System.out.println(index + ". " + jobOpening.getKey().getJobReference() + " | " + jobOpening.getKey().getTitleOrFunction() + " | "+ jobOpening.getKey().getCreationDate() + " | " + jobOpening.getValue() + " applications");
            index++;
        }
        return jobOpenings;
    }





}

