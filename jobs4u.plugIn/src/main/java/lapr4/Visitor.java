package lapr4;

import lapr4.PlugIns.interviewModel.InterviewModelGrammarBaseVisitor;
import lapr4.PlugIns.interviewModel.InterviewModelGrammarParser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Visitor extends InterviewModelGrammarBaseVisitor<Object> {

    private final List<String> answer;

    private int score;

    private int scoreAtual;

    private int currentQuestion;

    public Visitor(List<String> answer) {
        this.answer = answer;
        this.score = 0;
        this.currentQuestion = 0;
    }

    public static String getQuestionType(String input) {
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            // Remove all spaces from the matched string
            return matcher.group(1).replaceAll("\\s+", "").trim();
        }
        return null;
    }

    @Override
    public Object visitQuestionType(InterviewModelGrammarParser.QuestionTypeContext ctx) {
        String question = ctx.getText().trim();


        System.out.println("Question:" + question);

        String test = getQuestionType(question);
        System.out.println(test + "..........................................");
        switch (test) {
            case "TrueorFalse":
                System.out.println("True or False Question");
                return visit(ctx.trueOrFalseQuestion());
            case "SingleChoice":
                return visit(ctx.singleChoiceQuestion());
            case "ShortAnswer":
                return visit(ctx.shortAnswerQuestion());
            case "Multiple Choice":
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

//    @Override
//    public Object visitTrueOrFalseQuestion(InterviewModelGrammarParser.TrueOrFalseQuestionContext ctx) {
//        String answer = this.answer.get(currentQuestion);
//        String correctAnswer = ctx.answer.getText().trim();
//        System.out.println("Correct Answer: " + correctAnswer);
//        System.out.println("Answer: " + answer);
//        if (answer.equals(correctAnswer)) {
//            scoreAtual = 1;
//        } else {
//            scoreAtual = 0;
//        }
//        score += scoreAtual;
//        System.out.println("Score: " + scoreAtual);
//        currentQuestion++;
//        return null;
//    }
//    @Override
//    public Object visitTrueOrFalseQuestion(InterviewModelGrammarParser.TrueOrFalseQuestionContext ctx) {
//        String userAnswer = this.answer.get(currentQuestion);
//        String correctAnswer = ctx.answer.getText().trim();
//        System.out.println("Correct Answer: " + correctAnswer);
//        System.out.println("User Answer: " + userAnswer);
//
//        boolean userAnswerBool = Boolean.parseBoolean(userAnswer);
//        boolean correctAnswerBool = Boolean.parseBoolean(correctAnswer);
//
//        if (userAnswerBool == correctAnswerBool) {
//            scoreAtual += Integer.parseInt(ctx.
//        }
//
//        System.out.println("Score: " + scoreAtual);
//        currentQuestion++;
//        return null;
//    }
    @Override
    public Object visitEvaluation(InterviewModelGrammarParser.EvaluationContext ctx) {
        String evaluation = ctx.questionAnswers().getText();


        return visit(ctx.questionAnswers());
    }

    public int getScore() {
        return score;
    }

}
