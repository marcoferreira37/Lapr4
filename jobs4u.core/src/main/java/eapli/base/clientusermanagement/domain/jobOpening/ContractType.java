package eapli.base.clientusermanagement.domain.jobOpening;


import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContractType implements ValueObject {

    private String contractType;

    public ContractType(String contractType) {
        this.contractType = contractType;
    }

    public ContractType() {

    }
}
