package eapli.base.domain.company;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
public class CompanyName implements ValueObject {
    private String companyName;

    public CompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyName() {
    }

    public String companyName() {
        return companyName;
    }
}
