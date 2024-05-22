package eapli.base.domain.jobOpening;

import eapli.base.domain.JobOpeningProcess.PhaseType;
import eapli.base.domain.company.Company;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "COMPANY")
    private Company company;

    @JoinColumn(name = "Phase")
    @Embedded
    private Phase phaseDates;


    @Column(name = "CREATION_DATE")
    private Calendar creationDate;

    @Column(name = "Interview")
    String interviewModel;

    @Column(name = "Requirements")
    String requirements;

    @Column(name = "Current Job Phase")
    @Enumerated(value = EnumType.STRING)

    PhaseType currentJobPhase;

    public JobOpening() {

    }

    public JobOpening(JobReference jobReference) {
        this.jobReference = jobReference;
    }

    public JobOpening(JobReference jobReference, Description description, Address address, Mode mode, ContractType contractType, TitleOrFunction titleOrFunction, VacanciesNumber vacanciesNumber, Company company, Phase phaseDates, Calendar creationDate, String interviewModel, String requirements) {
        this.jobReference = jobReference;
        this.description = description;
        this.address = address;
        this.mode = mode;
        this.contractType = contractType;
        this.titleOrFunction = titleOrFunction;
        this.vacanciesNumber = vacanciesNumber;
        this.company = company;
        this.phaseDates = phaseDates;
        this.creationDate = creationDate;
        this.interviewModel = interviewModel;
        this.requirements = requirements;
        this.currentJobPhase = PhaseType.APPLICATION;
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
        if (initialDate == null || finalDate == null) {
            throw new IllegalArgumentException("The dates should not be null");
        }
        return finalDate.isAfter(initialDate) && creationDate.after(initialDate) && creationDate.before(finalDate);
    }

    public boolean hasNameOrReference(String nameOrReference) {
        return description.description().equals(nameOrReference)
               || jobReference.toString().equals(nameOrReference);
    }

    public boolean hasReference(String value) {
        return jobReference.fullReference().equals(value);
    }

    public boolean hasDescription(String description) {
        return this.description.description().equals(description);
    }


    public void advanceToNextPhase(boolean interviewPhase) {
        currentJobPhase = currentJobPhase.nextPhase(interviewPhase);
    }

    public void goBackToPreviousPhase(boolean interviewPhase) {
        currentJobPhase = currentJobPhase.previousPhase(interviewPhase);
    }

    @Override
    public String toString() {
        String result = "\n-----------------------------------------------------" +
                        "\n////// Job Opening //////" +
                        "\n" +
                        "\nJob Reference = " + jobReference.fullReference() +
                        "\nDescription = " + description +
                        "\nAddress = " + address +
                        "\nMode = " + mode +
                        "\nContractType = " + contractType +
                        "\nTitle Or Function = " + titleOrFunction.titleOrFunction() +
                        "\nVacancies Number = " + vacanciesNumber.getNumber() +
                        "\nCompany Name: " + company.getCompanyName().toString();
        if (creationDate != null) {
            result += "\nCreation Date = " + creationDate.getTime();
        }
        if (phaseDates != null) {
            result += "\nPhase Dates = " + phaseDates;
        }


        return result;
    }
}

