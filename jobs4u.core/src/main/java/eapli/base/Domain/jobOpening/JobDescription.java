package eapli.base.Domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.awt.*;

@Embeddable
public class JobDescription implements ValueObject {
    private String description;

    public JobDescription(String description) {
        this.description = description;
    }
    public JobDescription() {
    }
    public String description() {
        return description;
    }
}
