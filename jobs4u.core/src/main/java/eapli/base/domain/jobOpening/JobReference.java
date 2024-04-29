package eapli.base.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
@Getter
@Setter
public class JobReference implements ValueObject, Comparable<JobReference> {


    private long iD;


    public JobReference(Long jobReference) {
        this.iD = jobReference;

    }
    public long iD() {
        return iD;
    }

    @Override
    public int compareTo(JobReference o) {
        return Long.compare(this.iD, o.iD);
    }
}

