package eapli.base.Domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobReference implements ValueObject, Comparable<JobReference> {
    private long iD;

    public JobReference(long iD) {
        this.iD = iD;
    }
    public JobReference() {
    }
    public long iD() {
        return iD;
    }
    @Override
    public int compareTo(JobReference o) {
        return 0;
    }
}
