package utils.seleniumUtils;

import org.openqa.selenium.WebElement;
import steps.Hooks;

public class FrameUtils {
    public static void sendKeysToIframeElement(WebElement frame, WebElement element, String keys){
        Hooks.driver.switchTo().frame(frame);
        element.sendKeys(keys);
        Hooks.driver.switchTo().parentFrame();
    }

    public static void clickOnElementInIFrame(WebElement frame, WebElement element){
        Hooks.driver.switchTo().frame(frame);
        JavaScriptUtils.clickElementScrollIfIntercepted(element, 45);
        Hooks.driver.switchTo().parentFrame();
    }

}
