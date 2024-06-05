package server.server.server;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.protocol.Packet;
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
        System.out.println("Seja bem vindo ao seu fim!");
        System.out.println("Antes de morrer providencie as suas credencias para podermos hackear a sua conta bancária!");
        V0Protocol protocol;
        do {
            System.out.println();
            System.out.print("Username: ");
            Scanner sc = new Scanner(System.in);
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            System.out.println("Agora que já temos as suas credenciais, vamos hackear a sua conta bancária!");
            System.out.println("Aguarde um momento...");
            Socket s = new Socket("127.0.0.1", 10792);
            protocol = new V0Protocol(s);
            protocol.send(ComCodes.AUTH.getValue(), new LoginDTO(username, password, BaseRoles.CUSTOMER_MANAGER));
            Packet p = protocol.receive();
            if (p.getCode() == ComCodes.DISCON.getValue()) {
                System.out.println("Credenciais inválidas! Tente novamente!");
                protocol.exit();
                continue;
            }
            break;
        } while (true);
        System.out.println("Agora que já hackeamos a sua conta bancária, vamos listar as job openings para poder ganhar mais dinheiro!");
        protocol.send(ComCodes.LSTOPNS.getValue(), "");
        List<JobOpening> jobsOp = protocol.receive(ComCodes.LSTOPNS.getValue());
        System.out.println("As suas oportunides de emprego são:");
        jobsOp.forEach(d -> System.out.println("Reference: " + d.getJobReference().fullReference() + " | Name: " + d.getCompany().toString()));
        System.out.println("Agora que já sabe as suas oportunidades de emprego, vamos hackear a sua conta bancária! Continuação de um bom dia!");
        protocol.send(ComCodes.DISCON.getValue(), "");
        protocol.exit();
    }
}
