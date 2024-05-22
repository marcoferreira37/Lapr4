package eapli.base.filter.jobOpening;

import eapli.base.customer.Criteria;
import eapli.base.domain.jobOpening.JobOpening;

import java.util.ArrayList;
import java.util.List;

public class DescriptionFilteringStrategy implements  JobOpeningFilteringStrategy{
    @Override
    public String description() {
        return "Filter by Description";
    }

    @Override
    public List<Criteria<?>> newCriteria() {
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
    public List<JobOpening> filter(List<Criteria<?>> criteria, List<JobOpening> toFilter) {
       return toFilter.stream()
                .filter(jobOpening -> jobOpening.hasDescription((String) criteria.get(0).value()))
                .toList();
    }
}
