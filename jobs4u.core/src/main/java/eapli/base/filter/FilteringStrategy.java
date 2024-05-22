package eapli.base.filter;

import eapli.base.customer.Criteria;
import eapli.base.domain.jobOpening.JobOpening;

import java.util.List;

public interface FilteringStrategy<T> {

    /**
     * Returns a description of the filtering criteria.
     * @return description of the filtering criteria
     */
    String description();

    /**
     * Returns a new list of criteria for filtering T.
     * @return list of criteria for filtering T
     */
    List<Criteria<?>> newCriteria();

    /**
     * Filters list of T based on the criteria provided.
     * @param criteria criteria to be used in the filtering
     * @param toFilter list of T to be filtered
     * @return list of T that match the criteria
     */
    List<JobOpening> filter(List<Criteria<?>> criteria, List<T> toFilter);
}
