package eapli.base.domain.PlugIn.JobRequirements;


import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarLexer;
import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JobRequirements {

    private Map<String, String> parseWithVisitor(ParseTree tree) {
        RequirementsValidator validator = new RequirementsValidator();
        return validator.visit(tree);
    }

    public boolean verifyRequirements(String  candidateRequirements, String jobRequirements) {
        try {
            JobRequirementsGrammarLexer requirementsGrammarLexer = new JobRequirementsGrammarLexer(CharStreams.fromString(candidateRequirements));
            CommonTokenStream tokens = new CommonTokenStream(requirementsGrammarLexer);
            JobRequirementsGrammarParser parser = new JobRequirementsGrammarParser(tokens);
            ParseTree tree = parser.start();
            Map<String, String> candidateRequirementsMap = parseWithVisitor(tree);


            JobRequirementsGrammarLexer jobRequirementsGrammarLexer = new JobRequirementsGrammarLexer(CharStreams.fromString(jobRequirements));
            CommonTokenStream tokens2 = new CommonTokenStream(jobRequirementsGrammarLexer);
            JobRequirementsGrammarParser parser2 = new JobRequirementsGrammarParser(tokens2);
            ParseTree tree2 = parser2.start();
            Map<String, String> jobRequirementsMap = parseWithVisitor(tree2);

            for (Map.Entry<String, String> entry : jobRequirementsMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!candidateRequirementsMap.containsKey(key) || !candidateRequirementsMap.get(key).equals(value)) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing file: " + e.getMessage());
            return false;
        }
        return true;
    }

}

