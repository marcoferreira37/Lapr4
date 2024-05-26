package eapli.base.domain.jobOpeningInterview;

import eapli.base.domain.candidate.Candidate;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;

import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "JobInterview")
@Transactional
public class JobInterview implements AggregateRoot<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INTERVIEWID")
    private long id;
    @ManyToOne
    @JoinColumn(name = "CANDIDATEID")
    private Candidate candidate;

    @Getter
    @Column(name = "INTERVIEWTIME")
    private String interviewTime;

    @Column(name = "INTERVIEWDATE")
    private final Calendar interviewDate;

    public JobInterview(String interviewTime, Calendar interviewDate, Candidate candidate) {
        this.interviewTime = interviewTime;
        this.interviewDate = interviewDate;
        this.candidate = candidate;

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
                Objects.equals(candidate, that.candidate) &&
                Objects.equals(interviewTime, that.interviewTime) &&
                Objects.equals(interviewDate, that.interviewDate);
    }

    @Override
    public Long identity() {
        return null;
    }

    public Candidate candidate() {
        return this.candidate;
    }

    public Calendar interviewDate() {
        return this.interviewDate;
    }

    public String interviewTime() {
        return this.interviewTime;
    }

    @Override
    public String toString() {
        return "JobInterview{" +
                "id=" + id +
                ", candidate=" + candidate +
                ", interviewTime='" + interviewTime + '\'' +
                ", interviewDate=" + interviewDate +
                '}';
    }


}
