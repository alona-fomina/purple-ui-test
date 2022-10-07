package pages;

import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class ParentPage {
    public ParentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
