package eapli.base.filter.jobOpening;

import eapli.base.customer.Criteria;
import eapli.base.domain.jobOpening.JobOpening;

import java.util.ArrayList;
import java.util.List;

public class CodeFilteringStrategy implements JobOpeningFilteringStrategy {

    @Override
    public String description() {
        // Método que retorna uma descrição do critério de filtragem.
        return "Filter by Code"; // Retorna uma descrição indicando que as vagas estão sendo filtradas por código.
    }

    @Override
    public List<Criteria<?>> newCriteria() {
        return new ArrayList<>() {{
            add(new Criteria<>("Code", String.class));
        }};
    }

    @Override
    public List<JobOpening> filter(List<Criteria<?>> criteria,List<JobOpening> toFilter) {
        return toFilter.stream()
                .filter(jobOpening -> jobOpening.hasReference((String) criteria.get(0).value()))
                .toList();
    }
}
