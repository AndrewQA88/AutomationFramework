package configs;

import java.io.*;
import java.util.Properties;

public class PropertyFileReader {
    private final Properties properties;

    public PropertyFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "autotest.properties";
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
            throw new RuntimeException(e.getMessage() + " configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getProperty(String propertyName) {
        String url = properties.getProperty(propertyName);
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("property " + "'" + propertyName + "'" + " is not specified in the configuration.properties file.");
        }
    }
}
