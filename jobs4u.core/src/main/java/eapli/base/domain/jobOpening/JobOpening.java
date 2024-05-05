package eapli.base.domain.jobOpening;

import eapli.base.domain.company.Company;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.CurrentTimeCalendars;
import jakarta.persistence.*;
import lombok.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Calendar;

@Table(name = "JOB_OPENING")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Builder // CRIAR UMA CLASS BUILDER ( nao é um builder pattern )
public class JobOpening implements AggregateRoot<JobReference> {

    @ToString.Include
    @EmbeddedId
    @Column(name = "JOB_REFERENCE", nullable = false)
    private JobReference jobReference;

    @ToString.Include
    @Embedded
    private Description description;

    @ToString.Include
    @Embedded
    private Address address;

    @ToString.Include
    @Column(name = "MODE")
    @Enumerated(EnumType.STRING)
    private Mode mode;

    @ToString.Include
    @Column(name = "CONTRACTTYPE")
    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @ToString.Include
    @Embedded
    private TitleOrFunction titleOrFunction;

    @ToString.Include
    @Embedded
    private VacanciesNumber vacanciesNumber;

    @ManyToOne
    @JoinColumn(name = "COMPANY")
    private Company company;

    @JoinColumn(name = "Phase")
    @Embedded
    private Phase phaseDates;


    @Column (name = "CREATION_DATE")
    private Calendar creationDate;

    @Getter
    String interviewModel;


    public JobOpening(JobReference jobReference, Description description, Address address, Mode mode, ContractType contractType, TitleOrFunction titleOrFunction, VacanciesNumber vacanciesNumber, Company company, Phase phaseDates) {
        this.jobReference = jobReference;
        this.description = description;
        this.address = address;
        this.mode = mode;
        this.contractType = contractType;
        this.titleOrFunction = titleOrFunction;
        this.vacanciesNumber = vacanciesNumber;
        this.company = company;
        this.phaseDates = phaseDates;
        this.creationDate = CurrentTimeCalendars.now();
    }

    public JobOpening() {

    }


    @Override
    public boolean sameAs(Object other) {
        return other instanceof JobOpening && ((JobOpening) other).identity().equals(identity());
    }

    @Override
    public JobReference identity() {
        return jobReference;
    }

    /**
     * Verifies if the job opening is between the initial and final date
     *
     * @param initialDate initial date
     * @param finalDate   final date
     * @return true if the job opening is between the initial and final date;
     * false otherwise.
     * FIXME: This method is not properly implemented
     */
    public boolean isBetween(LocalDateTime initialDate, LocalDateTime finalDate) {
        return true;
    }

    public boolean hasNameOrReference(String nameOrReference) {
        return description.description().equals(nameOrReference)
                || jobReference.toString().equals(nameOrReference);
    }

    @Override
    public String toString() {
        return "\n-----------------------------------------------------" +
                "\n////// Job Opening //////" +
                "\n" +
                "\nJob Reference = " + jobReference +
                "\nDescription = " + description +
                "\nAddress = " + address +
                "\nMode = " + mode +
                "\nContractType = " + contractType +
                "\nTitle Or Function = " + titleOrFunction +
                "\nVacancies Number = " + vacanciesNumber +
                "\nPhase Dates = " + phaseDates +
                "\nCompany = " + company;

    }

}

