// Generated from C:/Users/leono/IdeaProjects/sem3pi2023/sem3pi2023/sem4pi-23-24-2dh3/jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/JobRequirementsGrammar.g4 by ANTLR 4.13.1
package eapli.base.domain.PlugIn.JobRequirements.genClasses;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JobRequirementsGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JobRequirementsGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(JobRequirementsGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(JobRequirementsGrammarParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#requirements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirements(JobRequirementsGrammarParser.RequirementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#requirementType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirementType(JobRequirementsGrammarParser.RequirementTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#trueOrFalseRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueOrFalseRequirement(JobRequirementsGrammarParser.TrueOrFalseRequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#shortAnswerRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerRequirement(JobRequirementsGrammarParser.ShortAnswerRequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#integerRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerRequirement(JobRequirementsGrammarParser.IntegerRequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#correctAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorrectAnswer(JobRequirementsGrammarParser.CorrectAnswerContext ctx);
}