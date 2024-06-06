package eapli.base.domain.PlugIn.JobRequirements;


import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarLexer;
import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JobRequirements implements JobRequirementInterface {
    @Override
    public File generateTxt(String path) {
        // Create a File object for the desired path
        File file = new File(path);

        try {
            FileWriter writer = new FileWriter(path);

            // Write the prompts
            writer.write("----- JobRequirement2 -----\n\n\n");

            writer.write("Requirement #1: Years of experience\n");
            writer.write("Integer:\n\n");

            writer.write("Requirement #2: Know how to operate in a big kitchen\n");
            writer.write("TrueOrFalse:\n\n");

            writer.close();

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        return file;
    }

    @Override
    public String validate(String path) throws IOException {
        //verify if the file exists
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("File not found");
        }

        try {
            JobRequirementsGrammarLexer lexer = new JobRequirementsGrammarLexer(CharStreams.fromFileName(path));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JobRequirementsGrammarParser parser = new JobRequirementsGrammarParser(tokens);
            ParseTree tree = parser.start();
            String validation = parseWithVisitor(tree);
            return validation;
        } catch (Exception e) {
            System.err.println("Error parsing file: " + e.getMessage());
            return null;
        }
    }

    private static String parseWithVisitor(ParseTree tree) {
        RequirementsValidator validator = new RequirementsValidator();
        validator.visit(tree);

        return validator.getValidation();
    }

    public boolean verifyRequirements(String  candidateRequirements, String jobRequirements) {
        try {
            String validation = validate(candidateRequirements);
           if (!validation.equals("Success")) {
               System.err.println("Error validating requirements: " + validation);
           }
           validation= validate(jobRequirements);
              if (!validation.equals("Success")) {
                System.err.println("Error validating requirements: " + validation);
              }
        } catch (IOException e) {
            System.err.println("Error validating requirements: " + e.getMessage());
            return false;
        }
        return true;
    }

}

