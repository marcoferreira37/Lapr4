package server.server.server;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.protocol.Packet;
import eapli.base.protocol.dto.JobOpeningDTO;
import eapli.base.protocol.dto.JobOpeningMapper;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.base.usermanagement.application.controllers.ListJobOpeningController;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.base.protocol.ComCodes;
import eapli.base.protocol.dto.LoginDTO;

import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class ServerProtocolHandler extends Handler {

    private final ListJobOpeningController jobOpeningController = new ListJobOpeningController();
    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    public ServerProtocolHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void handle() {
        try {
            if (!authenticate()) {
                disconnect();
                return;
            }

            protocolV0.send(ComCodes.ACK.getValue(), "Welcome to the server!");
            boolean communicating = true;

            while (communicating) {
                Packet packet = protocolV0.receive();
                communicating = processPacket(packet);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private boolean authenticate() throws IOException, ClassNotFoundException {
        LoginDTO credentials = this.protocolV0.receive(ComCodes.AUTH.getValue());
        Optional<UserSession> session = authenticationService.authenticate(credentials.username, credentials.password, credentials.roles);

        return session.isPresent();
    }

    private void disconnect() throws IOException, ClassNotFoundException {
        this.protocolV0.send(ComCodes.DISCONNECT.getValue(), "");
    }

    private boolean processPacket(Packet packet) throws IOException, ClassNotFoundException {
        return switch (packet.getCode()) {
            case 0 -> {
                protocolV0.send(ComCodes.COMMUNICATIONTEST.getValue(), "Hello!");
                yield true;
            }
            case 1 -> {
                protocolV0.exit();
                yield false;
            }
            case 2 -> {
                System.out.println("Random Ack received");
                yield true;
            }
            case 3 -> {
                handleError(packet);
                yield true;
            }
            case 4 -> {
                handleAuthRetry();
                yield false;
            }
            case 5 -> {
                listJobOpenings();
                yield true;
            }
            default -> {
                System.out.println("Received a packet with code " + packet.getCode());
                yield true;
            }
        };
    }

    private void handleError(Packet packet) throws IOException, ClassNotFoundException {
        Exception e = packet.obtainObject();
        System.out.println("Error received: " + e.getMessage());
        e.printStackTrace();
    }

    private void handleAuthRetry() throws IOException, ClassNotFoundException {
        System.out.println("Another auth attempt... Disconnecting...");
        protocolV0.send(ComCodes.DISCONNECT.getValue(), "");
        protocolV0.exit();
    }

    private void listJobOpenings() throws IOException, ClassNotFoundException {
        ApplicationService applicationService = new ApplicationService();
        List<JobOpening> jobOpenings = jobOpeningController.showJobOpenings(authorizationService.session().get().authenticatedUser());
        Map<JobOpeningDTO,Integer> jobs = new HashMap<>();
        JobOpeningProcessRepository jobProcessRepository = PersistenceContext.repositories().jobProcessRepository();
        for(JobOpening job: jobOpenings){
            JobOpeningProcess process = jobProcessRepository.findJobProcessByJobOpening(job);
            int applications = applicationService.getApplicationsByJobOpening(job).size();
            JobOpeningDTO jobDto = JobOpeningMapper.toDTO(job,process);
            jobs.put(jobDto,applications);
        }
        protocolV0.send(ComCodes.LSTOPNS.getValue(), jobs);
    }
}
