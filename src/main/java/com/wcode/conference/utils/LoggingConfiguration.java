package com.wcode.conference.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

import static com.wcode.conference.constant.ConferenceConstant.PATH_LOG_PROPERTIES;

public final class LoggingConfiguration {
    private static LoggingConfiguration instance;
    private static Logger LOGGER = Logger.getLogger(LoggingConfiguration.class.getName());


    private LoggingConfiguration() {
        try{
            InputStream stream = LoggingConfiguration.class.getClassLoader()
                    .getResourceAsStream(PATH_LOG_PROPERTIES);
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static LoggingConfiguration getInstance() {
        if (instance == null) {
            instance = new LoggingConfiguration();
        }
        return instance;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }
}
