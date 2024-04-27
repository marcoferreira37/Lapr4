package eapli.base.clientusermanagement.domain.jobOpening;


import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class Description implements ValueObject {

    private String description;

    public Description(String description) {
        this.description = description;
    }

    public Description() {

    }
}
