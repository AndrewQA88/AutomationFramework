package jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    private String color;
    private String type;

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

    public static void fromObjectToJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "sedan");
        try {
            objectMapper.writeValue(new File("target/car.json"), car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String carAsString = objectMapper.writeValueAsString(car);
            LOG.info(carAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void fromJsonToObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\", \"engine\" : \"rotor\" }";
        try {
            Car car = objectMapper.readValue(json, Car.class);
            LOG.info(car.getColor());
            LOG.info(car.getType());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fromJsonToObject();
    }
}
