package mwhitehouse.groceryscraper.services;

import mwhitehouse.groceryscraper.exceptions.ScrapingException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by mwhitehouse on 25/04/2018.
 */
@Component
public class JSoupWrapper {

    public Document getDocumentForUrl(String url) throws ScrapingException {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException ex) {
            throw new ScrapingException(ex);
        }
    }

}
