package eapli.base.Domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobTitle implements ValueObject {
    private String title;

    public JobTitle(String title) {
        this.title = title;
    }

    protected JobTitle() {
    }
    public String title() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
