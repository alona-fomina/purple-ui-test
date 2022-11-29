package pages.mattress;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class BuyingMattressPage {
    public BuyingMattressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
