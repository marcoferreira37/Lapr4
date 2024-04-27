package eapli.base.clientusermanagement.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.util.Objects;


@Embeddable
public class Mode implements ValueObject {

    private String modeType;
    private int durationInMonths;

    public Mode(String modeType, int durationInMonths) {
        this.modeType = modeType;
        this.durationInMonths = durationInMonths;
    }

    protected Mode() {
        // Necessário para JPA
    }

    public String getModeType() {
        return modeType;
    }

    public void setModeType(String modeType) {
        this.modeType = modeType;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
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
