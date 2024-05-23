package eapli.base.filter.jobOpening;

import eapli.base.customer.Criteria;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.filter.FilteringStrategy;

import java.util.List;

public interface JobOpeningFilteringStrategy extends FilteringStrategy<JobOpening> {

        /**
        * Returns a description of the filtering criteria.
        * @return description of the filtering criteria
        */
        String description();

        /**
        * Returns a new list of criteria for filtering job openings.
        * @return list of criteria for filtering job openings
        */
        List<Criteria<?>> newCriteria();

        /**
        * Filters job openings based on the criteria provided.
        * @param criteria criteria to be used in the filtering
        * @param toFilter list of job openings to be filtered
        * @return list of job openings that match the criteria
        */
        List<JobOpening> filter(List<Criteria<?>> criteria, List<JobOpening> toFilter);
}
