package plugin.structure;

import org.antlr.v4.runtime.tree.ErrorNode;
import plugin.antlr4.autogen.requirements.JobRequirementsGrammarBaseVisitor;
import plugin.antlr4.autogen.requirements.JobRequirementsGrammarParser;

import java.util.Map;

public class RequirementsValidatorVisitor extends JobRequirementsGrammarBaseVisitor<Object> {
    @Override
    public Object visitRequirement(JobRequirementsGrammarParser.RequirementContext ctx) {
        String type = ctx.requirementType().toString();
        type = extractText(type);

        switch (type){
            case "AcademicDegree:":

            default:
                System.out.println("Invalid requirement type: " + type);
                break;
        }
        return visitChildren(ctx);
    }


    @Override
    public Object visitRequirementType(JobRequirementsGrammarParser.RequirementTypeContext ctx) {
        String type = ctx.getText();
        type = extractText(type);

        switch (type){
            case "AcademicDegree:":
                //visitRequirement()
                 visitAcademicDegreeRequirement(ctx.academicDegreeRequirement());

                 case "Programming Languages:":
                return visitProgramingLanguages(ctx.programingLanguages());
            case  "Integer:":
                return visitIntegerRequirement(ctx.integerRequirement());
            default:
                System.out.println("Invalid requirement type: " + type);
                break;
        }

        return visitChildren(ctx);
    }

    @Override
    public Object visitIntegerRequirement(JobRequirementsGrammarParser.IntegerRequirementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitProgramingLanguages(JobRequirementsGrammarParser.ProgramingLanguagesContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitAcademicDegreeRequirement(JobRequirementsGrammarParser.AcademicDegreeRequirementContext ctx) {
        return visitChildren(ctx);
    }

    public String extractText(String input) {
        int start = input.lastIndexOf("\"") + 1; // Start index of the text (after the last quote and colon)
        String transformedText = input.substring(start); // Extract the text from start to the end
        return transformedText;
    }
}
