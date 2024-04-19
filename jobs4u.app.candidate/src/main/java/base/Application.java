package base;

public class Application {

    public static final String VERSION = "1.4.0";
    public static final String COPYRIGHT = "(C) 2016 - 2021, ISEP's Professors of EAPLI";

    private static final AppSettings SETTINGS = new AppSettings();

    public static AppSettings settings() {
        return SETTINGS;
    }

    private Application() {
        // private visibility to ensure singleton & utility
    }
}
