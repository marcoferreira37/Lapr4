package eapli.base.notifications;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.protocol.Notifications;
import eapli.framework.domain.model.DomainFactory;
import jakarta.persistence.*;



public class NotificationBuilder implements DomainFactory<Notifications> {
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

    public NotificationBuilder() {
    }
    public NotificationBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public NotificationBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    public NotificationBuilder withIsSend(boolean isSend) {
        this.isSend = isSend;
        return this;
    }

    public NotificationBuilder withNotificationId(long idNotification){
        this.idNotification = idNotification;
        return this;
    }
    @Override
    public Notifications build() {
        return new Notifications(this.userName, this.content);
    }

}
