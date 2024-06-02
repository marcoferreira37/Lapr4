package eapli.base.domain.PlugIn.InterviewModel;

import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarLexer;
import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InterviewModel2 implements InterviewModelInterface {
    @Override
    public File generateTxt(String path) {
        // Create a File object for the desired path
        File file = new File(path);

        try {
            FileWriter writer = new FileWriter(path);

            // Write the prompts
            writer.write("----- InterviewModel2 -----\n\n\n");

            writer.write("Question #1: -Can you cook? (write true or false)\n");
            writer.write("TrueOrFalse:\n\n");

            writer.write("Question #2: What do you prefer to cook?\n");
            writer.write("\tOption *1: Fish\n");
            writer.write("\tOption *2: Steak\n");
            writer.write("\tOption *3: Pasta\n");
            writer.write("\tOption *4: Pizza\n");
            writer.write("\tOption *5: Salad\n");
            writer.write("\tOption *6: None\n");
            writer.write("SingleOption:\n\n");

            writer.write("Question #3: How many different kitchens have you worked in?\n");
            writer.write("Integer:\n\n");

            writer.write("Question #4: How do you rate your knife skills from 1 to 5?\n");
            writer.write("Scale:\n\n");
            writer.close();

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        return file;
    }

    @Override
    public int evaluate(String path) throws IOException {
        // Verify if the file exists
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("File not found");
        }

        try {
            InterviewModelGrammarLexer lexer = new InterviewModelGrammarLexer(CharStreams.fromFileName(path));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            InterviewModelGrammarParser parser = new InterviewModelGrammarParser(tokens);
            ParseTree tree = parser.start();
            int score = parseWithVisitor(tree);
            return score;
        } catch (Exception e) {
            System.err.println("Error parsing file: " + e.getMessage());
            return -1;
        }
    }

    private static int parseWithVisitor(ParseTree tree) {
        QuestionsEvaluator evaluator = new QuestionsEvaluator();
        evaluator.visit(tree);

        return evaluator.getScore();
    }
}
