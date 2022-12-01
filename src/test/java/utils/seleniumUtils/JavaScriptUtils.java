package utils.seleniumUtils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import steps.Hooks;

public class JavaScriptUtils {

    public static void clickElementScrollIfIntercepted(WebElement element, int pixels) {
        do {
            try {
                element.click();
                break;
            } catch (ElementClickInterceptedException exception) {
                System.out.println("Can't click on element scrolling and trying again...");
                js().executeScript("window.scrollBy(0," + pixels + ")");
            }
        } while (true);
    }

    public static void clickElementScrollIfIntercepted(WebElement element1, WebElement element2,int pixels) {
        do {
            try {
                element1.click();
                break;
            } catch (ElementClickInterceptedException exception) {
                System.out.println("Can't click on element scrolling and trying again...");
                js().executeScript("window.scrollBy(0," + pixels + ")");
            }
        } while (true);
    }

    public static JavascriptExecutor js() {
        return (JavascriptExecutor) Hooks.driver;
    }
}
