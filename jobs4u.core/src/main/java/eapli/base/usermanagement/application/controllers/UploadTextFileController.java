package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarLexer;
import eapli.base.domain.PlugIn.JobRequirements.gen.JobRequirementsGrammarParser;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.service.JobOpeningApplicationService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import plugin.structure.RequirementsValidatorVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class UploadTextFileController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CandidateManagementService candidateSvc = new CandidateManagementService();

    private final JobOpeningApplicationService jobOpeningApplicationService = new JobOpeningApplicationService();

    private final JobOpeningApplicationRepository applicationRepo = PersistenceContext.repositories().jobApplicationsRepository();


    public Iterable<Candidate> allCandidates() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.OPERATOR);

        return candidateSvc.allCandidate();
    }

    public List<JobOpeningApplication> getAppByCandidate(Candidate c) {
        return jobOpeningApplicationService.getApplicationsByCandidate(c);
    }

    public void uploadFile(JobOpeningApplication app, String file) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN, BaseRoles.POWER_USER);

        try {
            if (jobOpeningApplicationService.passGrammar(file)) {
                Path source = Paths.get(file);
                Path destinatinPAth = Paths.get("jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements");
                Path destination = destinatinPAth.resolve(app.jobOpening().getJobReference().fullReference() + ".txt");
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                String fileName = app.jobOpening().getJobReference().fullReference() + ".txt";
                app.setCandidateRequirements(fileName);
            } else {
                System.out.println("Error: File didn't match grammar");
            }
        } catch (IOException e) {
            System.err.println("Error generating file" + e.getMessage());
        }
        applicationRepo.save(app);
    }

}