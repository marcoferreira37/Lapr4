package plugin;

import plugin.antlr4.autogen.interview.InterviewModelGrammarLexer;
import plugin.antlr4.autogen.interview.InterviewModelGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class InterviewModel {
    private int score = 0;

    public int evaluateInterview(String template) throws IOException {


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

        score = RuleScore.calculateScore(map, score);

        System.out.println("---------------");
        System.out.println("Score: " + score);
        return score;
    }
}


