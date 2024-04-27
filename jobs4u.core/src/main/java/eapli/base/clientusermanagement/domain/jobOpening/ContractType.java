package eapli.base.clientusermanagement.domain.jobOpening;


import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContractType implements ValueObject {

    private String contractType;

    public ContractType(String contractType) {
        this.contractType = contractType;
    }

    protected ContractType() {
        // Necessário para JPA
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractType other = (ContractType) o;
        return contractType.equals(other.contractType);
    }

    @Override
    public int hashCode() {
        return contractType.hashCode();
    }

    @Override
    public String toString() {
        return contractType;
    }
}
