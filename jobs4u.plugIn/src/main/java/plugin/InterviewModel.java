package plugin;

import plugin.interviewModel.InterviewModelGrammarLexer;
import plugin.interviewModel.InterviewModelGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class InterviewModel {

    private final int QUESTION1 = 5;
    private final int QUESTION2 = 10;
    private final int QUESTION3 = 5;
    private final int QUESTION4 = 5;
    private final int QUESTION5 = 5;
    private final int QUESTION6 = 5;
    private final int QUESTION7 = 5;
    private final int QUESTION8 = 5;

    private int score = 0;

    public void enterStart(String template) {
        try {


            Path file = Paths.get(template);
            String input = new String(Files.readAllBytes(file));

            InterviewModelGrammarLexer lexer = new InterviewModelGrammarLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            InterviewModelGrammarParser parser = new InterviewModelGrammarParser(tokens);


            ParseTree tree = parser.start();
            Map<String, Map<String, String>> map = new HashMap<>();
            Visitor visitor = new Visitor(map);
            visitor.visit(tree);
            System.out.println("Map generated: " + map);

            if (map == null) {
                System.out.println("Error: map is null after visiting the tree");
                return;
            }


            for (String s : map.keySet()) {
                if (s.equals("Question1")) {
                    for (String answerCorreta : map.get(s).keySet()) {
                        if (answerCorreta.equals(map.get(s).get(answerCorreta))) {
                            System.out.println("Score in question 1: " + QUESTION1);
                            score += QUESTION1;
                        }

                    }
                }
                if (s.equals("Question2")) {
                    for (String setDasRespsotasCertas : map.get(s).keySet()) {
                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                            System.out.println("Score in question 2: " + QUESTION2);
                        score += QUESTION2;

                    }
                }
                if (s.equals("Question3")) {
                    for (String setDasRespsotasCertas : map.get(s).keySet()) {
                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                            System.out.println("Score in question 3: " + QUESTION3);
                        score += QUESTION3;

                    }
                }
                if (s.equals("Question4")) {
                    for (String setDasRespsotasCertas : map.get(s).keySet()) {
                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                            System.out.println("Score in question 4: " + QUESTION4);
                        score += QUESTION4;

                    }
                }
                if (s.equals("Question5")) {
                    for (String setDasRespsotasCertas : map.get(s).keySet()) {
                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                            System.out.println("Score in question 5: " + QUESTION5);
                        score += QUESTION5;

                    }
                }
                if (s.equals("Question6")) {
                    for (String setDasRespsotasCertas : map.get(s).keySet()) {
                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                            System.out.println("Score in question 6: " + QUESTION6);
                        score += QUESTION6;

                    }
                }
                if (s.equals("Question7")) {
                    for (String setDasRespsotasCertas : map.get(s).keySet()) {
                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                            System.out.println("Score in question 7: " + QUESTION7);
                        score += QUESTION7;

                    }
                }
                if (s.equals("Question8")) {
                    for (String setDasRespsotasCertas : map.get(s).keySet()) {
                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                            System.out.println("Score in question 8: " + QUESTION8);
                        score += QUESTION8;

                    }

                }

                System.out.println("---------------");
                System.out.println("Score: " + score);

//                interview.setGrade(score);
                //   repo.save(interview);

            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}

