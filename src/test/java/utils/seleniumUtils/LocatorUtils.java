package utils.seleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.Hooks;

public class LocatorUtils {

        public static WebElement findElementByText(String text) {
            return Hooks.driver.findElement(By.xpath("//*[text()='" + text + "']"));
        }

        public static WebElement findElementByContainsAtt(String attName, String attValue) {
            return Hooks.driver.findElement(By.xpath("//*[contains(@" + attName + ", '" + attValue + "')]"));
        }

        public static WebElement findElementByContainsText(String text) {
            return Hooks.driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
        }
}
