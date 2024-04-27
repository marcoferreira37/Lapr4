package eapli.base.clientusermanagement.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.util.Objects;


@Embeddable
public class VacanciesNumber implements ValueObject {

    private int number;

    public VacanciesNumber(int number) {
        this.number = number;
    }

    protected VacanciesNumber() {
        // Necessário para JPA
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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