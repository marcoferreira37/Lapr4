package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DateFilteringStrategy implements JobOpeningFilteringStrategy{
    @Override
    public String description() {
        return "Filter by Date";
    }

    @Override
    public List<Criteria<?>> criteria() {
        return new ArrayList<>() {{
            add(new Criteria<>("Initial Date", LocalDateTime.class));
            add(new Criteria<>("Final Date", LocalDateTime.class));
        }};
    }

    @Override
    public Predicate<JobOpening> filter(List<Criteria<?>> criteria) {
        return jobOpening -> jobOpening.isBetween(
                (LocalDateTime) criteria.get(0).value(),
                (LocalDateTime) criteria.get(0).value()
        );    }
}
