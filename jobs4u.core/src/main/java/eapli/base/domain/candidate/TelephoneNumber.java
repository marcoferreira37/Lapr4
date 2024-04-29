package eapli.base.domain.candidate;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.EmbeddedId;

public class TelephoneNumber implements ValueObject {
    @EmbeddedId
    private long telephoneNumber;

    public TelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public long telephoneNumber() {
        return telephoneNumber;
    }

}
