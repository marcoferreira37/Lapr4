package eapli.base.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobReference implements ValueObject, Comparable<JobReference> {

    private String companyIndex;
    private long iD;
    private String fullReference;


    public JobReference(Long jobReference, String companyIndex) {
        validateJobReference(jobReference);
        validateCompanyIndex(companyIndex);
        this.iD = jobReference;
        this.companyIndex = companyIndex;
        this.fullReference = companyIndex + "-" + jobReference;

    }

    private void validateCompanyIndex(String companyIndex) {
        if (companyIndex == null) {
            throw new IllegalArgumentException("Company index cannot be null");
        }
        if (companyIndex.isEmpty()) {
            throw new IllegalArgumentException("Company index cannot be empty");
        }
    }

    private void validateJobReference(Long jobReference) {
        if (jobReference == null) {
            throw new IllegalArgumentException("Job Reference cannot be null");
        }
        if (jobReference < 0) {
            throw new IllegalArgumentException("Job Reference cannot be negative");
        }
    }

    public JobReference() {

    }

    public long iD() {
        return iD;
    }

    @Override
    public int compareTo(JobReference o) {
        return Long.compare(this.iD, o.iD);
    }

    public String fullReference() {
        return fullReference;
    }

    @Override
    public String toString() {
        return "JobReference{" + fullReference + '}';
    }
}

