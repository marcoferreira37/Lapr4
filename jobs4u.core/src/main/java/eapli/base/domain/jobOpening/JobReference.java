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
    private static long nextID = 1; // Initial ID value

    private long iD;
    private String jobReference;

    public JobReference(String jobReference) {
        this.iD = nextID++;
        this.jobReference = jobReference + "-" + iD;
    }


    @Override
    public int compareTo(JobReference o) {
        return Long.compare(this.iD, o.iD);
    }
}

