package pages.bedding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class BeddingPage {
    public BeddingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='/duvet'])[2]")
    public WebElement purpleDuvet;

    @FindBy(xpath = "//button[@data-testid='primary-button']/..")
    public WebElement addToTheCarButton;

    @FindBy(xpath = "//button[@data-testid='secondary-button']")
    public WebElement noThanksContinueToCart;
}
