package mwhitehouse.groceryscraper.exceptions;

/**
 * Created by mwhitehouse on 25/04/2018.
 */
public class ScrapingException extends Exception {

    public ScrapingException(String message) {
        super(message);
    }

    public ScrapingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScrapingException(Throwable cause) {
        super(cause);
    }

}
