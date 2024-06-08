package server.server;

import eapli.base.AppSettings;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.server.server.PropertiesLoader;
import server.server.server.Server;

import java.io.IOException;
import java.util.Scanner;

public class FollowupServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowupServer.class);
    private static final int PORT = 21782;

    /**
     * Main method
     * @param args the arguments
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("Good Morning :) ");
            Server server = new Server(PORT);
            System.out.println("If you want to stop the server, press ENTER! Thank you!");
            init();
            Thread thread = new Thread(server);
            thread.setDaemon(true);
            thread.start();
            Scanner sc = new Scanner(System.in);
            System.out.println("If you want to stop the server, press ENTER! Thank you!");
            sc.nextLine();
            server.stop();
            stop(thread);
        } catch (IOException e) {
            System.out.println("Could not bind to port " + PORT);
            System.out.println("Goodbye! Thanks for using our application!!");
        }
    }

    /**
     * Initialize the server
     */
    public static void init() {
        System.out.println("Initializing server...");
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());
        PropertiesLoader.load();
        new AppSettings();
    }

    /**
     * Stop the thread
     * @param thread the thread
     */
    public static void stop(Thread thread) {
        thread.interrupt();
    }
}