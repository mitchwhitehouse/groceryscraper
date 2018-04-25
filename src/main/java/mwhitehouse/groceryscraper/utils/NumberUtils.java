package mwhitehouse.groceryscraper.utils;

import org.springframework.stereotype.Component;

/**
 * Created by mwhitehouse on 25/04/2018.
 */
@Component
public class NumberUtils {

    public Double extractDoubleFromString(String doubleString) {
        String numeric = doubleString.replaceAll("[^\\d.]", "");
        return Double.valueOf(numeric);
    }

    public Integer extractIntegerFromString(String integerString) {
        String numeric = integerString.replaceAll("[^\\d]", "");
        return Integer.valueOf(numeric);
    }

}
