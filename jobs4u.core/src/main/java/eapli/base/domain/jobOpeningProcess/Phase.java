package eapli.base.domain.jobOpeningProcess;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Phase implements ValueObject {


    @Column(name = "application_date")
    private Date applicationDate;


    @Column(name = "screening_date")
    private Date screeningDate;


    @Column(name = "interview_date")
    private Date interviewDate;


    @Column(name = "analysis_date")
    private Date analysisDate;


    @Column(name = "results_date")
    private Date resultsDate;

    public static Phase from(Date applicationDate, Date screeningDate, Date interviewDate, Date analysisDate, Date resultsDate) {
        if (applicationDate.before(Date.from(Instant.now()))) {
            throw new IllegalArgumentException("The application cannot be before today's date");
        }
        if (!applicationDate.before(screeningDate) || !screeningDate.before(interviewDate) || !interviewDate.before(analysisDate) || !analysisDate.before(resultsDate)) {
            throw new IllegalArgumentException("The dates must be in the correct order");
        }
        return new Phase(applicationDate, screeningDate, interviewDate, analysisDate, resultsDate);
    }

    @Override
    public String toString() {
        return
                " Application Date=" + applicationDate +
                "| Screening Date=" + screeningDate +
                "| Interview Date=" + interviewDate +
                "| Analysis Date=" + analysisDate +
                "| Results Date=" + resultsDate
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phase phase = (Phase) o;
        return Objects.equals(applicationDate, phase.applicationDate) && Objects.equals(screeningDate, phase.screeningDate) && Objects.equals(interviewDate, phase.interviewDate) && Objects.equals(analysisDate, phase.analysisDate) && Objects.equals(resultsDate, phase.resultsDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationDate, screeningDate, interviewDate, analysisDate, resultsDate);
    }
}