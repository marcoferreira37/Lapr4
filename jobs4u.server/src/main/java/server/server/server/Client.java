package server.server.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket("127.0.0.1",21782);

        ObjectOutputStream welcome = new ObjectOutputStream(s.getOutputStream());

        welcome.writeObject("Good morning!! Welcome to Jobs4U!");

        s.close();

    }
}
