// Generated from C:/Users/Marco/ISEP/2 ano 2 Semestre/sem4pi-23-24-2dh3/jobs4u.plugIn/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/JobRequirementsGrammar.g4 by ANTLR 4.13.1
package eapli.base.domain.PlugIn.JobRequirements.gen;
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
	 * Enter a parse tree produced by the {@code requirement}
	 * labeled alternative in {@link JobRequirementsGrammarParser#requirements}.
	 * @param ctx the parse tree
	 */
	void enterRequirement(JobRequirementsGrammarParser.RequirementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code requirement}
	 * labeled alternative in {@link JobRequirementsGrammarParser#requirements}.
	 * @param ctx the parse tree
	 */
	void exitRequirement(JobRequirementsGrammarParser.RequirementContext ctx);
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
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#academicDegreeRequirement}.
	 * @param ctx the parse tree
	 */
	void enterAcademicDegreeRequirement(JobRequirementsGrammarParser.AcademicDegreeRequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#academicDegreeRequirement}.
	 * @param ctx the parse tree
	 */
	void exitAcademicDegreeRequirement(JobRequirementsGrammarParser.AcademicDegreeRequirementContext ctx);
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
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#programingLanguages}.
	 * @param ctx the parse tree
	 */
	void enterProgramingLanguages(JobRequirementsGrammarParser.ProgramingLanguagesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#programingLanguages}.
	 * @param ctx the parse tree
	 */
	void exitProgramingLanguages(JobRequirementsGrammarParser.ProgramingLanguagesContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#answersType}.
	 * @param ctx the parse tree
	 */
	void enterAnswersType(JobRequirementsGrammarParser.AnswersTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#answersType}.
	 * @param ctx the parse tree
	 */
	void exitAnswersType(JobRequirementsGrammarParser.AnswersTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#trueOrFalseAnswer}.
	 * @param ctx the parse tree
	 */
	void enterTrueOrFalseAnswer(JobRequirementsGrammarParser.TrueOrFalseAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#trueOrFalseAnswer}.
	 * @param ctx the parse tree
	 */
	void exitTrueOrFalseAnswer(JobRequirementsGrammarParser.TrueOrFalseAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#shortAnswerAnswer}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswerAnswer(JobRequirementsGrammarParser.ShortAnswerAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#shortAnswerAnswer}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswerAnswer(JobRequirementsGrammarParser.ShortAnswerAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#academicDegreeAnswer}.
	 * @param ctx the parse tree
	 */
	void enterAcademicDegreeAnswer(JobRequirementsGrammarParser.AcademicDegreeAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#academicDegreeAnswer}.
	 * @param ctx the parse tree
	 */
	void exitAcademicDegreeAnswer(JobRequirementsGrammarParser.AcademicDegreeAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#languagesAnswer}.
	 * @param ctx the parse tree
	 */
	void enterLanguagesAnswer(JobRequirementsGrammarParser.LanguagesAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#languagesAnswer}.
	 * @param ctx the parse tree
	 */
	void exitLanguagesAnswer(JobRequirementsGrammarParser.LanguagesAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#integerAnswer}.
	 * @param ctx the parse tree
	 */
	void enterIntegerAnswer(JobRequirementsGrammarParser.IntegerAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#integerAnswer}.
	 * @param ctx the parse tree
	 */
	void exitIntegerAnswer(JobRequirementsGrammarParser.IntegerAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JobRequirementsGrammarParser#languages}.
	 * @param ctx the parse tree
	 */
	void enterLanguages(JobRequirementsGrammarParser.LanguagesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JobRequirementsGrammarParser#languages}.
	 * @param ctx the parse tree
	 */
	void exitLanguages(JobRequirementsGrammarParser.LanguagesContext ctx);
}