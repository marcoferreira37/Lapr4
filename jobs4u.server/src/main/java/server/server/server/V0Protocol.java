package server.server.server;

import server.protocol.ComCodes;
import server.protocol.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class V0Protocol {
    private static final byte VERSION = 0;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket commSocket;

    public V0Protocol(Socket commSocket) throws IOException {
        this.commSocket = commSocket;
        out = new ObjectOutputStream(commSocket.getOutputStream());
        in = new ObjectInputStream(commSocket.getInputStream());
    }


    public void send(byte code, Object object) throws IOException, ClassNotFoundException {
        out.writeObject(new Packet(VERSION, code, object));
        Packet ack = (Packet) in.readObject();
        if (ack.getCode() != ComCodes.ACK.getValue()) {
            commSocket.close();
            throw new IOException("There was an error while communicating... Closing Socket");
        }
    }

    public <T> T receive(byte expectedCode) throws IOException, ClassNotFoundException {
        Packet packet = (Packet) in.readObject();
        if (expectedCode != packet.getCode()) {
            out.writeObject(new Packet(VERSION, ComCodes.ERR.getValue(), ""));
            commSocket.close();
            throw new IOException("There was an error while communicating... Closing Socket");
        }
        out.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), ""));
        return (T) packet.obtainObject();
    }

    public Packet receive() throws IOException, ClassNotFoundException {
        Packet packet = (Packet) in.readObject();
        out.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), ""));
        return packet;
    }

    public void exit() throws IOException {
        this.commSocket.close();
    }
}

