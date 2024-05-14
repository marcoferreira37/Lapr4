package eapli.base.domain.jobOpening;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
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
}