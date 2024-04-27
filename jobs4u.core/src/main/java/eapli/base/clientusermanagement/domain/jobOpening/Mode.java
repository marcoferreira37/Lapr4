package eapli.base.clientusermanagement.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Setter
@Getter
@Embeddable
public class Mode implements ValueObject {

    private String modeType;
    private int durationInMonths;


    protected Mode() {
        // Necessário para JPA
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mode mode = (Mode) o;
        return durationInMonths == mode.durationInMonths &&
                Objects.equals(modeType, mode.modeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modeType, durationInMonths);
    }

    @Override
    public String toString() {
        return "Mode{" +
                "modeType='" + modeType + '\'' +
                ", durationInMonths=" + durationInMonths +
                '}';
    }
}
