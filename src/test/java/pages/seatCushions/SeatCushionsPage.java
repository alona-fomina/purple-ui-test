package pages.seatCushions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class SeatCushionsPage {
    public SeatCushionsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='/seat-cushions/ultimate'])[4]")
    public WebElement ultimateSeatCushion;
}
