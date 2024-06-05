package eapli.base.server.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public abstract class Handler implements Runnable {


    private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    protected V0Protocol protocol;
    private Socket socket;

    //
    public Handler(Socket socket) throws IOException {
        this.socket = socket;
        protocol = new V0Protocol(socket);
    }


    public abstract void handle();


    @Override
    public void run() {
        try {
            handle();
            ServerSemaphore.getInstance().exitCriticalSection();
        } catch (Exception e) {
            LOGGER.error("There was an error during handler. Closing connection...");
            try {
                socket.close();
            } catch (IOException ex) {
                LOGGER.error("There was an error closing socket. Ignoring closing...");
                return;
            }
            LOGGER.info("Socket closed successfully!");
        }
    }


}
