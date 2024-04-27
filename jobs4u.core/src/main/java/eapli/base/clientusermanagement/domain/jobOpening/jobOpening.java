package eapli.base.clientusermanagement.domain.jobOpening;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "JOB_OPENING")

public class jobOpening implements AggregateRoot<JobReference> {

    @Id
    private Long id;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public JobReference identity() {
        return null;
    }

}
