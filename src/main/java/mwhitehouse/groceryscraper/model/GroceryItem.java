package mwhitehouse.groceryscraper.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mwhitehouse on 22/04/2018.
 */
public class GroceryItem {

    protected String title;
    protected String description;
    @JsonProperty("unit_price")
    protected Double unitPrice;

    public GroceryItem() {

    }

    public GroceryItem(String title, String description, Double unitPrice) {
        this.title = title;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
