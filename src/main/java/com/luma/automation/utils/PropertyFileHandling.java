package com.luma.automation.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandling {


        public static String property(String key) {

            Properties properties=new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream("src/test/resources/testDataFiles/data.properties");
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return key=properties.getProperty(key);
        }

}
