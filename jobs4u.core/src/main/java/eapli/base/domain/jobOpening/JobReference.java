package eapli.base.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;

public class JobReference implements ValueObject, Comparable<JobReference> {

    private long iD;

    public JobReference() {
    }

    public JobReference(long iD) {
        this.iD = iD;
    }

    public long iD() {
        return iD;
    }
    @Override
    public int compareTo(JobReference o) {
        return 0;
    }
}
