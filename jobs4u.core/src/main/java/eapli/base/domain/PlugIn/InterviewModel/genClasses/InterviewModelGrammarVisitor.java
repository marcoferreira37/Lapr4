// Generated from C:/Users/leono/IdeaProjects/sem3pi2023/sem3pi2023/sem4pi-23-24-2dh3/jobs4u.core/src/main/resources/PlugIns/interviewModel/InterviewModelGrammar.g4 by ANTLR 4.13.1
package eapli.base.domain.PlugIn.InterviewModel.genClasses;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterviewModelGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterviewModelGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InterviewModelGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(InterviewModelGrammarParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#interviewModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterviewModel(InterviewModelGrammarParser.InterviewModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#interview}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterview(InterviewModelGrammarParser.InterviewContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(InterviewModelGrammarParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(InterviewModelGrammarParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(InterviewModelGrammarParser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#trueOrFalseQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueOrFalseQuestion(InterviewModelGrammarParser.TrueOrFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#singleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleChoiceQuestion(InterviewModelGrammarParser.SingleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerQuestion(InterviewModelGrammarParser.ShortAnswerQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(InterviewModelGrammarParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#integerQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerQuestion(InterviewModelGrammarParser.IntegerQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#decimalQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalQuestion(InterviewModelGrammarParser.DecimalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#dateQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateQuestion(InterviewModelGrammarParser.DateQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#timeQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeQuestion(InterviewModelGrammarParser.TimeQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#scaleQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScaleQuestion(InterviewModelGrammarParser.ScaleQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#correctAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorrectAnswer(InterviewModelGrammarParser.CorrectAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#questionAnswers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionAnswers(InterviewModelGrammarParser.QuestionAnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#questionPoints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionPoints(InterviewModelGrammarParser.QuestionPointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#footer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFooter(InterviewModelGrammarParser.FooterContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#score_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScore_definition(InterviewModelGrammarParser.Score_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterviewModelGrammarParser#outstandingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutstandingClause(InterviewModelGrammarParser.OutstandingClauseContext ctx);
}