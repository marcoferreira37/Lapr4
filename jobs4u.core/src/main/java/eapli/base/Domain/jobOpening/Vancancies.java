package eapli.base.Domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class Vancancies implements ValueObject {
    private double numberOfVacancies;

    public Vancancies(double numberOfVacancies) {
        this.numberOfVacancies = numberOfVacancies;
    }
    public Vancancies() {
    }
    public double numberOfVacancies() {
        return numberOfVacancies;
    }

}
