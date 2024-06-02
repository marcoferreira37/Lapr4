package eapli.base.domain.PlugIn.InterviewModel;

import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarBaseVisitor;
import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarParser;

public class QuestionsEvaluator extends InterviewModelGrammarBaseVisitor<Object> {

    private int score;

    private final int QUESTION_1_SCORE = 50;
    private final int QUESTION_2_SCORE = 10;
    private final int QUESTION_3_SCORE = 15;
    private final int QUESTION_4_SCORE = 25;

    public QuestionsEvaluator() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    @Override
    public Object visitInterview(InterviewModelGrammarParser.InterviewContext ctx) {
        for (InterviewModelGrammarParser.QuestionContext questionCtx : ctx.questions().question()) {
            visit(questionCtx);
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitQuestion(InterviewModelGrammarParser.QuestionContext ctx) {
        String id = ctx.id.getText();
        String answer = null;

        switch (id) {
            case "1":
                answer = ctx.questionType().trueOrFalseQuestion().answer.getText();
                if (answer.equals("true")) {
                    score += QUESTION_1_SCORE;
                }
                break;
            case "2":
                answer = ctx.questionType().singleChoiceQuestion().answer.getText();
                if (answer.equals("1")) {
                    score += QUESTION_2_SCORE;
                }
                break;
            case "3":
                int answer3 = Integer.parseInt(ctx.questionType().integerQuestion().answer.getText());
                if (answer3 >= 2 && answer3 <= 10) {
                    score += QUESTION_3_SCORE;
                }
                break;
            case "4":
                answer = ctx.questionType().scaleQuestion().answer.getText();
                if (answer.equals("4") || answer.equals("5")) {
                    score += QUESTION_4_SCORE;
                }
                break;
            default:
                System.out.println("Invalid question id: " + id);
                break;
        }
        return visitChildren(ctx);
    }
}
