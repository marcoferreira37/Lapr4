package server.server.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {


    private static final Logger LOGG = LoggerFactory.getLogger(PropertiesLoader.class);

    /**
     * Private constructor to hide the implicit public one
     */
    private PropertiesLoader() {
        // ensure utility
    }

    /**
     * Load properties from application.properties file
     */
    public static void load() {
        Properties sysProps = System.getProperties();
        try {

            sysProps.load(PropertiesLoader.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {

            LOGG.warn("Sorry! Could not load application.properties file! Using default properties.");
        }
        System.setProperties(sysProps);
}


}