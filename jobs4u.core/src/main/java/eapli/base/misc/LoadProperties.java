package eapli.base.misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadProperties.class);

    private LoadProperties() {
        // ensure utility
    }

    public static void exec() {
        Properties sysProps = System.getProperties();
        try {
            sysProps.load(LoadProperties.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            LOGGER.warn("Could not load application.properties file. Using system properties.");
        }
        System.setProperties(sysProps);
    }


}