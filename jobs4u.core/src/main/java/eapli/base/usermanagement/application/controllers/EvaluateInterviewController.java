package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarLexer;
import eapli.base.domain.PlugIn.InterviewModel.genClasses.InterviewModelGrammarParser;
import eapli.base.service.EvaluateInterviewService;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import plugin.InterviewModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EvaluateInterviewController {

    EvaluateInterviewService service = new EvaluateInterviewService();


    public void evaluateInterview(String file) throws IOException {

        service.evaluateInterview(file);


    }
}
