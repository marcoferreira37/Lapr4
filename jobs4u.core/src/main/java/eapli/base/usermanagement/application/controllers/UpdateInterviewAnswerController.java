package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarLexer;
import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarParser;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import plugin.structure.JobInterviewValidatorVisitor;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UpdateInterviewAnswerController {

    JobInterviewRepository interviewRepo = PersistenceContext.repositories().jobInterviews();

    private final CandidateManagementService service = new CandidateManagementService();

    public Object allCandidate() {
        return service.allCandidate();
    }


    public Iterable<JobOpeningApplication> allApplicationsById(Candidate candidate) {
        final JobOpeningApplicationRepository applications = PersistenceContext.repositories().jobApplications();
        return applications.allApplicationsByCandidate(candidate);
    }

    public List<JobOpeningApplication> allApplicationsByIdWithInterview(Candidate candidate) {
        List<JobOpeningApplication> applications = (List<JobOpeningApplication>) allApplicationsById(candidate);
        final JobInterviewRepository interviewRepo = PersistenceContext.repositories().jobInterviews();
        applications.removeIf(app -> interviewRepo.findByJobApp(app) == null);
        return applications;
    }

    public boolean passGrammar(String path) {
        if(path == null){
            System.out.println("File not found");
            return false;
        }

        try{
            CharStream input = CharStreams.fromFileName(path);
            InterviewModelGrammarLexer lexer = new InterviewModelGrammarLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            InterviewModelGrammarParser parser = new InterviewModelGrammarParser(tokens);
            ParseTree tree = parser.start();
            new JobInterviewValidatorVisitor().visit(tree);

            /*
            try{
                new JobInterviewValidatorVisitor().visit(parser.interview());
                System.out.println("File passed grammar verification");
                return true;
            }catch(RuntimeException e ){
                return false;
            }

             */

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e){
            System.err.println("Error verifying grammar: " + e.getMessage());
        }

        return true;

    }

    public void uploadFiles(JobOpeningApplication app, String fileName, String path) {
        if (passGrammar(path)) {
            JobInterview interview = interviewRepo.findByJobApp(app);
            interview.setInterviewAnswers(fileName);
            interviewRepo.save(interview);
        }else {
            System.out.println("Error: File didnt match grammar");
        }

    }

}
