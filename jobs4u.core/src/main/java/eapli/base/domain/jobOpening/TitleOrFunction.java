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
        validateTitleOrFunction(titleOrFunction);
        this.titleOrFunction = titleOrFunction;
    }

    private void validateTitleOrFunction(String titleOrFunction) {
        if (isNull(titleOrFunction)) {
            throw new IllegalArgumentException("Title or Function cannot be null");
        }
        if (isEmpty(titleOrFunction)) {
            throw new IllegalArgumentException("Title or Function cannot be empty");
        }
        if (!isString(titleOrFunction)) {
            throw new IllegalArgumentException("Title or Function must be a string");
        }
    }

    private boolean isNull(String titleOrFunction) {
        return titleOrFunction == null;
    }

    private boolean isEmpty(String titleOrFunction) {
        return titleOrFunction.isEmpty();
    }

    private boolean isString(Object titleOrFunction) {
        return titleOrFunction instanceof String;
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

