package server.server.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLoader.class);

    private PropertiesLoader() {
        // ensure utility
    }

    public static void load() {
        Properties sysProps = System.getProperties();
        try {
            sysProps.load(PropertiesLoader.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            LOGGER.warn("Could not load application.properties file. Using system properties.");
        }
        System.setProperties(sysProps);
}


}