package eapli.base.clientusermanagement.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Setter
@Getter
@Embeddable
public class VacanciesNumber implements ValueObject {

    private int number;

    protected VacanciesNumber() {
        // Necessário para JPA
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacanciesNumber that = (VacanciesNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "VacanciesNumber{" +
                "number=" + number +
                '}';

    }
}