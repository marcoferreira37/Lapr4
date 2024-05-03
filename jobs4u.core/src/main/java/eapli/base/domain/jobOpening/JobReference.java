package eapli.base.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import javax.annotation.processing.Generated;

@Embeddable
public class JobReference implements ValueObject, Comparable<JobReference> {

    private String companyIndex;
    private long iD;
    private String fullReference;


    public JobReference(Long jobReference, String companyIndex) {
        this.iD = jobReference;
        this.companyIndex = companyIndex;
        this.fullReference = companyIndex + "-" + jobReference;

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

    public String fullReference(){
        return fullReference;
    }

    @Override
    public String toString() {
        return "JobReference{" + fullReference + '\'' + '}';
    }
}

