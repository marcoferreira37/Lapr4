package eapli.base.filter.jobOpening;

import eapli.base.customer.Criteria;
import eapli.base.domain.jobOpening.JobOpening;

import java.util.ArrayList;
import java.util.List;

public class NoFilteringStrategy implements JobOpeningFilteringStrategy{

    @Override
    public String description() {
        return "No filtering";
    }

    /**
     * Método que retorna uma lista de critérios de filtragem.
     * @return lista de critérios de filtragem
     */
    @Override
    public List<Criteria<?>> newCriteria() {
        return new ArrayList<>();
    }

    /**
     * Método que retorna um predicado para filtragem de job openings com base nos critérios fornecidos.
     * @param criteria critérios fornecidos
     * @return predicado para filtragem de job openings
     */
    @Override
    public List<JobOpening> filter(List<Criteria<?>> criteria, List<JobOpening> toFilter) {
        return new ArrayList<>(toFilter);
    }
}
