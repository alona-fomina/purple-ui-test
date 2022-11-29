package pages.sheets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class SheetsPage {
    public SheetsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='/sheets/kids'])[2]")
    public WebElement kidsSheets;

    @FindBy(xpath = "//button[@data-testid='primary-button']/..")
    public WebElement addToTheCarButton;

    @FindBy(xpath = "//button[@data-testid='secondary-button']")
    public WebElement noThanksContinueToCart;

}
