
package eapli.base.domain.PlugIn.InterviewModel;

import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarBaseVisitor;
import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarParser;

public class QuestionsEvaluator extends InterviewModelGrammarBaseVisitor {

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
/*
    @Override
    public Object visitEvalQuestion(InterviewModelGrammarParser.EvalQuestionContext ctx){
        String id = ctx.id().getText();


        switch (id) {
            case "1:":

                String answer = ctx.questionType().trueOrFalseQuestion().answer.getText();
                //String equals true or false or True or False
                if (answer.equals("True") || answer.equals("true")) {
                    score = score + QUESTION_1_SCORE;
                }

                break;
            case "2:":

                String answer2 = ctx.questionType().singleChoiceQuestion().answer.getText();
                //String is 1
                if (answer2.equals("1")) {
                    score = score + QUESTION_2_SCORE;
                }

                break;
            case "3:":

                int answer3 = Integer.parseInt(ctx.questionType().integerQuestion().answer.getText());
                //answer between 2 and 10
                if (answer3 >= 2 && answer3 <= 10) {
                    score = score + QUESTION_3_SCORE;
                }

                break;
            case "4:":

                String answer4 = ctx.questionType().scaleQuestion().answer.getText();
                if (answer4.equals("4") || answer4.equals("5")) {
                    score = score + QUESTION_4_SCORE;
                }

                break;
            default:
                System.out.println("Invalid question id: " + id);
                break;
        }
        return visitChildren(ctx);
    }


 */
}

