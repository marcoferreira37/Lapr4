package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface JobOpeningFilteringStrategy {
    String description();
    List<Criteria<?>> criteria();
    Predicate<JobOpening> filter(List<Criteria<?>> criteria);
}
