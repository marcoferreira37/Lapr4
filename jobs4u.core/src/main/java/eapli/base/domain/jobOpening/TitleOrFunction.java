package eapli.base.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Embeddable
public class TitleOrFunction implements ValueObject {

    private String titleOrFunction;


    protected TitleOrFunction() {
        // Necessário para JPA
    }

    public TitleOrFunction(String titleOrFunction) {
        if (titleOrFunction == null || titleOrFunction.isEmpty() || titleOrFunction.isBlank()) {
            throw new IllegalArgumentException("Title or Function should neither be null nor empty");
        }
        this.titleOrFunction = titleOrFunction;
    }

    public String titleOrFunction() {
        return titleOrFunction;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleOrFunction that = (TitleOrFunction) o;
        return Objects.equals(titleOrFunction, that.titleOrFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOrFunction);
    }

    @Override
    public String toString() {
        return "TitleOrFunction{" +
                "titleOrFunction='" + titleOrFunction + '\'' +
                '}';
    }
}

