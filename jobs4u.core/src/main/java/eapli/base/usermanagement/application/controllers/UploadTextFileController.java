package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.PlugIn.JobRequirements.genClasses.JobRequirementsGrammarLexer;
import eapli.base.domain.PlugIn.JobRequirements.genClasses.JobRequirementsGrammarParser;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UploadTextFileController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CandidateManagementService candidateSvc = new CandidateManagementService();


    public Iterable<Candidate> allCandidates() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.OPERATOR);

        return candidateSvc.allCandidate();
    }

    public void uploadFile(String curriculum) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN, BaseRoles.POWER_USER);

        File file = new File("jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/file.txt");
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(file))) {
            fileWriter.println(curriculum);
            System.out.println("File uploaded with success!");
        } catch (IOException e) {
            System.err.println("Error generating file" + e.getMessage());
        }
    }

    public static void verifyRequirementsGrammar(String filePath) {
        try {
            CharStream input = CharStreams.fromFileName(filePath);

            JobRequirementsGrammarLexer lexer = new JobRequirementsGrammarLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            JobRequirementsGrammarParser parser = new JobRequirementsGrammarParser(tokens);


            ParseTree tree = parser.start();


            System.out.println(tree.toStringTree(parser));

            System.out.println("Grammar verified successfully!");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error verifying grammar: " + e.getMessage());
        }
    }
}
