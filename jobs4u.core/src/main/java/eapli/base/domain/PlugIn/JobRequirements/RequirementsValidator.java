package eapli.base.domain.PlugIn.JobRequirements;



import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarBaseVisitor;
import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarLexer;
import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarParser;
import lombok.Getter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class RequirementsValidator extends JobRequirementsGrammarBaseVisitor<Map<String, String>> {

    private String validation = "Success";


    @Override
    public Map<String, String> visitRequirement(JobRequirementsGrammarParser.RequirementContext ctx) {
        List<JobRequirementsGrammarParser.RequirementTypeContext> requirements = ctx.requirementType();
        List<JobRequirementsGrammarParser.AnswersTypeContext> answers = ctx.answersType();
        Map <String, String> result = new HashMap<>();

        for (int i = 0; i < requirements.size(); i++) {
            String requirement = requirements.get(i).getText();
            String answer = answers.get(i).getText();
            result.put(requirement, answer);
        }
        return result;
    }
    public boolean verifyRequirements(String  candidateRequirementsFilePath, String jobRequirementsFilePath) {
        try {
            CharStream input = CharStreams.fromFileName(candidateRequirementsFilePath);
            CharStream input2 = CharStreams.fromFileName(jobRequirementsFilePath);


            JobRequirementsGrammarLexer requirementsGrammarLexer = new JobRequirementsGrammarLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(requirementsGrammarLexer);
            JobRequirementsGrammarParser parser = new JobRequirementsGrammarParser(tokens);
            ParseTree tree = parser.start();
            Map<String, String> candidateRequirementsMap = parseWithVisitor(tree);


            JobRequirementsGrammarLexer jobRequirementsGrammarLexer = new JobRequirementsGrammarLexer(input2);
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
    private Map<String, String> parseWithVisitor(ParseTree tree) {
        RequirementsValidator validator = new RequirementsValidator();
        return validator.visit(tree);
    }


}

