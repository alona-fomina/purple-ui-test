package utils.seleniumUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {
    private static Actions actions;

    static {
        actions = new Actions(Driver.getDriver());
    }

    /**
     * Right click action
     *
     * @param element WebElement
     */
    public static void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    /**
     * Moving mouse to the element
     *
     * @param element WebElement
     */
    public static void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    /**
     * Left click
     *
     * @param element WebElement
     */
    public static void clickOnTheElement(WebElement element) {
        actions.click(element).perform();
    }

    /**
     * Double click
     *
     * @param element WebElement
     */
    public static void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    /**
     * Clicking on the element and holding
     *
     * @param element WebElement
     */
    public static void clickAndHold(WebElement element) {
        actions.clickAndHold(element).perform();
    }

    /**
     * ReleaseElement
     *
     * @param element WebElement
     */
    public static void release(WebElement element) {
        actions.release(element).perform();
    }

    /**
     * Drag and drop element
     *
     * @param element WebElement
     */
    public static void dragAndDrop(WebElement element) {
        actions.dragAndDrop(element, element).perform();
    }

    public static void persistentClick(WebElement element, int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            if (i == 0) JavaScriptUtils.clickElementScrollIfIntercepted(element, 48);
            else {
                Thread.sleep(200);
                element.click();
            }
        }
    }
}
