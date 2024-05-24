package eapli.base.usermanagement.application;

import com.fasterxml.jackson.databind.ser.Serializers;
import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;

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
}
