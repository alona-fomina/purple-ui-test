package utils.seleniumUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static steps.Hooks.*;

public class WindowHandleUtils {

    /**
     *
     * @param driver
     * @return
     */

    public static String switchToNotMainWindow(WebDriver driver) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        return currentWindow;

    }

    /**
     *
     * @param driver
     * @param url
     * @return
     */

    public static String switchToCertainWindowWithUrl(WebDriver driver, String url) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().contains(url)){
                    System.out.println("You switched your window to URL = " + driver.getCurrentUrl());
                    break;
                }
            }
        }
        return currentWindow;
    }

    /**
     *
     * @param driver
     * @param title
     * @return
     */

    public static String switchToCertainWindowWithTitle(WebDriver driver, String title) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
                if (driver.getTitle().contains(title))break;
            }
        }
        return currentWindow;
    }

    public static String openLinkInNewTab(String link) {
        String currentHandle = driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        //getting all the handles currently available
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {

            if (!actual.equalsIgnoreCase(currentHandle)) {
                //switching to the opened tab
                driver.switchTo().window(actual);

                //opening the URL saved.
                driver.get(link);
            }
        }
        return currentHandle;
    }
}