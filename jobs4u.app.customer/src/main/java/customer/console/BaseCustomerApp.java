
package customer.console;

import eapli.base.protocol.ComCodes;
import eapli.base.protocol.Notifications;
import eapli.base.protocol.V0Protocol;
import eapli.base.protocol.dto.LoginDTO;
import eapli.base.usermanagement.domain.BaseRoles;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 * Base User App.
 */
@SuppressWarnings("squid:S106")
public final class BaseCustomerApp {

    static Socket socket;

    static V0Protocol protocol;

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    private BaseCustomerApp() {

    }

    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        System.out.println("=====================================");
        System.out.println("Base Customer App");
        System.out.println("(C) 2016 - 2019");
        System.out.println("Fiscos live forever!");
        System.out.println("=====================================");
        List<Notifications> notificationsList;
        int option;
        boolean flag;
        do {
            socket = new Socket("127.0.0.1", 21782);
            protocol = new V0Protocol(socket);
            try {
                System.out.println("What is your username?");
                Scanner scanner = new Scanner(System.in);
                String userName = scanner.nextLine();
                System.out.println("What is your password?");
                String password = scanner.nextLine();
                protocol.send(ComCodes.AUTH.getValue(), new LoginDTO(userName, password, BaseRoles.CUSTOMER));
                protocol.receive(ComCodes.ACK.getValue());
                flag = true;
            } catch (Exception e) {
                System.out.println("Invalid username or password. Try again.");
                flag = false;
            }
            if (flag) {
                protocol.send(ComCodes.NOTIF.getValue(), "");
                notificationsList = protocol.receive(ComCodes.NOTIF.getValue());
                if (!notificationsList.isEmpty()) {
                    for (Notifications notification : notificationsList) {
                        System.out.println(notification.content());
                    }
                }
                do {
                    System.out.println("1- List Job Openings");
                    System.out.println("2- Exit");
                    Scanner scanner = new Scanner(System.in);
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            break;
                        case 2:
                            protocol.send(ComCodes.DISCONNECT.getValue(), null);
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                } while (option != 2);
            }
        } while (!flag);
        System.exit(0);

    }
}
