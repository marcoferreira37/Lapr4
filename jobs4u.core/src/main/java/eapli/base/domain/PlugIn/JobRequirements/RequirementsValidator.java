
package eapli.base.domain.PlugIn.JobRequirements;



import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarBaseVisitor;
import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarParser;
import lombok.Getter;

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


}

