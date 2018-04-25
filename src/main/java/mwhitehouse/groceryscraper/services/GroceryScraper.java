package mwhitehouse.groceryscraper.services;

import mwhitehouse.groceryscraper.model.FoodItem;
import mwhitehouse.groceryscraper.model.Response;

/**
 * Created by mwhitehouse on 24/04/2018.
 */
public interface GroceryScraper {

    Response<FoodItem> extractFoodItems(String url);

    //Response<ElectricalItem> extractElectricalItem(String url);


}
