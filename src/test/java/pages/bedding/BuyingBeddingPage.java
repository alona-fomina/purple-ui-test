package pages.bedding;

import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class BuyingBeddingPage {
    public BuyingBeddingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
