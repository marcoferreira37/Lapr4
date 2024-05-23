package lapr4.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private static final Logger DATABASE_LOGGER = LoggerFactory.getLogger(Server.class);
    private static ThreadGroup serverThreadGroup = new ThreadGroup("server-thread-group");
    private ServerSocket serverSocket;
    private boolean exectuing;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        exectuing = false;
    }

    public void execute() {
        exectuing = true;
        while (exectuing) {
            try {
                Socket serverSocketConnection = serverSocket.accept();
                if (!exectuing) return; //Force exit new connections TODO: Add exit handler to communicate server shutdown
                Semaphore.instance().activateCriticalSection();
                Thread thread = new Thread(serverThreadGroup, new SimpleHandler(serverSocketConnection));
                thread.start();
            } catch (IOException e) {
                System.out.println("Could not accept new connection!");
            } catch (InterruptedException e) {
                System.out.println("Could not wait for connection. Listening to new ones...");
            }
        }
    }

    public void stop() {
        this.exectuing = false;
    }


    @Override
    public void run() {
        execute();
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
