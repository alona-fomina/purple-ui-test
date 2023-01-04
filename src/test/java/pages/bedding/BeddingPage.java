package pages.bedding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

public class BeddingPage {
    public BeddingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='/duvet'])[3]")
    public WebElement purpleDuvet;

    @FindBy(xpath = "(//a[@href='/mattress-protector'])[2]")
    public WebElement mattressProtector;

    @FindBy(xpath = "(//a[@href='/weighted-blanket'])[3]")
    public WebElement weightedBlanket;

    @FindBy(xpath = "(//a[@href='/pajamas'])[2]")
    public  WebElement pajamas;

}
