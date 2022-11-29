package pages.sheets;

import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class BuyingSheetsPage {
    public BuyingSheetsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
