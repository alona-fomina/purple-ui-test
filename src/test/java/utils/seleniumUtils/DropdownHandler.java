package utils.seleniumUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandler {
    /**Selecting option from the dropDown by index
     *
     * @param dropdown WebElement dropdown
     * @param index number start from 0
     */
    public static void selectOptionByIndex(WebElement dropdown, int index){
        new Select(dropdown).selectByIndex(index);
    }

    /**Selecting option from the dropDown by number
     *
     * @param dropdown WebElement dropdown
     * @param value number
     */
    public static void selectOptionByValue(WebElement dropdown, String value){
        new Select(dropdown).selectByValue(value);
    }

    /**Selecting option from the dropDown by text
     *
     * @param dropdown WebElement dropdown
     * @param visibleText visible test
     */
    public static void selectOptionByVisibleText(WebElement dropdown, String visibleText){
        new Select(dropdown).selectByVisibleText(visibleText);
    }
}
