package lapr4.server;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.services.JobOpeningService;

import java.io.IOException;
import java.net.Socket;

public class SimpleHandler extends Handler{

    private final JobOpeningService service = new JobOpeningService();
    public SimpleHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void handle() {
        System.out.println("Connection Established!");
        try {
            System.out.println(this.serverInput.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
