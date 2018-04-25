package mwhitehouse.services.sainsburys.food

import mwhitehouse.groceryscraper.services.sainsburys.food.FoodItemExtractorImpl
import mwhitehouse.groceryscraper.utils.NumberUtils
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import spock.lang.Specification
/**
 * Created by mwhitehouse on 25/04/2018.
 */
class FoodItemScraperSpec extends Specification {

    def document = Mock(Document)
    def infoTable = Mock(Element)
    def elements = Mock(Elements)
    def element = Mock(Element)

    private FoodItemExtractorImpl service = new FoodItemExtractorImpl()

    void "Test extractDescription"() {
        given:
        when:
        service.extractDescription(document)
        then:
        1 * document.getElementById(_) >> infoTable
        1 * infoTable.select(_) >> elements
        1 * elements.get(_) >> element
        1 * element.nextElementSibling() >> element
        1 * element.text() >> "TEXT";
    }


    void "Test extractTitle"() {
        given:
        when:
        service.extractTitle(document)
        then:
        1 * document.getElementsByClass(_) >> elements
        2 * elements.get(_) >> element
        1 * element.getElementsByTag(_) >> elements
        1 * element.text() >> "TEXT";
    }

    void "Test extractKcal"() {
        given:
        def numberUtils = Mock(NumberUtils)
        service.numberUtils = numberUtils

        when:
        service.extractKcal(document)
        then:
        2 * document.getElementsByClass(_) >> elements
        1 * elements.isEmpty() >> false
        1 * element.select(_) >> elements
        3 * elements.get(_) >> element
        1 * element.getElementsByTag(_) >> elements
        1 * element.text() >> "TEXT";
        1 * numberUtils.extractIntegerFromString(_) >> 2
    }
    
    void "Test getElementsByClass"() {
        given:
        def numberUtils = Mock(NumberUtils)
        service.numberUtils = numberUtils

        when:
        service.extractPrice(document)
        then:
        1 * document.getElementsByClass(_) >> elements
        1 * element.getElementsByClass(_) >> elements
        1 * elements.isEmpty() >> false
        1 * elements.size() >> 1
        1 * elements.hasText() >> true
        1 * elements.get(_) >> element
        1 * elements.text() >> "TEXT";
        1 * numberUtils.extractDoubleFromString(_) >> 2
    }

}