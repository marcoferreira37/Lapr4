package server.protocol;

public enum ComCodes {
    COMMTEST((byte) 0),
    DISCON((byte)1),
    ACK((byte)2),
    ERR((byte)3),
    AUTH((byte)4),
    LSTOPNS((byte)5) //List Job Openings
    ;

    private byte value;

    ComCodes(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
