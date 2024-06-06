package eapli.base.service;

import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import plugin.InterviewModel;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EvaluateInterviewService {
    private final JobInterviewRepository repository;

    public EvaluateInterviewService(JobInterviewRepository repository) {
        this.repository = repository;
    }

    public int evaluateInterview(String file) throws IOException {

        InterviewModel interviewModel = new InterviewModel();

       int score = interviewModel.enterStart(file);

        return score;
    }

    public Iterable<JobInterview> findJobInterview() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .filter(JobInterview::hasAnswers)
                .collect(Collectors.toList());
    }


    public Path findPath(JobInterview chosenInterview) {

        // Get the file name from the chosen interview
        String fileName = chosenInterview.interviewAnswers();

        // Define the base path
        String basePath = "C:\\Users\\Utilizador\\Desktop\\sem4pi-23-24-2dh3\\sem4pi-23-24-2dh3_final\\jobs4u.core\\src\\main\\resources\\PlugIns\\interviewModel\\UploadedFiles\\";

        // Find the file path
        Path filePath = Paths.get(basePath).resolve(fileName);
        return filePath;

    }

    public void setGrade(int score, JobInterview chosenInterview) {
        chosenInterview.setGrade(score);
    }

    public JobInterview save(JobInterview chosenInterview) {
        return repository.save(chosenInterview);
    }
}
