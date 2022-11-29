package pages.mattress;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class MattressesPage extends ParentPage {

    public MattressesPage(){
        super();
    }

    @FindBy(xpath = "//button[@data-testid='primary-button']/..")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[@data-testid='secondary-button']")
    public WebElement noThanksContinueToCart;

    @FindBy(xpath = "(//a[@href='/mattresses/newday'] )[4]")
    public WebElement newDayShopNow;

    @FindBy(xpath = "(//a[@href='/mattresses/purple-bed'] )[4]")
    public WebElement purpleMattressShopNow;

    @FindBy(xpath = "(//a[@href='/mattresses/plus'] )[4]")
    public WebElement purplePlusShopNow;

    @FindBy (xpath = "(//a[@href='/mattresses/hybrid'] )[4]")
    public WebElement purpleHybridShopNow;

    @FindBy (xpath = "(//a[@href='/mattresses/hybrid-premier'] )[4]")
    public WebElement hybridPremier3ShopNow;

    @FindBy (xpath = "(//a[@href='/mattresses/hybrid-premier-4'] )[4]")
    public WebElement hybridPremier4ShopNow;

    @FindBy (xpath = "(//h2[starts-with(@class, 'field heading')])[2]")
    public WebElement secondHeader2;


}
