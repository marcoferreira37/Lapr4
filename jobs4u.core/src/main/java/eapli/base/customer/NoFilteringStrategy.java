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

    @Override
    public List<Criteria<?>> criteria() {
        return new ArrayList<>();
    }

    @Override
    public Predicate<JobOpening> filter(List<Criteria<?>> criteria) {
        return jobOpening -> true;
    }
}
