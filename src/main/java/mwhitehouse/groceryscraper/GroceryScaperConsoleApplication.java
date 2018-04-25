package mwhitehouse.groceryscraper;

import mwhitehouse.groceryscraper.exceptions.ScrapingException;
import mwhitehouse.groceryscraper.model.FoodItem;
import mwhitehouse.groceryscraper.model.Response;
import mwhitehouse.groceryscraper.services.GroceryScraper;
import mwhitehouse.groceryscraper.services.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroceryScaperConsoleApplication implements CommandLineRunner {

    @Autowired
    GroceryScraper foodScraper;

    @Autowired
    JsonService jsonService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GroceryScaperConsoleApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws ScrapingException {
        String url = args[0];
        Response<FoodItem> response = foodScraper.extractFoodItems(url);
        jsonService.printResponseAsPrettyJson(response);
    }
}
