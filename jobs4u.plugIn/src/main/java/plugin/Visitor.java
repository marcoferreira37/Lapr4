package plugin;

import plugin.interviewModel.InterviewModelGrammarBaseVisitor;
import plugin.interviewModel.InterviewModelGrammarParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Visitor extends InterviewModelGrammarBaseVisitor<Map<String, Map<String, String>>> {
    private Map<String, Map<String, String>> map;

    private int score;

    private int scoreAtual;

    private int currentQuestion;

    public Visitor(List<String> answer) {
        this.score = 0;
        this.currentQuestion = 0;
    }

    public Visitor() {
    }

    public Visitor(Map<String, Map<String, String>> map) {
        this.map = map;
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

//    @Override
//    public Object visitQuestionType(InterviewModelGrammarParser.QuestionTypeContext ctx) {
//        String question = ctx.getText().trim();
//
//
//        System.out.println("Question:" + question);
//
//        String test = getQuestionType(question);
//        System.out.println(test + "..........................................");
//        switch (test) {
//            case "TrueorFalse":
//                System.out.println("True or False Question");
//                return visit(ctx.trueOrFalseQuestion());
//            case "SingleChoice":
//                return visit(ctx.singleChoiceQuestion());
//            case "ShortAnswer":
//                return visit(ctx.shortAnswerQuestion());
//            case "MultipleChoice":
//                return visit(ctx.multipleChoiceQuestion());
//            case "Integer":
//                return visit(ctx.integerQuestion());
//            case "Decimal":
//                return visit(ctx.decimalQuestion());
//            case "Date":
//                return visit(ctx.dateQuestion());
//            case "Time":
//                return visit(ctx.timeQuestion());
//            case "Scale":
//                return visit(ctx.scaleQuestion());
//            default:
//                System.out.println("Invalid question type");
//                return null;
//        }
//    }

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
    public Map<String, Map<String, String>> visitEvaluation(InterviewModelGrammarParser.EvaluationContext ctx) {
        List<InterviewModelGrammarParser.QuestionsContext> questions = ctx.questions();
        List<InterviewModelGrammarParser.QuestionAnswersContext> correctAnswers = ctx.questionAnswers();



        for (int i = 0; i < questions.size(); i++) {
            Map<String, String> userAnswers = new HashMap<>();

            String fullQuestionText = questions.get(i).getText();

            String specificPhrase = extractSpecificPhrase(fullQuestionText);

            String userAnswer = correctAnswers.get(i).getText();
            String correctAnswer = extractSpecificPhrase2(userAnswer);


//            System.out.println("Specific Phrase: " + specificPhrase);
            userAnswers.put(specificPhrase, correctAnswer);

            String id = questions.get(i).getText();
            String question = extractSpecificPhrase3(id);
            map.put(question, userAnswers);

        }


        return map;
    }

    private String extractSpecificPhrase(String fullQuestionText) {
        String[] parts = fullQuestionText.split("with answer");
        // Verifique se a divisão resultou em pelo menos duas partes
        if (parts.length < 2) {
            return null; // ou lance uma exceção, dependendo do que você quer fazer neste caso
        }
        // A segunda parte é a frase que você está procurando
        String specificPhrase = parts[1].trim();
        // Remova as aspas no início e no final da frase, se houver
        specificPhrase = specificPhrase.replaceAll("^\"|\"$", "");
        return specificPhrase;
    }

    private String extractSpecificPhrase2(String fullQuestionText) {
        String[] parts = fullQuestionText.split(":");
        // Verifique se a divisão resultou em pelo menos duas partes
        if (parts.length < 2) {
            return null; // ou lance uma exceção, dependendo do que você quer fazer neste caso
        }
        // A segunda parte é a frase que você está procurando
        String specificPhrase = parts[1].trim();
        // Remova as aspas no início e no final da frase, se houver
        specificPhrase = specificPhrase.replaceAll("^\"|\"$", "");
        return specificPhrase;
    }

    private String extractSpecificPhrase3(String fullQuestionText) {
        // Divida a string em ":"
        String[] parts = fullQuestionText.split(":");
        // Verifique se a divisão resultou em pelo menos duas partes
        if (parts.length < 2) {
            return null; // ou lance uma exceção, dependendo do que você quer fazer neste caso
        }
        // A primeira parte é a frase que você está procurando
        String questionNumber = parts[0].trim();
        return questionNumber;
    }

    public int getScore() {
        return score;
    }

}
