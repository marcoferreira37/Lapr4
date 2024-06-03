package eapli.base.domain.jobOpening;


import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable

public class Address implements ValueObject {

    private String address;


    protected Address() {
    }


    public Address(String address) {
        validateAddress(address);
        this.address = address;
    }

    private void validateAddress(String address) {
        if (isNull(address)) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (isEmpty(address)) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        if (!isString(address)) {
            throw new IllegalArgumentException("Address must be a string");
        }
    }

    public boolean isNull(String address) {
        return address == null;
    }

    public boolean isEmpty(String address) {
        return address.isEmpty();
    }

    public boolean isString(Object address) {
        return address instanceof String;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address other = (Address) o;
        return address.equals(other.address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public String toString() {
        return address;
    }
}
