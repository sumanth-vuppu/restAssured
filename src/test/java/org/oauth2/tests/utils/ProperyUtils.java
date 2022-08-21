package org.oauth2.tests.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ProperyUtils {
    public static Properties getProperties(String filename){
        Properties properties=new Properties();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filename));
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

return  properties;
    }
}
