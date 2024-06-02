
package eapli.base.domain.PlugIn.JobRequirements;

import eapli.base.domain.PlugIn.JobRequirements.genClasses.JobRequirementsGrammarBaseVisitor;
import eapli.base.domain.PlugIn.JobRequirements.genClasses.JobRequirementsGrammarParser;

public class RequirementsValidator extends JobRequirementsGrammarBaseVisitor {

    private String validation = "Success";

    public String getValidation() {
        return validation;
    }

    @Override
    public Object visitRequirements(JobRequirementsGrammarParser.RequirementsContext ctx) {
        String id = ctx.id.getText();

        switch (id) {
            case "1":
                int answer = Integer.parseInt(ctx.requirementType().integerRequirement().answer.getText());
                // Condition: answer is more or equal to 5
                if (answer < 5) {
                    if (validation.equals("Success")) {
                        validation = "Requirement #1 failed: must have at least 5 years of experience";
                    } else {
                        validation = validation + "\nRequirement #1 failed: must have at least 5 years of experience";
                    }
                }
                break;
            case "2":
                String answer2 = ctx.requirementType().trueOrFalseRequirement().answer.getText();
                // Condition: answer must be true
                if (!answer2.equalsIgnoreCase("true")) {
                    if (validation.equals("Success")) {
                        validation = "Requirement #2 failed: must be able to operate in a big kitchen";
                    } else {
                        validation = validation + "\nRequirement #2 failed: must be able to operate in a big kitchen";
                    }
                }
                break;
            case "3":
                String shortAnswer = ctx.requirementType().shortAnswerRequirement().answer.getText();
                // Add validation logic for short answer if needed
                break;
            default:
                System.out.println("Invalid requirement id: " + id);
                break;
        }

        return null;
    }

}

