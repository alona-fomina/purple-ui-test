package pages.bedFrames;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.bedding.BeddingPage;
import utils.seleniumUtils.Driver;

public class BedFramesPage {
    public BedFramesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='/adjustable-bed-frame'])[4]")
    public WebElement ascentAdjustableBase;
}
