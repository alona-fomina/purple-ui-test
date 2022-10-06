package utils.validationUtils;

import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class AssertionUtils {
    /**Validating the text of the button
     * Checking if the button is displayed
     * Checking if the button enable
     * @param element WebElement
     * @param expectedText expected text
     */
    public static void validateButton(WebElement element, String expectedText) {
        validateElementLink(element);
        validateElementText(element, expectedText);
    }

    /**Validating button from the list of WebElements one by one
     *
     * @param elements WebElement
     * @param expectedTexts expected text
     */
    public static void validateButtons(List<WebElement> elements, List<String> expectedTexts) {
        for (int i = 0; i < expectedTexts.size(); i++) {
            validateButton(elements.get(i), expectedTexts.get(i));
        }
    }

    /**Validating if the element is displayed and enable
     *
     * @param element WebElement
     */
    public static void validateElementLink(WebElement element) {
        validateElementDisplayed(element);
        validateElementEnabled(element);
    }

    /**Validating if the element is displayed and enable
     *
     * @param element WebElement
     */
    public static void validateElementLinks(List <WebElement> element) {
        for (WebElement webElement : element) {
            validateElementLink(webElement);
        }
    }

    /**Validating if element is presented
     * Validating if text of the element are equals to expected text
     * @param element WebeElement
     * @param expectedText expected text
     */
    public static void validateElementText(WebElement element, String expectedText) {
        validateElementDisplayed(element);
        assertEquals(expectedText, element.getText());
    }

    /**Validating WebElement text is equals to expected text from the List of Web Elements one by one
     *
     * @param elements List Of the Web Elements
     * @param expectedTexts expected text
     */
    public static void validateElementTexts(List<WebElement> elements, List<String> expectedTexts) {
        for (int i = 0; i < elements.size(); i++) {
            assertEquals(expectedTexts.get(i), elements.get(i).getText());
        }
    }

    /**Validating if the element attribute text is equals to expected text
     *
     * @param element WebElement
     * @param attribute text of the attribute
     * @param expectedAttribute expected attribute
     */
    public static void validateElementAttribute(WebElement element, String attribute, String expectedAttribute) {
        assertEquals(expectedAttribute, element.getAttribute(attribute));
    }

    /**Validating if the element attribute text is contains to expected attribute
     *
     * @param element WebElement
     * @param attribute text of the attribute
     * @param expectedAttribute expected attribute
     */
    public static void validateElementAttributeContains(WebElement element, String attribute, String expectedAttribute) {
        assertTrue(element.getAttribute(attribute).contains(expectedAttribute));
    }

    /**Validating if the element attribute text is starts with expected attribute
     *
     * @param element WebElement
     * @param attribute text of the attribute
     * @param expectedAttribute expected attribute
     */
    public static void validateElementAttributeStartsWith(WebElement element, String attribute, String expectedAttribute) {
        assertTrue(element.getAttribute(attribute).startsWith(expectedAttribute));
    }

    /**Validating if the element attribute text is ends with expected attribute
     *
     * @param element WebElement
     * @param attribute text of the attribute
     * @param expectedAttribute expected attribute
     */
    public static void validateElementAttributeEndsWith(WebElement element, String attribute, String expectedAttribute) {
        assertTrue(element.getAttribute(attribute).endsWith(expectedAttribute));
    }

    /**Validating element css
     *
     * @param element WebElement
     * @param css actual css
     * @param expectedCss expected css
     */
    public static void validateElementCss(WebElement element, String css, String expectedCss) {
        assertEquals(expectedCss, element.getCssValue(css));
    }

    /**Validating element contains css
     *
     * @param element WebElement
     * @param css actual
     * @param expectedCss expected
     */
    public static void validateElementCssContains(WebElement element, String css, String expectedCss) {
        assertTrue(element.getCssValue(css).contains(expectedCss));
    }

    /**Validating element starts with expected css
     *
     * @param element WebElement
     * @param css actual
     * @param expectedCss expected
     */
    public static void validateElementCssStartsWith(WebElement element, String css, String expectedCss) {
        assertTrue(element.getCssValue(css).startsWith(expectedCss));
    }

    /**Validating element ends with expected css
     *
     * @param element WebElement
     * @param css actual
     * @param expectedCss expected
     */
    public static void validateElementCssEndsWith(WebElement element, String css, String expectedCss) {
        assertTrue(element.getCssValue(css).endsWith(expectedCss));
    }

    /**Validating if the list of WebElements displayed
     *
     * @param elements List of WebElements
     */
    public static void validateElementsDisplayed(List<WebElement> elements) {
        for (WebElement webElement : elements) {
           validateElementDisplayed(webElement);
        }
    }

    /**Validating if the WebElement Displayed
     *
     * @param element WebElement
     */
    public static void validateElementDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    /**Validating if the WebElement Enabled
     *
     * @param element WebElement
     */
    public static void validateElementEnabled(WebElement element) {
        assertTrue(element.isEnabled());
    }

    /**Validating if the WebElement Selected
     *
     * @param element WebElement
     */
    public static void validateElementSelected(WebElement element) {
        assertTrue(element.isSelected());
    }
}
