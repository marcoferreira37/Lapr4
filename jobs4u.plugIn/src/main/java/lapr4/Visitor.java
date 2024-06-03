package lapr4;

import lapr4.PlugIns.interviewModel.InterviewModelGrammarBaseListener;
import lapr4.PlugIns.interviewModel.InterviewModelGrammarBaseVisitor;
import lapr4.PlugIns.interviewModel.InterviewModelGrammarParser;

import java.util.List;

public class Visitor extends InterviewModelGrammarBaseVisitor<Object> {

    private final List<String> ansewr;

    private int score;

    private int scoreAtual;

    private int currentQuestion;

    public Visitor(List<String> ansewr) {
        this.ansewr = ansewr;
        this.score = 0;
        this.currentQuestion = 0;
    }

    @Override
    public Object visitQuestionType(InterviewModelGrammarParser.QuestionTypeContext ctx) {

        String question = ctx.getText().trim();

        System.out.println("Question: " + question);

        switch (question) {
            case "TrueOrFalse":
                return visit(ctx.trueOrFalseQuestion());
            case "SingleChoice":
                return visit(ctx.singleChoiceQuestion());
            case "ShortAnswer":
                return visit(ctx.shortAnswerQuestion());
            case "MultipleChoice":
                return visit(ctx.multipleChoiceQuestion());
            case "Integer":
                return visit(ctx.integerQuestion());
            case "Decimal":
                return visit(ctx.decimalQuestion());
            case "Date":
                return visit(ctx.dateQuestion());
            case "Time":
                return visit(ctx.timeQuestion());
            case "Scale":
                return visit(ctx.scaleQuestion());
            default:
                System.out.println("Invalid question type");
                return null;
        }
    }

    @Override
    public Object visitTrueOrFalseQuestion(InterviewModelGrammarParser.TrueOrFalseQuestionContext ctx) {
        String answer = ansewr.get(currentQuestion);
        String correctAnswer = ctx.answer.getText().trim();
        System.out.println("Correct Answer: " + correctAnswer);
        System.out.println("Answer: " + answer);
        if (answer.equals(correctAnswer)) {
            scoreAtual = 1;
        } else {
            scoreAtual = 0;
        }
        score += scoreAtual;
        System.out.println("Score: " + scoreAtual);
        currentQuestion++;
        return null;
    }


}
