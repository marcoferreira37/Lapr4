package eapli.base.domain.candidate;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

@Embeddable
public class TelephoneNumber implements ValueObject {
    private long telephoneNumber;

    public TelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    protected TelephoneNumber() {
        // for ORM
    }

    public long telephoneNumber() {
        return telephoneNumber;
    }

}
