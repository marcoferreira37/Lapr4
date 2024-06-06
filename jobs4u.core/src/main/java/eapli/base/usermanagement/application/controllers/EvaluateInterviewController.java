package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarLexer;
import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarParser;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.service.EvaluateInterviewService;
import eapli.base.service.InterviewService;
import eapli.base.service.JobOpeningApplicationService;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import plugin.InterviewModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EvaluateInterviewController {

    private final JobInterviewRepository repository = PersistenceContext.repositories().jobInterviews();
    EvaluateInterviewService service = new EvaluateInterviewService(repository);


    public int evaluateInterview(String file) throws IOException {
       return service.evaluateInterview(file);
    }



    public Iterable<JobInterview> findJobInterview(){
        return service.findJobInterview();
    }

    public Path findPath(JobInterview chosenInterview) {
        return service.findPath(chosenInterview);

    }

    public JobInterview save(JobInterview chosenInterview) {
       return service.save(chosenInterview);
    }

    public void setGrade(int score, JobInterview chosenInterview) {
        service.setGrade(score, chosenInterview);
    }
}
