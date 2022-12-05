package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurpleCartsPage extends ParentPage{
    public PurpleCartsPage(){
        super();
    }

    @FindBy(xpath = "//a[@data-testid='proceed-to-checkout-button']")
    public WebElement proceedToCheckOutLink;

    @FindBy(css = "iframe[allowpaymentrequest='allowpaymentrequest']")
    public WebElement payPalIFrame;

    @FindBy(css = "#buttons-container")
    public WebElement expressCheckOutPayPal;

    @FindBy(css = "#paypal-cart-summary-checkout-button")
    public WebElement expressCheckOutPayPal2;

    @FindBy(css = "button#CartSummaryAmzBtn_button")
    public WebElement getExpressCheckOutAmazonPay;

}
