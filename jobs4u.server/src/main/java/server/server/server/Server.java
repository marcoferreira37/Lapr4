package server.server.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
    private final static ThreadGroup serverThreadGroup = new ThreadGroup("server-thread-group");
    private final ServerSocket socket;
    private boolean running;

    public Server(int port) throws IOException {
        socket = new ServerSocket(port);
        running = false;
    }

    public void start() {
        running = true;
        while (running) {
            try {
                Socket connection = socket.accept();
                if (!running) return; //Force exit new connections TODO: Add exit handler to communicate server shutdown
                ServerSemaphore.getInstance().enterCriticalSection();
                Thread thread = new Thread(serverThreadGroup, new ServerProtocolHandler(connection));
                thread.start();
            } catch (IOException e) {
                System.out.println("Could not accept new connection!");
            } catch (InterruptedException e) {
                System.out.println("Could not wait for connection. Listening to new ones...");
            }
        }
    }

    public void stop() {
        this.running = false;
    }


    @Override
    public void run() {
        start();
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
