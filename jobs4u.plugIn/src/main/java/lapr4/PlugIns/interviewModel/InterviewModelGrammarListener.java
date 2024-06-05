// Generated from C:/Users/Utilizador/Desktop/sem4pi-23-24-2dh3/sem4pi-23-24-2dh3/jobs4u.plugIn/src/main/resources/PlugIns/interviewModel/InterviewModelGrammar.g4 by ANTLR 4.13.1
package lapr4.PlugIns.interviewModel;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterviewModelGrammarParser}.
 */
public interface InterviewModelGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(InterviewModelGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(InterviewModelGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(InterviewModelGrammarParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(InterviewModelGrammarParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code evaluation}
	 * labeled alternative in {@link InterviewModelGrammarParser#interview}.
	 * @param ctx the parse tree
	 */
	void enterEvaluation(InterviewModelGrammarParser.EvaluationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code evaluation}
	 * labeled alternative in {@link InterviewModelGrammarParser#interview}.
	 * @param ctx the parse tree
	 */
	void exitEvaluation(InterviewModelGrammarParser.EvaluationContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(InterviewModelGrammarParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(InterviewModelGrammarParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(InterviewModelGrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(InterviewModelGrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(InterviewModelGrammarParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(InterviewModelGrammarParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#trueOrFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void enterTrueOrFalseQuestion(InterviewModelGrammarParser.TrueOrFalseQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#trueOrFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void exitTrueOrFalseQuestion(InterviewModelGrammarParser.TrueOrFalseQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#singleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSingleChoiceQuestion(InterviewModelGrammarParser.SingleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#singleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSingleChoiceQuestion(InterviewModelGrammarParser.SingleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswerQuestion(InterviewModelGrammarParser.ShortAnswerQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswerQuestion(InterviewModelGrammarParser.ShortAnswerQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoiceQuestion(InterviewModelGrammarParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoiceQuestion(InterviewModelGrammarParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#integerQuestion}.
	 * @param ctx the parse tree
	 */
	void enterIntegerQuestion(InterviewModelGrammarParser.IntegerQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#integerQuestion}.
	 * @param ctx the parse tree
	 */
	void exitIntegerQuestion(InterviewModelGrammarParser.IntegerQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#decimalQuestion}.
	 * @param ctx the parse tree
	 */
	void enterDecimalQuestion(InterviewModelGrammarParser.DecimalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#decimalQuestion}.
	 * @param ctx the parse tree
	 */
	void exitDecimalQuestion(InterviewModelGrammarParser.DecimalQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#dateQuestion}.
	 * @param ctx the parse tree
	 */
	void enterDateQuestion(InterviewModelGrammarParser.DateQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#dateQuestion}.
	 * @param ctx the parse tree
	 */
	void exitDateQuestion(InterviewModelGrammarParser.DateQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#timeQuestion}.
	 * @param ctx the parse tree
	 */
	void enterTimeQuestion(InterviewModelGrammarParser.TimeQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#timeQuestion}.
	 * @param ctx the parse tree
	 */
	void exitTimeQuestion(InterviewModelGrammarParser.TimeQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#scaleQuestion}.
	 * @param ctx the parse tree
	 */
	void enterScaleQuestion(InterviewModelGrammarParser.ScaleQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#scaleQuestion}.
	 * @param ctx the parse tree
	 */
	void exitScaleQuestion(InterviewModelGrammarParser.ScaleQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#correctAnswer}.
	 * @param ctx the parse tree
	 */
	void enterCorrectAnswer(InterviewModelGrammarParser.CorrectAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#correctAnswer}.
	 * @param ctx the parse tree
	 */
	void exitCorrectAnswer(InterviewModelGrammarParser.CorrectAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#questionAnswers}.
	 * @param ctx the parse tree
	 */
	void enterQuestionAnswers(InterviewModelGrammarParser.QuestionAnswersContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#questionAnswers}.
	 * @param ctx the parse tree
	 */
	void exitQuestionAnswers(InterviewModelGrammarParser.QuestionAnswersContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#questionPoints}.
	 * @param ctx the parse tree
	 */
	void enterQuestionPoints(InterviewModelGrammarParser.QuestionPointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#questionPoints}.
	 * @param ctx the parse tree
	 */
	void exitQuestionPoints(InterviewModelGrammarParser.QuestionPointsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#footer}.
	 * @param ctx the parse tree
	 */
	void enterFooter(InterviewModelGrammarParser.FooterContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#footer}.
	 * @param ctx the parse tree
	 */
	void exitFooter(InterviewModelGrammarParser.FooterContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#score_definition}.
	 * @param ctx the parse tree
	 */
	void enterScore_definition(InterviewModelGrammarParser.Score_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#score_definition}.
	 * @param ctx the parse tree
	 */
	void exitScore_definition(InterviewModelGrammarParser.Score_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterviewModelGrammarParser#outstandingClause}.
	 * @param ctx the parse tree
	 */
	void enterOutstandingClause(InterviewModelGrammarParser.OutstandingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterviewModelGrammarParser#outstandingClause}.
	 * @param ctx the parse tree
	 */
	void exitOutstandingClause(InterviewModelGrammarParser.OutstandingClauseContext ctx);
}