package server.server.server;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.protocol.Packet;
import eapli.base.protocol.dto.JobOpeningDTO;
import eapli.base.protocol.dto.JobOpeningMapper;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.base.usermanagement.application.controllers.ListJobOpeningController;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.base.protocol.ComCodes;
import eapli.base.protocol.dto.LoginDTO;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServerProtocolHandler extends Handler {

    private final ListJobOpeningController controller = new ListJobOpeningController();
    private final AuthenticationService auth = AuthzRegistry.authenticationService();
    private final AuthorizationService autz = AuthzRegistry.authorizationService();

    public ServerProtocolHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void handle() {
        try {
            LoginDTO credentials = this.protocol.receive(ComCodes.AUTH.getValue());
            Optional<UserSession> session = auth.authenticate(credentials.username, credentials.password, credentials.roles);
            if (session.isEmpty()) {
                //If login is invalid disconnect uwu
                this.protocol.send(ComCodes.DISCON.getValue(), "");
                return;
            }
            this.protocol.send(ComCodes.ACK.getValue(), "Hello from the other side, server!");
            boolean communicating = true;
            while (communicating) {
                Packet p = this.protocol.receive();
                switch (p.getCode()) {
                    case 0:
                        //COMTEST
                        protocol.send(ComCodes.COMMTEST.getValue(), "Hello from the dark side!");
                        break;
                    case 1:
                        //DISCON
                        communicating = false;
                        protocol.exit();
                        break;
                    case 2:
                        //ACK
                        System.out.println("Random Ack recieved");
                        break;
                    case 3:
                        //ERR
                        Exception e = p.obtainObject();
                        System.out.println("Error recieved: " + e.getMessage());
                        e.printStackTrace();
                        break;
                    case 4:
                        //AUTH
                        System.out.println("Another auth attempt... Disconnecting...");
                        protocol.send(ComCodes.DISCON.getValue(), "");
                        communicating = false;
                        protocol.exit();
                        break;
                    case 5:
                        //List Job Openings
                        List<JobOpening> jobsOpenings = controller.showJobOpenings(autz.session().get().authenticatedUser());
                        List<JobOpeningDTO> dtos = new ArrayList<>(jobsOpenings.size());
                        JobOpeningMapper mapper = new JobOpeningMapper();
                        jobsOpenings.forEach(job -> {
                            // Fetch Job Opening Process
                            JobOpeningProcessRepository jobsOpeningProcess = PersistenceContext.repositories().jobProcessRepository();
                            dtos.add(JobOpeningMapper.toDTO(job, jobsOpeningProcess.findJobProcessByJobOpening(job)));
                            }
                        );
                        protocol.send(ComCodes.LSTOPNS.getValue(), dtos);
                        break;

                    default:
                        System.out.println("Received a packet with code " + p.getCode());
                }
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
