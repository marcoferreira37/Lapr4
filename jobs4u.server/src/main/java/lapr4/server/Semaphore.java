package lapr4.server;

import eapli.core.misc.PropertiesLoader;

import java.util.Properties;

public class Semaphore {

    private static Semaphore instance;
    private java.util.concurrent.Semaphore semaphore;

    private Semaphore(java.util.concurrent.Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public static Semaphore instance() {
        if (instance == null) {
            synchronized (Semaphore.class) {
                if (instance != null) return instance;
                Properties props = System.getProperties();
                return new Semaphore(new java.util.concurrent.Semaphore( Integer.parseInt(props.getOrDefault("server.connections.max", 10).toString())));
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
