package com.wcode.conference.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.wcode.conference.constant.ConferenceConstant.PATH_CONFIG_PROPERTIES;

public final class ConfigProperties {
    private static ConfigProperties instance;
    public static Properties prop;

    private ConfigProperties() {
        try{
            InputStream input = new FileInputStream(PATH_CONFIG_PROPERTIES);
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ConfigProperties getInstance() {
        if (instance == null) {
            instance = new ConfigProperties();
        }
        return instance;
    }


    public static Properties getProp() {
        return prop;
    }
}
