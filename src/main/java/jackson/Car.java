package jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.log4j.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    private String color;
    private String type;
    private static String json = "{ \"_color\" : \"Black\", \"type\" : \"BMW\", \"engine\" : \"rotor\" }";

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
