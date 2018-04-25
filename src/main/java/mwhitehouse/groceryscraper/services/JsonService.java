package mwhitehouse.groceryscraper.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mwhitehouse.groceryscraper.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mwhitehouse on 25/04/2018.
 */
@Service
public class JsonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonService.class);

    @Autowired
    private ObjectMapper mapper;

    public void printResponseAsPrettyJson(Response response) {
        try {
            LOGGER.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
        } catch (JsonProcessingException e) {
            LOGGER.error("Problem parsing response JSON", e);
        }
    }
}
