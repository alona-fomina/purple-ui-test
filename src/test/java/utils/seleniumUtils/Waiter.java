package utils.seleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.readerUtils.ConfigReader;

import java.time.Duration;
import java.util.List;

public class Waiter {
    static WebDriverWait explicitWait;

    /** Waiting element to be present in web page
     *
     * @param driver
     * @param element
     */
    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        wait(driver).until(ExpectedConditions.visibilityOf(element));
    }

    /** Waiting page title to be present
     *
     * @param driver selenium web driver
     * @param title the page title
     */
    public static void waitUntilTitleIs(WebDriver driver, String title) {
        wait(driver).until(ExpectedConditions.titleIs(title));
    }

    /** Waiting for text to be visible in web element
     *
     * @param driver selenium web driver
     * @param element html web element
     * @param text expected visible text
     */
    public static void waitForUntilTextToBePresentInElement(WebDriver driver, WebElement element, String text) {
        wait(driver).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /** Waits for a given element to not be visible
     *
     * @param driver  WebDriver instance
     * @param locator By of the element to wait for
     */
    public static void waitForElementNotVisible(WebDriver driver, By locator) {
        wait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /** Waits for a given element to be visible
     *
     * @param driver WebDriver instance
     * @param e      element to wait for
     */
    public static void waitForElementVisible(WebDriver driver, WebElement e) {
        wait(driver).until(ExpectedConditions.visibilityOf(e));
    }

    /** Waits for list of element to be visible
     *
     * @param driver WebDriver instance
     * @param le     list elements to wait for
     */
    public static void waitForListElementVisible(WebDriver driver, List<WebElement> le) {
        wait(driver).until(ExpectedConditions.visibilityOfAllElements(le));
    }

    /** Waits for a given element to be selected
     *
     * @param driver WebDriver instance
     * @param e      element to wait for
     */
    public static void waitForElementSelected(WebDriver driver, WebElement e) {
        wait(driver).until(ExpectedConditions.elementToBeSelected(e));
    }

    /** Waits for given element to be clickable
     *
     * @param driver WebDriver instance
     * @param e      element to wait for
     */
    public static void waitForElementClickable(WebDriver driver, WebElement e) {
        wait(driver).until(ExpectedConditions.elementToBeClickable(e));
    }

    /** Waits for the page to have a given title

     * This method is an attempt to address a problem where Chrome/IE drivers
     * are trying to check the page title on page load before the title has
     * changed to that of the new page.
     *
     * @param driver WebDriver instance
     * @param title title the page should have
     */
    public static boolean waitForPageTitle(WebDriver driver, String title) {
        return wait(driver).until(ExpectedConditions.titleContains(title));
    }


    /**
     * Sleep script for the specified length
     * (generally not an ideal solution)
     *
     * @param length
     */
    public static void sleep(long length) throws InterruptedException {
        try {
            Thread.sleep(length);
        } catch (Exception e) {
            throw new InterruptedException("Interrupted the test!!!");
        }
    }

    /** Creating the explicit wait object if it is not initialised otherwise it is returning the existing object
     *
     * @param driver
     * @return explicitWait
     */
    public static WebDriverWait wait(WebDriver driver) {
        if (explicitWait == null){
            explicitWait = new WebDriverWait(driver, Integer.parseInt(ConfigReader.getProperty("timeoutForExplicitWait")));
        }
        return explicitWait;
    }
}
