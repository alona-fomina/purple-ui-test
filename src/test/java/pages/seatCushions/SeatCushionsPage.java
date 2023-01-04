package pages.seatCushions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class SeatCushionsPage {
    public SeatCushionsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='/seat-cushions/ultimate'])[2]")
    public WebElement ultimateSeatCushion;

    @FindBy(xpath = "(//a[@href='/seat-cushions/office-chair'])[2]")
    public WebElement doubleCushion;

    @FindBy(xpath = "(//a[@href='/seat-cushions/royal'])[2]")
    public WebElement royalCushion;

    @FindBy(xpath = "(//a[@href='/seat-cushions/car'])[2]")
    public WebElement simplyCushion;

    @FindBy(xpath = "(//a[@href='/seat-cushions/portable'])[2]")
    public WebElement portableCushion;

    @FindBy(xpath = "(//a[@href='/seat-cushions/back'])[2]")
    public WebElement backCushion;
}
