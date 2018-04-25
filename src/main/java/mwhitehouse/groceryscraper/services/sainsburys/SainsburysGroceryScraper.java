package mwhitehouse.groceryscraper.services.sainsburys;

import mwhitehouse.groceryscraper.model.FoodItem;
import mwhitehouse.groceryscraper.model.Response;
import mwhitehouse.groceryscraper.services.GroceryScraper;
import mwhitehouse.groceryscraper.services.sainsburys.food.FoodItemBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mwhitehouse on 24/04/2018.
 */
public class SainsburysGroceryScraper implements GroceryScraper {

    @Autowired
    FoodItemBuilder foodItemScraper;

    @Override
    public Response<FoodItem> extractFoodItems(String url) {
        return foodItemScraper.extractFoodItemsFromPage(url);
    }

}
