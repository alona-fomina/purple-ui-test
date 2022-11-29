package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurpleCartsPage extends ParentPage{
    public PurpleCartsPage(){
        super();
    }

    @FindBy(xpath = "//a[@data-testid='proceed-to-checkout-button']")
    public WebElement proceedToCheckOutLink;

    @FindBy(css = "div[role='link'] > .paypal-button-label-container")
    public WebElement expressCheckOutPayPal;

    @FindBy(css = "button#CartSummaryAmzBtn_button")
    public WebElement getExpressCheckOutAmazonPay;

}
