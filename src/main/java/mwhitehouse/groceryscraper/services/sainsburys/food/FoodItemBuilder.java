package mwhitehouse.groceryscraper.services.sainsburys.food;

import mwhitehouse.groceryscraper.exceptions.ScrapingException;
import mwhitehouse.groceryscraper.model.FoodItem;
import mwhitehouse.groceryscraper.model.Response;
import mwhitehouse.groceryscraper.services.FoodItemDataExtractor;
import mwhitehouse.groceryscraper.services.JSoupWrapper;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwhitehouse on 24/04/2018.
 */
@Service
public class FoodItemBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodItemBuilder.class);

    @Autowired
    FoodItemDataExtractor foodFieldExtractor;

    @Autowired
    JSoupWrapper jsWrapper;

    public Response<FoodItem> extractFoodItemsFromPage(String url) {
        Response response;
        List<FoodItem> foodItems;
        response = new Response<>();
        try {
            foodItems = buildAndAddFoodItemToList(url);
            response.setResults(foodItems);
        } catch (ScrapingException ex) {
            LOGGER.error("Something went wrong during processing. ", ex);
        }
        return response;
    }

    private List<FoodItem> buildAndAddFoodItemToList(String url) throws ScrapingException {
        Document document = jsWrapper.getDocumentForUrl(url);
        List<Document> pages = foodFieldExtractor.extractProductLinks(document);
        List<FoodItem> foodItems = new ArrayList<>();
        for (Document page : pages) {
            foodItems.add(buildFoodItem(page));
        }
        return foodItems;
    }

    private FoodItem buildFoodItem(Document page) throws ScrapingException {
        FoodItem foodItem = new FoodItem();
        foodItem.setTitle(foodFieldExtractor.extractTitle(page));
        foodItem.setDescription(foodFieldExtractor.extractDescription(page));
        foodItem.setUnitPrice(foodFieldExtractor.extractPrice(page));
        foodItem.setKcalPer100g(foodFieldExtractor.extractKcal(page));
        return foodItem;
    }

}
