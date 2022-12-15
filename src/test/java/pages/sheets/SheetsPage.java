package pages.sheets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class SheetsPage {
    public SheetsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='/sheets/kids'])[2]")
    public WebElement kidsSheets;

    @FindBy(xpath = "(//a[@href='/sheets/soft-stretch'])[3]")
    public WebElement softStretchSheets;

    @FindBy(xpath = "(//a[@href='/sheets/complete-comfort-sheets'])[2]")
    public WebElement completeComfortSheets;

    @FindBy(xpath = "(//a[@href='/softstretch-pillowcase'])[2]")
    public WebElement softStretchPillowcase;

    @FindBy(xpath = "complete-comfort-pillowcase")
    public WebElement completeComfortPillowcase;

}
