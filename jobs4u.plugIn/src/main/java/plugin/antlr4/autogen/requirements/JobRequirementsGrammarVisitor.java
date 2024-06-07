// Generated from C:/Users/Utilizador/IdeaProjects/sem4pi-23-24-2dh3/jobs4u.plugIn/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/JobRequirementsGrammar.g4 by ANTLR 4.13.1
package plugin.antlr4.autogen.requirements;
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
	 * Visit a parse tree produced by the {@code requirement}
	 * labeled alternative in {@link JobRequirementsGrammarParser#requirements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(JobRequirementsGrammarParser.RequirementContext ctx);
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
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#academicDegreeRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcademicDegreeRequirement(JobRequirementsGrammarParser.AcademicDegreeRequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#shortAnswerRequirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerRequirement(JobRequirementsGrammarParser.ShortAnswerRequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#programingLanguages}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramingLanguages(JobRequirementsGrammarParser.ProgramingLanguagesContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#answersType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswersType(JobRequirementsGrammarParser.AnswersTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#trueOrFalseAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueOrFalseAnswer(JobRequirementsGrammarParser.TrueOrFalseAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#shortAnswerAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerAnswer(JobRequirementsGrammarParser.ShortAnswerAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#academicDegreeAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcademicDegreeAnswer(JobRequirementsGrammarParser.AcademicDegreeAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#languagesAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguagesAnswer(JobRequirementsGrammarParser.LanguagesAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#integerAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerAnswer(JobRequirementsGrammarParser.IntegerAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JobRequirementsGrammarParser#languages}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguages(JobRequirementsGrammarParser.LanguagesContext ctx);
}