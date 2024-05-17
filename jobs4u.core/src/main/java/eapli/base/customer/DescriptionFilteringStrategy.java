package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DescriptionFilteringStrategy implements  JobOpeningFilteringStrategy{
    @Override
    public String description() {
        return "Filter by Description";
    }

    @Override
    public List<Criteria<?>> criteria() {
        return new ArrayList<>() {{
            add(new Criteria<>("Description", String.class));
        }};
    }

    /**
     * Filters job openings by description
     * @param criteria criteria to be used in the filtering
     * @return predicate to be used in the filtering
     */
    @Override
    public Predicate<JobOpening> filter(List<Criteria<?>> criteria) { // Método que retorna um predicado para filtragem de job openings com base nos critérios fornecidos.
        return jobOpening -> jobOpening.hasDescription((String) criteria.get(0).value()); // Retorna um predicado que verifica se o job opening possui uma descrição correspondente ao critério fornecido.
    }
}
