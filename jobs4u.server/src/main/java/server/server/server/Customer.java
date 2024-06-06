package server.server.server;

import eapli.base.protocol.Packet;
import eapli.base.protocol.dto.JobOpeningDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.protocol.ComCodes;
import eapli.base.protocol.V0Protocol;
import eapli.base.protocol.dto.LoginDTO;


import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Customer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("///////////////////////////////////////");

        System.out.println("WELCOME TO JOBS4U!");

        V0Protocol protocol;
        do {
            System.out.println();

            System.out.print("Username: ");
            Scanner sc = new Scanner(System.in);
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            System.out.println("Wait a moment please...");
            Socket s = new Socket("127.0.0.1", 10792);
            protocol = new V0Protocol(s);
            protocol.send(ComCodes.AUTH.getValue(), new LoginDTO(username, password, BaseRoles.CUSTOMER_MANAGER));
            Packet p = protocol.receive();
            if (p.getCode() == ComCodes.DISCON.getValue()) {
                System.out.println("Invalid credentials. Try again!");
                protocol.exit();
                continue;
            }
            break;
        } while (true);
        System.out.println("Login Successful!");
        System.out.println();
        protocol.send(ComCodes.LSTOPNS.getValue(), "");
        List<JobOpeningDTO> jobsOp = protocol.receive(ComCodes.LSTOPNS.getValue());


        jobsOp.forEach(d ->
                System.out.println("Reference: "
                                   + d.findJobReference() + " | Name: " + d.findCompanyName() + " | Status: " + d.findStatus()));
        protocol.send(ComCodes.DISCON.getValue(), "");
        protocol.exit();
    }
}
