package eapli.base.domain.candidate;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class CandidateId implements ValueObject, Comparable<CandidateId> {
    @Id
    private long candidateId;
    protected CandidateId() {
    }
    public CandidateId(long candidateId) {
        this.candidateId = candidateId;
    }
    public long candidateId() {
        return candidateId;
    }

    @Override
    public int compareTo(CandidateId o) {
        return Long.compare(candidateId, o.candidateId);
    }
}
