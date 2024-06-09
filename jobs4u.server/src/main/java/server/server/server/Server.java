package server.server.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server implements Runnable {
    private final static ThreadGroup serverThreadGroup = new ThreadGroup("server-thread-group");

    /**
     * Server socket
     * A server socket is a way to create a server that listens for incoming connections.
     */
    private final ServerSocket socket;
    private boolean running;

    /**
     * Constructor
     * @param port the port
     * @throws IOException IOException
     */
    public Server(int port) throws IOException {
        socket = new ServerSocket(port);
        socket.setSoTimeout(2000); // Se não receber conecçao em 2 sec segue o programa ok cruch fixe :(
        running = false;
    }

    /**
     * Start the server
     */
    public void start() {
        running = true;
        EmailsToSendThread emaisToSendThread ;
        while (running) {
            emaisToSendThread = new EmailsToSendThread();
            emaisToSendThread.start(); //aqui ele inicia o thread dos emails
            try {
                Socket connection = socket.accept(); //aqui ele recebe um connection ne
                ClientThread clientThread = new ClientThread(connection); // dps entra aqui a us do ahh e do tua lipa tao aqui
                clientThread.run();
                if (!running) return; //Force exit new connections TODO: Add exit handler to communicate server shutdown
                ServerSemaphore.getInstance().enterCriticalSection();
                Thread thread = new Thread(serverThreadGroup, new ServerProtocolHandler(connection)); // e so dps aqui mas as do bento acho q tao aqui
                thread.start();
            }catch (SocketTimeoutException e){

            } catch (IOException e) {
                System.out.println("Could not accept new connection! Sorry! Try again later!");
            } catch (InterruptedException e) {
                System.out.println("Could not wait for connection");
                System.out.println("Listening to new ones...");
            }
        }
    }

    /**
     * Stop the server
     */
    public void stop() {
        this.running = false;
    }

    /**
     * Run the server
     */
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
