package server.server.server;

import eapli.base.protocol.ComCodes;

import java.io.IOException;
import java.net.Socket;

public class SimpleHandler extends Handler {
    /**
     * Constructor
     * @param socket the socket
     * @throws IOException IOException
     */
    public SimpleHandler(Socket socket) throws IOException {
        super(socket);
    }

    /**
     * Handle the request
     */
    @Override
    public void handle() {
        System.out.println("Hello World! I am Alive!");
        try {
            String str = this.protocolV0.receive(ComCodes.COMMUNICATIONTEST.getValue());
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
