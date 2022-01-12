package configs;

import java.util.ResourceBundle;

public class ResourceBundleFileReader {

    private static final ResourceBundle rb = ResourceBundle.getBundle("autotest");

    public static String getProperty(String property) {
        return rb.getString(property);
    }
}
