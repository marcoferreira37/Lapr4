package lapr4.garbageServer.server;



import java.util.Properties;
import java.util.concurrent.Semaphore;

public class SemaphoreServer {

    private static SemaphoreServer instance;
    private Semaphore semaphore;

    private SemaphoreServer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public static SemaphoreServer instance() {
        if (instance == null) {
            synchronized (SemaphoreServer.class) {
                if (instance != null) return instance;
                Properties props = System.getProperties();
                return new SemaphoreServer(new Semaphore( Integer.parseInt(props.getOrDefault("server.connections.max", 10).toString())));
            }
        }
        return instance;
    }


    public void activateCriticalSection() throws InterruptedException {
        this.semaphore.acquire();
    }

    public void deactivateCriticalSection() {
        this.semaphore.release();
    }


}
