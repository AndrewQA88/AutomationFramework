package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonParser {

    private static final Logger LOG = Logger.getLogger(JacksonParser.class);

    public static Car parseCarFromJsonToObject(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car();
        try {
            car = objectMapper.readValue(json, Car.class);
            LOG.info(car.toString());
        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage(), e);
        }
        return car;
    }

    public static void convertCarObjectToJson(Car car, File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, car);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
