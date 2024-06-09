package server.server.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            emaisToSendThread.start(); // agora é pra mandar mail quando? quando da rank? //ele ativa esta funcionalidade acho eu sozinho , mas é para avisar quando sairam os resultados // ent vamos a us de dar rank criar na tabela emailstosend falta issow
            // ru vou so alterar na base de dados os ranks das job openings e isto cria os emails e guarda na base de dados ? certo ? logo vai criar a tabela ao criar a entidade
            // calma falta por no persistence a tabela tens razão mas meteste no codigo do rank a criar emails na tabela? nop , é suposto ? sim é quando rodas a us de rank q mandas email então tenho que chamar os metodos do email service certo? sim e registe email meter na base de dados
            //
            try {
                Socket connection = socket.accept(); //aqui ele recebe um connection ne
                ClientThread clientThread = new ClientThread(connection); // dps entra aqui a us do ahh e do tua lipa tao aqui
                clientThread.run();
                if (!running) return; //Force exit new connections TODO: Add exit handler to communicate server shutdown
                ServerSemaphore.getInstance().enterCriticalSection();
                Thread thread = new Thread(serverThreadGroup, new ServerProtocolHandler(connection)); // e so dps aqui mas as do bento acho q tao aqui
                thread.start();
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
