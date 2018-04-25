package mwhitehouse.groceryscraper.services.sainsburys.food;

import mwhitehouse.groceryscraper.exceptions.ScrapingException;
import mwhitehouse.groceryscraper.services.FoodItemDataExtractor;
import mwhitehouse.groceryscraper.services.JSoupWrapper;
import mwhitehouse.groceryscraper.utils.NumberUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mwhitehouse on 22/04/2018.
 */
@Service
public class FoodItemExtractorImpl implements FoodItemDataExtractor {

    private static final String PRICE_PER_UNIT_CLASS = "pricePerUnit";
    private static final String PRICE_TAB_CLASS = "priceTab activeContainer priceTabContainer";
    private static final String A_TAG_SELECTOR = "a[href]";
    private static final String PRODUCT_DIV_CLASS = "productNameAndPromotions";

    @Autowired
    NumberUtils numberUtils;

    @Autowired
    JSoupWrapper jsWrapper;

    @Override
    public Double extractPrice(Document doc) throws ScrapingException {
        Elements elements = doc.getElementsByClass(PRICE_TAB_CLASS);
        Double price = null;
        if (elements.isEmpty() || elements.size() > 1) {
            throw new ScrapingException("Problem extracting price");
        } else {
            Element priceDiv = elements.get(0);
            Elements priceElement = priceDiv.getElementsByClass(PRICE_PER_UNIT_CLASS);
            if (priceElement.hasText()) {
                price = numberUtils.extractDoubleFromString(priceElement.text());
            }
        }
        return price;
    }

    @Override
    public String extractDescription(Document doc) {
        Element infoTable = doc.getElementById("information");
        return extractStringFromInfoTable(infoTable, "Description");
    }

    private String extractStringFromInfoTable(Element infoTable, String tagName) {
        String selector = String.format("h3:contains(%s)", tagName);
        Element h3Tag = infoTable.select(selector).get(0);
        return h3Tag.nextElementSibling().text();
    }

    @Override
    public String extractTitle(Document doc) {
        Element titleDiv = doc.getElementsByClass("productTitleDescriptionContainer").get(0);
        Element titleTag = titleDiv.getElementsByTag("h1").get(0);
        return titleTag.text();
    }

    @Override
    public Integer extractKcal(Document doc) {
        if (doc.getElementsByClass("nutritionTable").isEmpty()) {
            return null;
        }
        Element nutritionTable = doc.getElementsByClass("nutritionTable").get(0);
        Elements rows = nutritionTable.select("tr");
        Element firstRow = rows.get(2);
        Element kcalCell = firstRow.getElementsByTag("td").get(0);
        return numberUtils.extractIntegerFromString(kcalCell.text());
    }

    @Override
    public List<Document> extractProductLinks(Document doc) throws ScrapingException {
        List<Document> productPages = new ArrayList<>();
        Elements productDivs = doc.getElementsByClass(PRODUCT_DIV_CLASS);

        for (Element productDiv : productDivs) {
            String linkUrl = productDiv.select(A_TAG_SELECTOR).attr("abs:href");
            productPages.add(jsWrapper.getDocumentForUrl(linkUrl));
        }
        return productPages;
    }
}