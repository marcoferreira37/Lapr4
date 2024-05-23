package lapr4.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class Handler implements Runnable {


    private static final Logger DATABASE_LOGGER = LoggerFactory.getLogger(Handler.class);

    private Socket serverSocket;

    //TODO Add coms protocol
    protected ObjectInputStream serverInput;
    protected ObjectOutputStream serverOutput;

    //
    public Handler(Socket socket) throws IOException {
        this.serverSocket = socket;
        this.serverInput = new ObjectInputStream(socket.getInputStream());
        this.serverOutput = new ObjectOutputStream(socket.getOutputStream());
    }


    public abstract void handle();


    @Override
    public void run() {
        try{
            handle();
            Semaphore.instance().deactivateCriticalSection();
        }catch (Exception e){
            DATABASE_LOGGER.error("Error while executing handler. Closing connection...");
            try {
                serverSocket.close();
            } catch (IOException ex) {
                DATABASE_LOGGER.error("There was an error closing socket. Ignoring closing...");
                return;
            }
            DATABASE_LOGGER.info("Socket closed successfully!");
        }
    }
}
