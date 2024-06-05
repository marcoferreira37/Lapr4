package lapr4;


import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobInterviewRepository;
import lapr4.PlugIns.interviewModel.InterviewModelGrammarLexer;
import lapr4.PlugIns.interviewModel.InterviewModelGrammarParser;
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

    private JobOpeningApplication application = new JobOpeningApplication();
    private JobInterview interview = new JobInterview("12h00", Calendar.getInstance(), application, 0);

    private JobInterviewRepository repo = PersistenceContext.repositories().jobInterviews();


    public void enterStart(String template) {
        try {


            System.out.println("Template");
            System.out.println("---------------");
            System.out.println("---------------");

            Path file = Paths.get(template);
            String input = new String(Files.readAllBytes(file));

            InterviewModelGrammarLexer lexer = new InterviewModelGrammarLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            InterviewModelGrammarParser parser = new InterviewModelGrammarParser(tokens);


            ParseTree tree = parser.start();
            Map<String, Map<String, String>> map = new HashMap<>();
            Visitor visitor = new Visitor(map);
            visitor.visit(tree);
            System.out.println(map);
            if (map == null) {
                System.out.println("Error: map is null after visiting the tree");
                return;
            }
            System.out.println(map.get("Question1"));


            for (String s : map.keySet()) {
                if (s.equals("Question1")) {
                    System.out.println("Questino");
                    for (String answerCorreta : map.get(s).keySet()) {
                        if (answerCorreta.equals(map.get(s).get(answerCorreta))) {
                            System.out.println("q1"+map.get(s));
                            System.out.println(map.get(s).get(answerCorreta));
                            score += QUESTION1;
                        }

                    }
                }
                if (s.equals("Question2")) {
                    for (String setDasRespsotasCertas : map.get(s).keySet()) {
                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                            System.out.println("q2"+map.get(s));
                        System.out.println(map.get(s).get(setDasRespsotasCertas));
                        score += QUESTION2;

                    }
                }
//                if (s.equals("Question3")) {
//                    for ( String setDasRespsotasCertas : map.get(s).keySet()) {
//                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
//                            // System.out.println(map.get(s));
//                            // System.out.println(map.get(s).get(setDasRespsotasCertas));
//                            score += QUESTION1;
//
//                    }
//                }
//                if (s.equals("Question4")) {
//                    for ( String setDasRespsotasCertas : map.get(s).keySet()) {
//                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
//                            // System.out.println(map.get(s));
//                            // System.out.println(map.get(s).get(setDasRespsotasCertas));
//                            score += QUESTION1;
//
//                    }
//                }
//                if (s.equals("Question5")) {
//                    for ( String setDasRespsotasCertas : map.get(s).keySet()) {
//                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
//                            // System.out.println(map.get(s));
//                            // System.out.println(map.get(s).get(setDasRespsotasCertas));
//                            score += QUESTION1;
//
//                    }
//                }
//                if (s.equals("Question6")) {
//                    for ( String setDasRespsotasCertas : map.get(s).keySet()) {
//                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
//                            // System.out.println(map.get(s));
//                            // System.out.println(map.get(s).get(setDasRespsotasCertas));
//                            score += QUESTION1;
//
//                    }
//                }
//                if (s.equals("Question7")) {
//                    for ( String setDasRespsotasCertas : map.get(s).keySet()) {
//                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
//                            // System.out.println(map.get(s));
//                            // System.out.println(map.get(s).get(setDasRespsotasCertas));
//                            score += QUESTION1;
//
//                    }
//                }
//                if (s.equals("Question8")) {
//                    for ( String setDasRespsotasCertas : map.get(s).keySet()) {
//                        if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
//                            // System.out.println(map.get(s));
//                            // System.out.println(map.get(s).get(setDasRespsotasCertas));
//                            score += QUESTION1;
//
//                    }

            }

            System.out.println("---------------");
            System.out.println("Score: " + score);

            interview.setGrade(score);
            repo.save(interview);


        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}

