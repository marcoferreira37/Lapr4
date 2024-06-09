package eapli.base.service;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobInterviewRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InterviewService {

    private JobInterviewRepository repository = PersistenceContext.repositories().jobInterviewRepository();

    public InterviewService(JobInterviewRepository repository) {
        this.repository = repository;

    }

    public InterviewService() {
    }

    @Transactional
    public JobInterview recordInterview(Calendar interviewDate, String interviewTime, JobOpeningApplication jobOpeningApplication) {
        JobInterview jobInterview = new JobInterview(interviewTime, interviewDate, jobOpeningApplication);
        try {
            return repository.save(jobInterview);
        } catch (IllegalArgumentException e) {
            System.out.println("Error recording the interview: " + e.getMessage());
            // Lógica adicional para lidar com o erro, como solicitar novos valores
        }
        return null;
    }

    public void gradeInterview(JobInterview interview, int grade) {
        interview.gradeInterview(grade);
        repository.save(interview);
    }

    public boolean generateTemplate(Path sourcePath, JobInterview interview) {

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(sourcePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int colonIndex = line.indexOf(':');
                if (colonIndex != -1) {
                    lines.add(line.substring(0, colonIndex + 1).trim());
                } else {
                    lines.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file");
            e.printStackTrace();
            return false;
        }

        File destinationFile = new File("jobs4u.core/src/main/resources/PlugIns/templateInterview" + interview.toString() + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            for (String processedLine : lines) {
                writer.write(processedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing the file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Iterable<JobInterview> findJobInterviews() {
        return repository.findAll();
    }
}

