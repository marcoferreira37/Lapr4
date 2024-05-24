package eapli.base.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Phase implements ValueObject {

    @Temporal(TemporalType.DATE)
    @Column(name = "application_date")
    private Date applicationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "screening_date")
    private Date screeningDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "interview_date")
    private Date interviewDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "analysis_date")
    private Date analysisDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "results_date")
    private Date resultsDate;

    public static Phase from(Date applicationDate, Date screeningDate, Date interviewDate, Date analysisDate, Date resultsDate) {
        //TODO Validate business rules
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