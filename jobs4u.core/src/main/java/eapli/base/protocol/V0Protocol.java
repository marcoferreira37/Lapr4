package eapli.base.protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class V0Protocol {

    private final ObjectInputStream input;

    private final ObjectOutputStream output;

    private static final byte VERSION = 0;
    private final Socket theSocket;

    /**
     * Constructor
     *
     * @param theSocket the communication socket
     * @throws IOException IOException
     */
    public V0Protocol(Socket theSocket) throws IOException {

        this.theSocket = theSocket;

        output = new ObjectOutputStream(theSocket.getOutputStream());
        input = new ObjectInputStream(theSocket.getInputStream());
    }

    /**
     * Send a packet to the server
     *
     * @param code   the code
     * @param object the object
     * @throws IOException            IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public void send(byte code, Object object) throws IOException, ClassNotFoundException {

        output.writeObject(new Packet(VERSION, code, object));

        Packet ack = (Packet) input.readObject();

        if (ack.getCode() != ComCodes.ACK.getValue()) {

            theSocket.close();

            throw new IOException("There was an error while communicating... Closing Socket");

        }
    }

    /**
     * Receive a packet from the server
     *
     * @param expectedCode the expected code
     * @param <T>          the type of the object
     * @return the object received
     * @throws IOException            IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public <T> T receive(byte expectedCode) throws IOException, ClassNotFoundException {

        Packet packet = (Packet) input.readObject();

        if (expectedCode != packet.getCode()) {

            output.writeObject(new Packet(VERSION, ComCodes.ERROR.getValue(), ""));

            theSocket.close();

            throw new IOException("There was an error while communicating... Closing Socket");
        }
        output.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), ""));

        return (T) packet.obtainObject();
    }

    /**
     * Receive a packet from the server
     *
     * @return the packet received
     * @throws IOException            IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public Packet receive() throws IOException, ClassNotFoundException {

        Packet packet = (Packet) input.readObject();

        output.writeObject(new Packet(VERSION, ComCodes.ACK.getValue(), ""));

        return packet;
    }

    /**
     * Close the socket connection
     *
     * @throws IOException IOException
     */
    public void exit() throws IOException {

        this.theSocket.close();
    }
}
