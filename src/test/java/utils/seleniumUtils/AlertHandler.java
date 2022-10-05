package utils.seleniumUtils;

import org.openqa.selenium.WebDriver;

public class AlertHandler {
    /** Accepting alert
     *
     * @param driver WebDriver instance
     */
    public static void acceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    /** Dismissing  alert
     *
     * @param driver WebDriver instance
     */
    public static void dismissAlert(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }
    /** Sending text to the alert
     *
     * @param driver WebDriver instance
     */
    public static void sendKeysToAlert(WebDriver driver, String key){
        driver.switchTo().alert().sendKeys(key);
    }
    /** Getting text from the  alert
     *
     * @param driver WebDriver instance
     */
    public static String getAlertSText(WebDriver driver){
        return driver.switchTo().alert().getText();
    }
}