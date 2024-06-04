package lapr4;

import lapr4.PlugIns.interviewModel.InterviewModelGrammarLexer;
import lapr4.PlugIns.interviewModel.InterviewModelGrammarParser;
import lapr4.PlugIns.interviewModel.InterviewModelGrammarVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.nio.file.Files;
import java.nio.file.Paths;

public class InterviewModel {

    public void enterStart() {
        try {
            String file = "src/main/resources/InterviewModel.txt";
            String input = new String(Files.readAllBytes(Paths.get(file)));

            System.out.println("Interview Model");
            System.out.println("---------------");
            System.out.println(input);
            System.out.println("---------------");

            InterviewModelGrammarLexer lexer = new InterviewModelGrammarLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            InterviewModelGrammarParser parser = new InterviewModelGrammarParser(tokens);

            ParseTree tree = parser.start();

            Visitor visitor = new Visitor(ansewr);
            visitor.visit(tree);

            System.out.println("---------------");
            int score = visitor.getScore();
            System.out.println("Score: " + score);













        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
