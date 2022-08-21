package org.oauth2.tests.utils;

import java.util.Properties;

public class ConfigManager {
    private final Properties properties;
    private static ConfigManager configManager;
    private ConfigManager(){
        properties=ProperyUtils.getProperties("src/test/resources/data.properties");

    }

    public static ConfigManager getInstance(){
        if(configManager==null){
            configManager=new ConfigManager();
        }
        return configManager;
    }
public String getUserID(){
        String userid=properties.getProperty("userid");
        if(userid==null){
            throw new RuntimeException("Error fetching userid");

        }
    return userid;
}
}
