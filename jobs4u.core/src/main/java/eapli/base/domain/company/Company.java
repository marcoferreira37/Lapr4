package eapli.base.domain.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Company {
    @Id
    private Long id;
    private CompanyName companyName;

    public Long Id() {
        return id;
    }
}
