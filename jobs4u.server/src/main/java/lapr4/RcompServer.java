package lapr4;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.misc.LoadProperties;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import lapr4.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class RcompServer {

    private static final Logger DATABASE_LOGGER = LoggerFactory.getLogger(RcompServer.class);
    private static final int PORT = 10004;

    public static void main(String[] args) throws InterruptedException {
        try {
            Server server = new Server(PORT);
            System.out.println("press ENTER to stop server");
            init();
           // Thread.sleep(5*1000); //Sleep for 5 seconds
            Thread thread = new Thread(server);
            thread.setDaemon(true);
            thread.start();
            Scanner sc = new Scanner(System.in);
            System.out.println("press ENTER to stop server");
            sc.nextLine();
            server.stop();
            stop(thread);
        } catch (IOException e) {
            System.out.println("Could not bind to port " + PORT);
            System.out.println("Exiting the application...");
        }
    }


    public static void init() {
        System.out.println("Initializing server...");
        AuthzRegistry.configure(PersistenceContext.repositories().users(),  new BasePasswordPolicy(),
                new PlainTextEncoder());
        LoadProperties.exec();
    }

    public static void stop(Thread thread){
        thread.interrupt();
    }
}