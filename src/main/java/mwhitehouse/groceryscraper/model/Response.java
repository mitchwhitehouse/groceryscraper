package mwhitehouse.groceryscraper.model;

import java.util.List;

/**
 * Created by mwhitehouse on 25/04/2018.
 */
public class Response<T extends GroceryItem> {

    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Double getTotal() {
        return this.results.stream().mapToDouble(T::getUnitPrice).sum();
    }
}
