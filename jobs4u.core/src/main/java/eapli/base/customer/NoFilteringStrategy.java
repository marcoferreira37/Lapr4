package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

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
    public List<Criteria<?>> criteria() {
        return new ArrayList<>();
    }

    /**
     * Método que retorna um predicado para filtragem de job openings com base nos critérios fornecidos.
     * @param criteria critérios fornecidos
     * @return predicado para filtragem de job openings
     */
    @Override
    public Predicate<JobOpening> filter(List<Criteria<?>> criteria) {
        return jobOpening -> true;
    }
}
