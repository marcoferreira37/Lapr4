package eapli.base.server;

import eapli.base.AppSettings;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.server.server.PropertiesLoader;
import eapli.base.server.server.Server;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class FollowupServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowupServer.class);
    private static final int PORT = 10792;

    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("Good Morning :) ");
            Server server = new Server(PORT);
            System.out.println("If you want to stop the server, press ENTER! Thank you!");
            init();
            Thread.sleep(5 * 1000); //Sleep for 5 seconds
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
            System.out.println("Exiting the application...");
            System.out.println("Have a nice day ;)");
        }
    }


    public static void init() {
        System.out.println("Initializing server...");
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
                new PlainTextEncoder());
        PropertiesLoader.load();
        new AppSettings();
    }

    public static void stop(Thread thread) {
        thread.interrupt();
    }
}