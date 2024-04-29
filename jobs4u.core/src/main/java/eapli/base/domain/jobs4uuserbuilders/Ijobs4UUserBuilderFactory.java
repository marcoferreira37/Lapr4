package eapli.base.domain.jobs4uuserbuilders;

/**
 * The interface for the factory of eCourseUser builders.
 * This interface is used to create a new builder for a specific type of eCourseUser.
 */
public interface Ijobs4UUserBuilderFactory {

    /**
     * Creates a new builder for the eCourseUser that is a student
     *
     * @return the builder
     */
    OperatorBuilder createOperatorBuilder();

    /**
     * Creates a new builder for the eCourseUser that is a teacher
     *
     * @return the builder
     */
    CostumerManagerBuilder createCostumerManagerBuilder();

    /**
     * Creates a new builder for the eCourseUser that is a manager
     *
     * @return the builder
     */
    LanguageEngineerBuilder createLanguageEngineerBuilder();

}

