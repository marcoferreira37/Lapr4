package plugin;

import plugin.antlr4.autogen.interview.InterviewModelGrammarBaseVisitor;
import plugin.antlr4.autogen.interview.InterviewModelGrammarParser;

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
