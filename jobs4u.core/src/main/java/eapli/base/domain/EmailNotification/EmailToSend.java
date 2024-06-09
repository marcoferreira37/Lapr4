package eapli.base.domain.EmailNotification;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.EmailAddress;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class EmailToSend implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private EmailAddress email;
    @Lob
    private char[] content;
    private boolean sent;

    public EmailToSend(EmailAddress email, String content) {
        this.email = email;
        this.content = content.toCharArray();
        this.sent = false;
    }

    protected EmailToSend() {
    }

    public EmailAddress email() {
        return this.email;
    }
    public char[] content() {
        return this.content;
    }
    public boolean sent() {
        return this.sent;
    }
    public void updateEmail(EmailAddress email) {
        this.email = email;
    }
    public void updateContent(String content) {
        this.content = content.toCharArray();
    }
    public void markAsSent() {
        this.sent = true;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
