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
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description should neither be null nor empty");
        }
        this.description = description;
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

    @Override
    public int hashCode() {
        return description.hashCode();
    }

    @Override
    public String toString() {
        return description;
    }

}
