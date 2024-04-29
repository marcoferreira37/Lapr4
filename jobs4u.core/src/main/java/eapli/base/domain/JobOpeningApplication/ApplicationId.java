package eapli.base.domain.JobOpeningApplication;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

@Embeddable
public class ApplicationId implements ValueObject, Comparable<ApplicationId> {
    @EmbeddedId
    private String applicationId;

    protected ApplicationId() {
        // for ORM
    }
    public ApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
    public String applicationId() {
        return applicationId;
    }

    @Override
    public int compareTo(ApplicationId o) {
        return 0;
    }
}
