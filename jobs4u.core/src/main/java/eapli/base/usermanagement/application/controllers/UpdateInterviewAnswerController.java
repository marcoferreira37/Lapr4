package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarLexer;
import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarParser;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobInterviewRepository;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.Optional;

public class UpdateInterviewAnswerController {

    JobInterviewRepository interviewRepo = PersistenceContext.repositories().jobInterviews();

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
