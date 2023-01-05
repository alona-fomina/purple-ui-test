package pages.myAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class TempEmailPage {
    public TempEmailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = ".iconx")
    public WebElement copyButton;

    @FindBy(xpath = "(//button[@class='prim-btn'])[1]")
    public WebElement refreshButton;

    @FindBy(xpath = "(//button[@class='prim-btn'])[2]")
    public WebElement changeButton;

    @FindBy(css = ".pure-button-primary")
    public WebElement popUpOk;

    @FindBy(css = ".mail-item")
    public WebElement emailItem;

    @FindBy(css = "#fullmessage")
    public WebElement messageIFrame;

    @FindBy(css = "a[href*='verify']")
    public WebElement completeVerification;
}
