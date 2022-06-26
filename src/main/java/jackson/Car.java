package jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.log4j.Logger;

import java.io.File;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    private String color;
    private String type;
    private static String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\", \"engine\" : \"rotor\" }";
    private static File file = new File("src" + File.separator + "main" + File.separator + "java" + File.separator
            + "jackson" + File.separator + "car.json");


    private static final Logger LOG = Logger.getLogger(Car.class);

    public Car() {
    }

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
