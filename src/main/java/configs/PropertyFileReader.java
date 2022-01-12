package configs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    private final Properties properties;

    public PropertyFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/main/resources/autotest.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getProperty(String property) {
        String url = properties.getProperty(property);
        if (url != null) return url;
        else {
            throw new RuntimeException("property not specified in the configuration.properties file.");
        }
    }
}
