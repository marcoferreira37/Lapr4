package eapli.base.protocol;

public enum ComCodes {
    COMMUNICATIONTEST((byte) 0), //Communication Test
    DISCONNECT((byte)1), //Disconnect
    ACK((byte)2), //Acknowledge
    ERROR((byte)3), //Error
    AUTH((byte)4), //Authentication
    LSTOPNS((byte)5),//List Job Openings

    LSTAPPS((byte)6), //List Applications

    NOTIF((byte)7), //Notification
    ;

    private final byte value;

    /**
     * Contructor
     * @param value value
     */
    ComCodes(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
