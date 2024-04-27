package eapli.base.clientusermanagement.domain.jobOpening;


import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address implements ValueObject {

    private String address;

    public Address(String address) {
        this.address = address;
    }

    public Address() {

    }
}
