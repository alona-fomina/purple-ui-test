package pages.pillows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class PillowPage {
    public PillowPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='multi-image'])[1]")
    public WebElement purpleHarmonyPillow;

    @FindBy(xpath = "//button[@data-testid='primary-button']/..")
    public WebElement addToTheCarButton;

    @FindBy(xpath = "//button[@data-testid='secondary-button']")
    public WebElement noThanksContinueToCart;
}
