package eapli.base.protocol;

public enum ComCodes {
    COMMTEST((byte) 0),
    DISCON((byte)1),
    ACK((byte)2),
    ERR((byte)3),
    AUTH((byte)4),
    LSTOPNS((byte)5),//List Job Openings

    LSTAPPS((byte)6), //List Applications

    NOTIF((byte)7), //Notification
    ;

    private byte value;

    ComCodes(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
