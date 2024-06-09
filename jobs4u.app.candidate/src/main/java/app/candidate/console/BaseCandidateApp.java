/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package app.candidate.console;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.protocol.ComCodes;
import eapli.base.protocol.Notifications;
import eapli.base.protocol.V0Protocol;
import eapli.base.protocol.dto.LoginDTO;
import eapli.base.usermanagement.domain.BaseRoles;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Base User App.
 */
@SuppressWarnings("squid:S106")
public final class BaseCandidateApp {
    static Socket socket;
    static V0Protocol protocol;

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    private BaseCandidateApp() {
    }

    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        System.out.println("=====================================");
        System.out.println("Base Candidate App");
        System.out.println("(C) 2016 - 2019");
        System.out.println("Fiscos Imortalized!");
        System.out.println("=====================================");

        //AuthzRegistry.configure(PersistenceContext.repositories().users(),
        //      new BasePasswordPolicy(), new PlainTextEncoder());

        // new FrontMenu().show();
        // exiting the application, closing all threads

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
                protocol.send(ComCodes.AUTH.getValue(), new LoginDTO(userName, password, BaseRoles.CANDIDATE));
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
                    System.out.println("1- List Applications");
                    System.out.println("2- Exit");
                    Scanner scanner = new Scanner(System.in);
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            protocol.send(ComCodes.LSTAPPS.getValue(), "");
                            Map<JobOpeningApplication, Integer> apps = protocol.receive(ComCodes.LSTAPPS.getValue());
                            for (JobOpeningApplication app : apps.keySet()) {

                                System.out.println("Reference: " + app.jobOpening.getJobReference().fullReference() + " | State: " + app.status().name() + " | Number of applicants: " + apps.get(app));
                            }
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
