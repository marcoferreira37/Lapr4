package eapli.base.domain.jobOpeningInterview;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.utils.Validations;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;

import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "JobInterview")
@Transactional
public class JobInterview implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INTERVIEWID")
    private long id;

    @Getter
    @Column(name = "INTERVIEWTIME")
    private String interviewTime;

    @Column(name = "INTERVIEWDATE")
    private final Calendar interviewDate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    // OneToOne porque um JobInterview só pode ter uma JobOpeningApplication
    @JoinColumn(name = "JOBOPENINGAPPLICATIONID")
    private JobOpeningApplication jobOpeningApplication;

    @Column(name = "JOBINTERVIEWGRADE")
    private int grade;

    @Column(name = "INTERVIEWANSWERS")
    private String interviewAnswers;

    public JobInterview(String interviewTime, Calendar interviewDate, JobOpeningApplication jobOpeningApplication) {

        validateInterviewTime(interviewTime);
        validateInterviewTimeNotNull(interviewTime);

        validateInterviewDate(interviewDate);

        validateJobOpeningApplication(jobOpeningApplication);

        this.interviewTime = interviewTime;
        this.interviewDate = interviewDate;
        this.jobOpeningApplication = jobOpeningApplication;
        this.grade = -1;
        this.interviewAnswers = null;

    }

    public void validateJobOpeningApplication(JobOpeningApplication jobOpeningApplication) {
        if (jobOpeningApplication == null) {
            throw new IllegalArgumentException("Job Opening Application must not be null");
        }

    }

    public void validateInterviewDate(Calendar interviewDate) {
        if (interviewDate.before(Calendar.getInstance())) {
            throw new IllegalArgumentException("Interview Date must not be in the past");
        }

    }

    public void validateInterviewTime(String interviewTime) {
        Preconditions.nonEmpty(interviewTime, "Interview Time must not be null");
    }

    public void validateInterviewTimeNotNull(String interviewTime) {
        if (interviewTime == null) {
            throw new IllegalArgumentException("Interview Time must not be null");
        }

    }


    public JobInterview(String interviewTime, Calendar interviewDate, JobOpeningApplication jobOpeningApplication, int grade) {
        this.interviewTime = interviewTime;
        this.interviewDate = interviewDate;
        this.jobOpeningApplication = jobOpeningApplication;
        this.grade = grade;
    }

    // Construtor sem argumentos exigido pelo JPA
    protected JobInterview() {
        this.interviewDate = null;
    }

    public JobInterview jobInterview() {
        return jobInterview();
    }



    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        JobInterview that = (JobInterview) other;
        return Objects.equals(id, that.id) &&
                Objects.equals(jobOpeningApplication, that.jobOpeningApplication) &&
                Objects.equals(interviewTime, that.interviewTime) &&
                Objects.equals(interviewDate, that.interviewDate);
    }

    @Override
    public Long identity() {
        return null;
    }

    public JobOpeningApplication jobOpeningApplication() {
        return this.jobOpeningApplication;
    }

    public Calendar interviewDate() {
        return this.interviewDate;
    }

    public String interviewTime() {
        return this.interviewTime;
    }

    public int grade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return "----- JobInterview -----" +
                "\nid= " + id +
                "\njobOpeningApplication= " + jobOpeningApplication +
                "\ninterviewTime= " + interviewTime + '\'' +
                "\ninterviewDate= " + interviewDate +
                "\ngrade= " + grade;
    }

    public void gradeInterview(int grade) {
        if (grade < 0 || grade > 20) {
            throw new IllegalArgumentException("Grade must be between 0 and 20");
        }
        this.grade = grade;
    }

    public String toStringWithoutGrade() {
        return "----- JobInterview -----" +
                "\nid= " + id +
                "\njobOpeningApplication= " + jobOpeningApplication +
                "\ninterviewTime= " + interviewTime + '\'' +
                "\ninterviewDate= " + interviewDate;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String interviewAnswers() {
        return interviewAnswers;
    }

    public void setInterviewAnswers(String interviewAnswers) {
        this.interviewAnswers = interviewAnswers;
    }
}
