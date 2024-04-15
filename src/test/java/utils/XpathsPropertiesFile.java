package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class XpathsPropertiesFile {
    private Properties properties;

    public XpathsPropertiesFile(String subFolder, String fileName) {
        setProperties(subFolder, fileName);
    }

    private void setProperties(String subFolder, String fileName) {
        String configFilePath = String.format("src//test//resources//constants//xpaths//%s//%s", subFolder, fileName);
        File ConfigFile = new File(configFilePath);

        try {
            FileInputStream configFileReader = new FileInputStream(ConfigFile);
            properties = new Properties();

            try {
                properties.load(configFileReader);
                configFileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("config.properties not found at config file path " + configFilePath);
        }
    }

    public String getXpath(String xpathName) {
        return properties.getProperty(xpathName);
    }
}
