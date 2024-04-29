package eapli.base.clientusermanagement.domain.jobs4uuserbuilders;

import eapli.base.infrastructure.persistence.PersistenceContext;

public class Jobs4UUserBuilderFactory implements Ijobs4UUserBuilderFactory {

        @Override
        public OperatorBuilder createOperatorBuilder() {
            return new OperatorBuilder();
        }

        @Override
        public CostumerManagerBuilder createCostumerManagerBuilder() {
            return new CostumerManagerBuilder();
        }

        @Override
        public LanguageEngineerBuilder createLanguageEngineerBuilder() {
            return new LanguageEngineerBuilder();
        }
}

