package eapli.base.protocol;

import java.io.Serializable;

public class Chunk implements Serializable {

    byte lennL;

    byte lenM;

    byte[] payload;

    /**
     * Constructor
     * @param lennL lennL
     * @param lenM  lenM
     * @param payload payload
     */
    public Chunk(byte lennL, byte lenM, byte[] payload) {
        this.lennL = lennL;
        this.lenM = lenM;
        this.payload = payload;
    }
}
