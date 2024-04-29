package eapli.base.domain.candidate;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.EmbeddedId;

public class CandidateName implements ValueObject {
    @EmbeddedId
    private String candidateName;

    public CandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String candidateName() {
        return candidateName;
    }
}
