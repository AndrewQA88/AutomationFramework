package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonParser {

    private static final Logger LOG = Logger.getLogger(JacksonParser.class);

    public static void parseCarFromJsonToObject(Car car, String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            car = objectMapper.readValue(json, Car.class);
            LOG.info(car.getColor());
            LOG.info(car.getType());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void parseCarFromObjectToJson(Car car) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src\\main\\java\\jackson\\car.json"), car);
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
}
