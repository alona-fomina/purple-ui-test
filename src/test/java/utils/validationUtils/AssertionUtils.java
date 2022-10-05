package utils.validationUtils;

import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class AssertionUtils {

    public static void validateButton(WebElement element, String expectedText) {
        validateElementLink(element);
        validateElementText(element, expectedText);
    }

    public static void validateButtons(List<WebElement> elements, String[] expectedTexts) {
        for (int i = 0; i < expectedTexts.length; i++) {
            validateButton(elements.get(i), expectedTexts[i]);
        }
    }

    public static void validateElementLink(WebElement element) {
        validateElementDisplayed(element);
        validateElementEnabled(element);
    }

    public static void validateElementText(WebElement element, String expectedText) {
        validateElementDisplayed(element);
        assertEquals(element.getText(), expectedText);
    }

    public static void validateElementTexts(List<WebElement> elements, List<String> expectedTexts) {
        for (int i = 0; i < elements.size(); i++) {
            assertEquals(elements.get(i).getText(), expectedTexts.get(i));
        }
    }

    public static void validateElementAttribute(WebElement element, String attribute, String expectedAttribute) {
        assertEquals(element.getAttribute(attribute), expectedAttribute);
    }

    public static void validateElementAttributeContains(WebElement element, String attribute, String expectedAttribute) {
        assertTrue(element.getAttribute(attribute).contains(expectedAttribute));
    }

    public static void validateElementAttributeStartsWith(WebElement element, String attribute, String expectedAttribute) {
        assertTrue(element.getAttribute(attribute).startsWith(expectedAttribute));
    }

    public static void validateElementAttributeEndsWith(WebElement element, String attribute, String expectedAttribute) {
        assertTrue(element.getAttribute(attribute).endsWith(expectedAttribute));
    }

    public static void validateElementCss(WebElement element, String css, String expectedCss) {
        assertEquals(element.getCssValue(css), expectedCss);
    }

    public static void validateElementCssContains(WebElement element, String css, String expectedCss) {
        assertTrue(element.getCssValue(css).contains(expectedCss));
    }

    public static void validateElementCssStartsWith(WebElement element, String css, String expectedCss) {
        assertTrue(element.getCssValue(css).startsWith(expectedCss));
    }

    public static void validateElementCssEndsWith(WebElement element, String css, String expectedCss) {
        assertTrue(element.getCssValue(css).endsWith(expectedCss));
    }

    public static void validateElementsDisplayed(List<WebElement> elements) {
        for (WebElement webElement : elements) {
           validateElementDisplayed(webElement);
        }
    }

    public static void validateElementDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public static void validateElementEnabled(WebElement element) {
        assertTrue(element.isEnabled());
    }

    public static void validateElementSelected(WebElement element) {
        assertTrue(element.isSelected());
    }
}
