package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

import java.util.List;

public class PurpleMain {
    public PurpleMain(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "div#block-themekit-branding > a > img:nth-of-type(1)")
    public WebElement purpleLogo;

    @FindBy(css = "div#mobile_menu__content > .menu.menu-level-0 >li > a")
    public List<WebElement> topNavMenuItems;



}
