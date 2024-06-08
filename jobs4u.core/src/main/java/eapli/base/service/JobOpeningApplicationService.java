package eapli.base.service;


import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarLexer;
import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarParser;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Component;
import plugin.structure.RequirementsValidatorVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobOpeningApplicationService {

    private final JobOpeningApplicationRepository repository = PersistenceContext.repositories().jobApplicationsRepository();

    public JobOpeningApplicationService() {

    }

    public Iterable<JobOpeningApplication> findJobOpeningApplication() {
        return repository.findAll();
    }

    public List<JobOpeningApplication> getApplicationsByCandidate(Candidate c) {
        List<JobOpeningApplication> jobOpeningApplicationList = new ArrayList<>();
        Iterable<JobOpeningApplication> jobOpeningApplications = repository.allApplicationsByCandidate(c);
        for (JobOpeningApplication application : jobOpeningApplications) {
            jobOpeningApplicationList.add(application);
        }
        return jobOpeningApplicationList;
    }


    public boolean passGrammar(String path) {
        if (path == null) {
            System.out.println("File not found");
            return false;
        }

        try {
            CharStream input = CharStreams.fromFileName(path);
            JobRequirementsGrammarLexer lexer = new JobRequirementsGrammarLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JobRequirementsGrammarParser parser = new JobRequirementsGrammarParser(tokens);
            try {
                new RequirementsValidatorVisitor().visit(parser.start());
                System.out.println("File matches grammar. Uploading file.");
                return true;
            } catch (RuntimeException e) {
                return false;
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error verifying grammar: " + e.getMessage());
        }

        return false;
    }
}
