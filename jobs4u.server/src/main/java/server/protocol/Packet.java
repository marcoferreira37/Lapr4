package server.protocol;

import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Packet implements Serializable {

    private final byte version;

    private final byte code;

    private final List<Chunk> chunks;

    private final static int LEN_L_MAX = 255;
    private final static int LEN_M_MAX = 255;
    private final static int LEN_MAX = LEN_L_MAX + 256 * LEN_M_MAX;


    public Packet(byte version, byte code, List<Chunk> chunks) {
        this.version = version;
        this.code = code;
        this.chunks = chunks;
    }

    public Packet(byte version, byte code, Object obj) throws IOException {
        this.version = version;
        this.code = code;
        this.chunks = chunkerize(obj);
    }


    public List<Chunk> chunkerize(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(obj);
        byte[] payload = bos.toByteArray();
        List<Chunk> chunks = new ArrayList<>();
        int index = 0;
        List<Byte> bytes = new ArrayList<>();
        for (int i = 0; i < payload.length; i++) {
            if (index == LEN_MAX) {
                byte[] chunkPayload = new byte[bytes.size()];
                for (int i1 = 0; i1 < bytes.size(); i1++) {
                    chunkPayload[i1] = bytes.get(i1);
                }
                chunks.add(new Chunk((byte) -1, (byte) -1, chunkPayload));
                index = 0;
                bytes = new ArrayList<>();
            }

            bytes.add(payload[index]);
            index++;
        }

        if (!bytes.isEmpty()) {
            byte[] chunkPayload = new byte[bytes.size()];
            for (int i1 = 0; i1 < bytes.size(); i1++) {
                chunkPayload[i1] = bytes.get(i1);
            }
            chunks.add(new Chunk(((byte) (chunkPayload.length % 256)), ((byte) (chunkPayload.length / 256)), chunkPayload));
        }
        return chunks;
    }


    public <T> T obtainObject() throws IOException, ClassNotFoundException, ClassCastException {
        List<Byte> bytes = new ArrayList<>();
        for (Chunk chunk : chunks) {
            for (byte b : chunk.payload) {
                bytes.add(b);
            }
        }
        byte[] payload = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            payload[i] = bytes.get(i);
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(payload);
        ObjectInputStream oin = new ObjectInputStream(bis);
        return (T) oin.readObject();
    }


}
