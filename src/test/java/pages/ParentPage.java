package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class ParentPage {
    public ParentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//button[@data-testid='primary-button']/..")
    public WebElement addToTheCarButton;

    @FindBy(xpath = "//button[@data-testid='secondary-button']")
    public WebElement noThanksContinueToCart;

    @FindBy(xpath = "//a[text()='Terms + Privacy']")
    public WebElement footerTermsPrivacy;
}
