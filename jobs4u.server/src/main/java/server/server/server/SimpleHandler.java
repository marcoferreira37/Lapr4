package server.server.server;

import server.protocol.ComCodes;

import java.io.IOException;
import java.net.Socket;

public class SimpleHandler extends Handler {
    public SimpleHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void handle() {
        System.out.println("Hello World! I am Alive!");
        try {
            String str = this.protocol.receive(ComCodes.COMMTEST.getValue());
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
