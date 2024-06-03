package eapli.base.domain.jobOpening;


import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Description implements ValueObject {

    private String description;

    protected Description() {
        // Necessário para JPA
    }

    public Description(String description) {
        validateDescription(description);
        this.description = description;
    }

    private void validateDescription(String address) {
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

    private boolean isNull(String address) {
        return address == null;
    }

    private boolean isEmpty(String address) {
        return address.isEmpty();
    }

    private boolean isString(Object address) {
        return address instanceof String;
    }


    public String description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description other = (Description) o;
        return description.equals(other.description);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return description.hashCode();
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return description;
    }

}
