package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurpleMattressesPage extends ParentPage{

    public PurpleMattressesPage(){
        super();
    }

    @FindBy(xpath = "(//a[@href='/mattresses/purple-bed'])[4]")
    public WebElement purpleMattressShopNow;

    @FindBy(xpath = "//button[@data-testid='primary-button']/..")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[@data-testid='secondary-button']")
    public WebElement noThanksContinueToCart;
}
