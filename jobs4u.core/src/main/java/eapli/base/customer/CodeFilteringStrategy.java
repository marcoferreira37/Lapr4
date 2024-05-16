package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CodeFilteringStrategy implements JobOpeningFilteringStrategy {

    @Override
    public String description() {
        // Método que retorna uma descrição do critério de filtragem.
        return "Filter by Code"; // Retorna uma descrição indicando que as vagas estão sendo filtradas por código.
    }

    @Override
    public List<Criteria<?>> criteria() {
        // Método que retorna uma lista de critérios de filtragem.
        return new ArrayList<>() {{
            // Inicializa uma nova lista de critérios utilizando uma expressão de inicialização de instância.
            add(new Criteria<>("Code", String.class)); // Adiciona um critério à lista representando o código da vaga.
        }};
    }

    @Override
    public Predicate<JobOpening> filter(List<Criteria<?>> criteria) {
        // Método que retorna um predicado para filtragem de vagas com base nos critérios fornecidos.
        return jobOpening -> jobOpening.hasReference((String) criteria.get(0).value());
        // Retorna um predicado que verifica se a vaga possui uma referência (código) correspondente ao critério fornecido.
        // O critério fornecido é acessado a partir da lista de critérios passada como parâmetro.
        // O valor do critério é convertido para String, pois o critério representa o código da vaga.
        // jobOpening.hasReference verifica se a vaga possui o código correspondente.
    }
}
