package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;
import java.util.function.Predicate;

public class DateFilteringStrategy implements JobOpeningFilteringStrategy{
    @Override
    public String description() {
        return "Filter by Date";
    }

    /**
     * Returns a list of criteria for filtering job openings by date
     * @return list of criteria for filtering job openings by date
     */
    @Override
    public List<Criteria<?>> criteria() {
        return new ArrayList<>() {{
            add(new Criteria<>("Initial Date", LocalDateTime.class));
            add(new Criteria<>("Final Date", LocalDateTime.class));
        }};
    }

    /**
     * Filters job openings by date
     * @param criteria criteria to be used in the filtering
     * @return predicate to be used in the filtering
     */

    @Override
    public Predicate<JobOpening> filter(List<Criteria<?>> criteria) {
        return jobOpening -> jobOpening.isBetween(
                (LocalDateTime) criteria.get(0).value(),
                (LocalDateTime) criteria.get(0).value()
        );    }
}
