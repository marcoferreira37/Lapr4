package server.server.server;


import java.util.Properties;
import java.util.concurrent.Semaphore;

public class ServerSemaphore {

    private static ServerSemaphore instance;
    private final Semaphore semaphore;

    /**
     * Constructor
     * @param semaphore the semaphore
     */
    private ServerSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * Get the instance of the ServerSemaphore
     * @return the instance
     */
    public static ServerSemaphore getInstance() {
        if (instance == null) {
            synchronized (ServerSemaphore.class) {
                if (instance != null) return instance;
                Properties props = System.getProperties();
                return new ServerSemaphore(new Semaphore( Integer.parseInt(props.getOrDefault("server.connections.max", 10).toString())));
            }
        }
        return instance;
    }

    /**
     * Enter the critical section
     * @throws InterruptedException InterruptedException
     */
    public void enterCriticalSection() throws InterruptedException {
        this.semaphore.acquire();
    }

    /**
     * Exit the critical section
     */
    public void exitCriticalSection() {
        this.semaphore.release();
    }


}
