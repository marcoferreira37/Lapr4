package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface JobOpeningFilteringStrategy {
    // Interface que representa uma estratégia de filtragem de job openings.
    String description();
    // Método que retorna uma descrição do critério de filtragem.
    List<Criteria<?>> criteria();
    // Método que retorna uma lista de critérios de filtragem.
    Predicate<JobOpening> filter(List<Criteria<?>> criteria);
}
