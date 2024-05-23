package lapr4.server;

import java.io.IOException;
import java.net.Socket;

public class SimpleHandler extends Handler{
    public SimpleHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void handle() {
        System.out.println("Hello World! I am Alive!");
        try {
            System.out.println(this.serverInput.readObject().toString());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
