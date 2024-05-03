package eapli.base.domain.jobOpening;

import eapli.base.domain.company.Company;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.NotImplementedException;

import java.time.LocalDateTime;

@Table(name = "JOB_OPENING")
@Entity
@Getter
@ToString(onlyExplicitlyIncluded = true)
@Builder // CRIAR UMA CLASS BUILDER ( nao é um builder pattern )
@AllArgsConstructor
@NoArgsConstructor
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
    @Column (name = "MODE")
    @Enumerated(EnumType.STRING)
    private Mode mode;

    @ToString.Include
    @Column (name = "CONTRACTTYPE")
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
     * @param finalDate final date
     *
     * @return
     * true if the job opening is between the initial and final date;
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
        return "\n-----------------------------------------------------"+
                "\n////// Job Opening //////" +
                "\n" +
                "\nJob Reference = " + jobReference +
                "\nDescription = " + description +
                "\nAddress = " + address +
                "\nMode = " + mode +
                "\nContractType = " + contractType +
                "\nTitle Or Function = " + titleOrFunction +
                "\nVacancies Number = " + vacanciesNumber +
                "\nCompany = " + company ;

    }
}
