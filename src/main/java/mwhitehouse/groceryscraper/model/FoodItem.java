package mwhitehouse.groceryscraper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mwhitehouse on 22/04/2018.
 */
public class FoodItem extends GroceryItem {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("kcal_per_100g")
    private Integer kcalPer100g;

    public FoodItem() {
        super();
    }

    public Integer getKcalPer100g() {
        return kcalPer100g;
    }

    public void setKcalPer100g(Integer kcalPer100g) {
        this.kcalPer100g = kcalPer100g;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "title='" + title + '\'' +
                ", kcalPer100g=" + kcalPer100g +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
