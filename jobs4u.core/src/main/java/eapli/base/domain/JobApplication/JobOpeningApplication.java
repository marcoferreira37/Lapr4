package eapli.base.domain.JobApplication;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

@Entity
@Table(name = "JobOpeningApplication")
@Transactional
public class JobOpeningApplication implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPLICATIONID")
    private Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "JOBREFERENCE_COMPANYINDEX", referencedColumnName = "companyIndex"),
            @JoinColumn(name = "JOBREFERENCE_ID", referencedColumnName = "iD"),
            @JoinColumn(name = "JOBREFERENCE_FULLREFERENCE", referencedColumnName = "fullReference"),
    })
    public JobOpening jobOpening;

    @ManyToOne
    @JoinColumn(name = "CANDIDATEID")
    private Candidate candidate;

    @Column(name = "ATTACHEDEMAIL")
    private String attachedEmail;

    @Column(name = "APPLICATIONDATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar applicationData;

    @Column(name = "APPLICATIONSTATUS")
    private String applicationStatus;

    @Column(name = "JOBREFERENCE", insertable = false, updatable = false)
    private String jobReference;

    @Column(name = "APPLICATION_ID")  // Renomeado para evitar duplicação
    private int applicationId;
    public JobOpeningApplication() {
        // Construtor vazio necessário para JPA
    }

    public JobOpeningApplication(JobOpening j, Candidate c) {
        this.jobOpening = j;
        this.candidate = c;
    }

    public JobOpeningApplication(String attachedEmail, Calendar applicationData, String applicationStatus, int applicationID, JobOpening jobOpening, String jobReference) {
        this.attachedEmail = attachedEmail;
        this.applicationData = applicationData;
        this.applicationStatus = applicationStatus;
        this.applicationId = applicationID;
        this.jobOpening = jobOpening;
        this.jobReference = jobReference;
    }

    @Override
    public String toString() {
        return "JobOpeningApplication{" +
                "id=" + id +
                ", jobOpening=" + jobOpening +
                ", candidate=" + candidate +
                ", attachedEmail='" + attachedEmail + '\'' +
                ", applicationData=" + applicationData +
                ", applicationStatus='" + applicationStatus + '\'' +
                ", applicationID=" + applicationId +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        JobOpeningApplication that = (JobOpeningApplication) other;
        return applicationId == that.applicationId;
    }

    @Override
    public Long identity() {
        return id;
    }

    public JobOpening jobOpening() {
        return jobOpening;
    }

    public Candidate candidate() {
        return candidate;
    }

    public static JobOpeningApplication readFile(String nomeFicheiro, JobOpening jobOpening) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFicheiro))) {
            String jobReference = reader.readLine();
            String attachedEmail = reader.readLine();
            Calendar applicationData = Calendar.getInstance();
            String applicationStatus = "Accepted";
            int applicationID = 1; // ID fictício para exemplo

            if (attachedEmail == null) {
                throw new IOException("ERROR: Ficheiro mal formatado");
            }
            System.out.println("Informações lidas do ficheiro:");
            System.out.println("Email: " + attachedEmail);
            System.out.println("applicationData: " + applicationData);
            System.out.println("applicationStatus: " + applicationStatus);
            System.out.println("applicationID: " + applicationID);

            return new JobOpeningApplication(attachedEmail, applicationData, applicationStatus, applicationID, jobOpening, jobReference);
        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
            return null;
        }
    }
}
