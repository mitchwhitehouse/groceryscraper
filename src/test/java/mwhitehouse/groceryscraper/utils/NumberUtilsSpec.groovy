package mwhitehouse.groceryscraper.utils;

import spock.lang.Specification

class NumberUtilsSpec extends Specification {

    private NumberUtils service = new NumberUtils()

    void "Test extractDoubleFromString"() {
        given:

        when:
        def result = service.extractDoubleFromString("£3.45 ")
        then:
        result == 3.45
    }

    void "Test extractIntegeroString"() {
        given:

        when:
        def result = service.extractIntegerFromString("123kcl per serving ")
        then:
        result == 123
    }

}