package server.server.server;

import eapli.base.protocol.Packet;
import eapli.base.protocol.dto.JobOpeningDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.protocol.ComCodes;
import eapli.base.protocol.V0Protocol;
import eapli.base.protocol.dto.LoginDTO;


import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Customer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("///////////////////////////////////////");

        System.out.println("WELCOME TO JOBS4U!");

        V0Protocol protocol;
        Socket s = new Socket("127.0.0.1", 21782);

        protocol = new V0Protocol(s);
        do {

            System.out.println();

            System.out.print("Username: ");
            Scanner sc = new Scanner(System.in);
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            protocol.send(ComCodes.AUTH.getValue(), new LoginDTO(username, password, BaseRoles.CUSTOMER));
            protocol.receive(ComCodes.ACK.getValue());
            protocol.send(ComCodes.LSTOPNS.getValue(), "");

            System.out.println("Wait a moment please...");
            Map<JobOpeningDTO,Integer> jobs = protocol.receive(ComCodes.LSTOPNS.getValue());
            for(Map.Entry<JobOpeningDTO,Integer> job : jobs.entrySet()){
                System.out.println("Reference: " + job.getKey().jobReference + " | Title: " + job.getKey().titleOrFunction + " | Creation date: " + job.getKey().creationDate + " | Number of Applications: " + job.getValue());
            }
            protocol.send(ComCodes.DISCONNECT.getValue(),"");
            protocol.exit();

            break;

        } while (true);

        System.out.println();


        protocol.exit();

    }
}
