package eapli.base.protocol;

import java.io.Serializable;

public class Chunk implements Serializable {

    byte lennL;

    byte lenM;

    byte[] payload;

    public Chunk(byte lennL, byte lenM, byte[] payload) {
        this.lennL = lennL;
        this.lenM = lenM;
        this.payload = payload;
    }
}
