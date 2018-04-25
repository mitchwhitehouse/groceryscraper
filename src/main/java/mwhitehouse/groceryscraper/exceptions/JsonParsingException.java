package mwhitehouse.groceryscraper.exceptions;

/**
 * Created by mwhitehouse on 25/04/2018.
 */
public class JsonParsingException extends Exception {

    public JsonParsingException(String message) {
        super(message);
    }

    public JsonParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonParsingException(Throwable cause) {
        super(cause);
    }

}
