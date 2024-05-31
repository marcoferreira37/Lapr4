package eapli.base.domain.jobOpeningInterview;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.framework.domain.model.AggregateRoot;
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

    public JobInterview(String interviewTime, Calendar interviewDate, JobOpeningApplication jobOpeningApplication) {
        this.interviewTime = interviewTime;
        this.interviewDate = interviewDate;
        this.jobOpeningApplication = jobOpeningApplication;

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
        return "JobInterview { " +
               "id=" + id +
               ", jobOpeningApplication=" + jobOpeningApplication +
               ", interviewTime='" + interviewTime + '\'' +
               ", interviewDate=" + interviewDate +
               ", grade=" + grade +
               '}';
    }

    public void gradeInterview(int grade) {
        if (grade < 0 || grade > 20) {
            throw new IllegalArgumentException("Grade must be between 0 and 20");
        }
        this.grade = grade;
    }
}
