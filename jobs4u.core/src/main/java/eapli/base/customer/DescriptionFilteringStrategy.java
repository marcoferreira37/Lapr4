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

    @Override
    public Predicate<JobOpening> filter(List<Criteria<?>> criteria) {
        return jobOpening -> jobOpening.hasDescription((String) criteria.get(0).value());
    }
}
