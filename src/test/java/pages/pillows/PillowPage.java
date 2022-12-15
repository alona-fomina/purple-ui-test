package pages.pillows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class PillowPage {
    public PillowPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='multi-image'])[1]")
    public WebElement purpleHarmonyPillow;

    @FindBy(xpath = "(//a[@href='/pillows/purple-pillow'])[2]")
    public WebElement purplePillow;

    @FindBy(xpath = "(//a[@href='/pillows/kids'])[3]")
    public WebElement kidsPillow;

    @FindBy(xpath = "(//a[@href='/pillows/twin-cloud'])[2]")
    public WebElement twinCloudPillow;

    @FindBy(xpath = "(//a[@href='/pillows/cloud'])[2]")
    public WebElement cloudPillow;

}
