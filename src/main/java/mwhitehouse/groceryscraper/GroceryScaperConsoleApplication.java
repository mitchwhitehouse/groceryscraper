package mwhitehouse.groceryscraper;

import mwhitehouse.groceryscraper.exceptions.ScrapingException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroceryScaperConsoleApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GroceryScaperConsoleApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws ScrapingException {
        String url = args[0];
    }
}
