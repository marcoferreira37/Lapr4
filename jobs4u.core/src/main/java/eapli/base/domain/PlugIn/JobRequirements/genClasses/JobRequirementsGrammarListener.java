// Generated from C:/Users/leono/IdeaProjects/sem3pi2023/sem3pi2023/sem4pi-23-24-2dh3/jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/JobRequirementsGrammar.g4 by ANTLR 4.13.1
package eapli.base.domain.PlugIn.JobRequirements.genClasses;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JobRequirementsGrammarParser}.
 */
public interface JobRequirementsGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(JobRequirementsGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(JobRequirementsGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(JobRequirementsGrammarParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(JobRequirementsGrammarParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#requirements}.
	 * @param ctx the parse tree
	 */
	void enterRequirements(JobRequirementsGrammarParser.RequirementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#requirements}.
	 * @param ctx the parse tree
	 */
	void exitRequirements(JobRequirementsGrammarParser.RequirementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#requirementType}.
	 * @param ctx the parse tree
	 */
	void enterRequirementType(JobRequirementsGrammarParser.RequirementTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#requirementType}.
	 * @param ctx the parse tree
	 */
	void exitRequirementType(JobRequirementsGrammarParser.RequirementTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#trueOrFalseRequirement}.
	 * @param ctx the parse tree
	 */
	void enterTrueOrFalseRequirement(JobRequirementsGrammarParser.TrueOrFalseRequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#trueOrFalseRequirement}.
	 * @param ctx the parse tree
	 */
	void exitTrueOrFalseRequirement(JobRequirementsGrammarParser.TrueOrFalseRequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#shortAnswerRequirement}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswerRequirement(JobRequirementsGrammarParser.ShortAnswerRequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#shortAnswerRequirement}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswerRequirement(JobRequirementsGrammarParser.ShortAnswerRequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#integerRequirement}.
	 * @param ctx the parse tree
	 */
	void enterIntegerRequirement(JobRequirementsGrammarParser.IntegerRequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#integerRequirement}.
	 * @param ctx the parse tree
	 */
	void exitIntegerRequirement(JobRequirementsGrammarParser.IntegerRequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#correctAnswer}.
	 * @param ctx the parse tree
	 */
	void enterCorrectAnswer(JobRequirementsGrammarParser.CorrectAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#correctAnswer}.
	 * @param ctx the parse tree
	 */
	void exitCorrectAnswer(JobRequirementsGrammarParser.CorrectAnswerContext ctx);
}