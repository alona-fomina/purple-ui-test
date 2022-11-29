package pages.pillows;

import org.openqa.selenium.support.PageFactory;
import steps.Hooks;
import utils.seleniumUtils.Driver;

public class BuyingPillowPage {
    public BuyingPillowPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
