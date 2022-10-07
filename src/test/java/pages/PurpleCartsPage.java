package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurpleCartsPage extends ParentPage{
    public PurpleCartsPage(){
        super();
    }

    @FindBy(xpath = "//a[@data-testid='proceed-to-checkout-button']")
    public WebElement proceedToCheckOutLink;
}
