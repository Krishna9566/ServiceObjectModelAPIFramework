package com.spotify.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum ConfigManager {

    INSTANCE;  //creates internally object like configmanager INSTANCE = new configmanager();
    private final Properties properties = new Properties();
    private static final String FILE_NAME = "spotifyauth.properties";

    ConfigManager() {  //private by default - prevents object creation
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(FILE_NAME)) {
            if (input == null) {
                throw new RuntimeException("Property file not found: " + FILE_NAME);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + FILE_NAME, e);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);
        if(value==null)
            throw new IllegalArgumentException("Key is missing in the property file .." +key);
        return value;
    }
}
