package eapli.base.domain.jobOpeningProcess;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;

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
        if (applicationDate.before(Date.from(Instant.now()))  || applicationDate.after(screeningDate) || screeningDate.after(interviewDate) || interviewDate.after(analysisDate) || analysisDate.after(resultsDate)) {
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
}