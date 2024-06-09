package server.server.server;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.protocol.ComCodes;
import eapli.base.protocol.Notifications;
import eapli.base.protocol.Packet;
import eapli.base.protocol.dto.LoginDTO;
import eapli.base.repositories.ListApplicationsController;
import eapli.base.usermanagement.application.services.NotificationAppService;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClientThread extends Thread {
    private static final Byte VERSION = 0;

    private final Socket socket;
    private final ObjectInputStream input;
    private final ObjectOutputStream output;


    private final NotificationAppService notificationAppService = new NotificationAppService();
    private final AuthenticationService authorizationService = AuthzRegistry.authenticationService();

    private final ListApplicationsController applicationsController = new ListApplicationsController();

    /**
     * Constructor
     *
     * @param socket the socket
     * @throws IOException IOException
     */
    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        try {
            this.input = new ObjectInputStream(socket.getInputStream());
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void run() {
        Iterable<Notifications> notifications;
        Optional<UserSession> session;
        boolean comms;
        try {
            Packet packet = (Packet) input.readObject();
            LoginDTO loginDTO = packet.obtainObject();
            session = authorizationService.authenticate(loginDTO.username, loginDTO.password, loginDTO.roles);
            output.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), ""));
            if (session.isEmpty()) {
                output.writeObject(new Packet(VERSION, ComCodes.DISCONNECT.getValue(), ""));
                return;
            }
            output.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), ""));
            comms = true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (comms) {
            Packet p = null;
            try {
                p = (Packet) input.readObject();
                System.out.println(p);
                switch (p.getCode()) {
                    case 0:
                        //COMMUNICATION TEST

                        try {
                            output.writeObject(new Packet(VERSION, ComCodes.COMMUNICATIONTEST.getValue(), "Welcome user"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 1:
                        //DISCONNECTION
                        comms = false;
                        output.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), "Connecting to server"));
                        try {
                            socket.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        //ACK
                        System.out.println("Random ACK received");
                        break;
                    case 3:
                        //ERROR
                        Exception e = null;
                        try {
                            e = p.obtainObject();
                        } catch (IOException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        System.out.println("Error recieved: " + e.getMessage());
                        e.printStackTrace();
                        break;
                    case 4:
                        //AUTH
                        System.out.println("Another auth attempt detected. Disconnecting...");
                        try {
                            output.writeObject(new Packet(VERSION, ComCodes.DISCONNECT.getValue(), ""));
                            comms = false;
                            socket.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 5:
                        //List Job Openings
                        //Map<JobOpening, Integer> openings = jobopController.listJobOpenings(session.get().authenticatedUser());
                        //out.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), "Connecting to server"));
                        //out.writeObject(new Packet(VERSION, ComCodes.LSTOPNS.getValue(), openings));


                        break;
                    case 6:
                        //List Applications
                        output.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), "Connecting to server"));

                        try {
                            Candidate c = applicationsController.getCandidateBySession(session.get().authenticatedUser());
                            List<JobOpeningApplication> listApps = applicationsController.allApplicationBySystemUser(c);
                            Map<JobOpeningApplication, Integer> map = applicationsController.returnMap(listApps);
                            output.writeObject(new Packet(VERSION, ComCodes.LSTAPPS.getValue(), map));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }


                        break;
                    case 7:
                        //Notifications
                        output.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), "Connecting to server"));
                        notifications = notificationAppService.findBySend(false);
                        List<Notifications> notf = new ArrayList<>();
                        for (Notifications notification : notifications) {
                            if (notification.username().equals(session.get().authenticatedUser().username().toString())) {
                                notificationAppService.setSendTrue(notification);
                                notf.add(notification);
                            }
                        }
                        output.writeObject(new Packet(VERSION, ComCodes.NOTIF.getValue(), notf));
                        break;

                    default:
                        System.out.println("Received a packet with code " + p.getCode());
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException();
            }
        }
    }
}
