package mwhitehouse.groceryscraper.services;

import mwhitehouse.groceryscraper.exceptions.ScrapingException;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Created by mwhitehouse on 25/04/2018.
 */
public interface FoodItemDataExtractor {

    Double extractPrice(Document doc) throws ScrapingException;

    String extractDescription(Document doc);

    String extractTitle(Document doc);

    Integer extractKcal(Document doc);

    List<Document> extractProductLinks(Document doc) throws ScrapingException;

}
