package server.server.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import eapli.base.protocol.V0Protocol;

import java.io.IOException;
import java.net.Socket;

public abstract class Handler implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    protected V0Protocol protocol;
    private final Socket socket;

    /**
     * Constructor
     * @param socket the socket
     * @throws IOException IOException
     */
    public Handler(Socket socket) throws IOException {
        this.socket = socket;
        protocol = new V0Protocol(socket);
    }

    /**
     * Handle the request
     */
    public abstract void handle();

    /**
     * Run the handler
     */
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
