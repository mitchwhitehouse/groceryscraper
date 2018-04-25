package mwhitehouse.groceryscraper.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import mwhitehouse.groceryscraper.services.GroceryScraper;
import mwhitehouse.groceryscraper.services.sainsburys.SainsburysGroceryScraper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mwhitehouse on 25/04/2018.
 */
@Configuration
public class GroceryScraperConfig {

    @Bean(name = "foodScraper")
    public GroceryScraper getGroceryScraper() {
        return new SainsburysGroceryScraper();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }

}
