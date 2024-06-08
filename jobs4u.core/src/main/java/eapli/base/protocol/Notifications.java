package eapli.base.protocol;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.Objects;


@Entity
@Table(name = "NOTIFICATIONS")
@Transactional
public class Notifications implements AggregateRoot<Long> {


    @Column(name = "USERNAME")
    String userName;

    @Column(name = "CONTENT")
    String content;

    @Column(name = "ISSEND")
    boolean isSend;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NOTIFICATIONID")
    private long idNotification;

    @JoinColumns({
            @JoinColumn(name = "JOBREFERENCE_COMPANYINDEX", referencedColumnName = "companyIndex"),
            @JoinColumn(name = "JOBREFERENCE_ID", referencedColumnName = "iD"),
            @JoinColumn(name = "JOBREFERENCE_FULLREFERENCE", referencedColumnName = "fullReference"),
    })
    @ManyToOne
    private JobOpening jobOpening;

    @JoinColumn(name = "JOBAPPLICATIONID")
    @ManyToOne
    private JobOpeningApplication jobOpeningApplication;

    public Notifications(String userName, String content) {
        this.userName = userName;
        this.content = content;
        this.jobOpeningApplication = null;
        this.jobOpening = null;
        this.isSend = false;
    }

    protected Notifications() {
        // for ORM only
    }

    public void notificationFromJobOpening(JobOpening jobOpening) {
        this.jobOpening = jobOpening;
    }

    public void notificationFromJobOpeningApplication(JobOpeningApplication jobOpeningApplication) {
        this.jobOpeningApplication = jobOpeningApplication;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (!(other instanceof Notifications)) return false;
        Notifications that = (Notifications) other;
        return Objects.equals(idNotification, that.idNotification);
    }

    public String content() {
        return content;
    }

    @Override
    public Long identity() {
        return idNotification;
    }

    public boolean isSend() {
        return isSend;
    }

    public void settingSend(boolean send) {
        isSend = send;
    }

    public void sendNotification() {
        this.isSend = true;
    }

    public String username(){
        return userName;
    }
}
