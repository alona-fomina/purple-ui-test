package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils.Driver;

import java.util.List;

public class PurpleMain extends ParentPage{
    public PurpleMain(){
       super();
    }
    @FindBy(css = "div#block-themekit-branding > a > img:nth-of-type(1)")
    public WebElement purpleLogo;

    @FindBy(css = "div#mobile_menu__content > .menu.menu-level-0 >li > a")
    public List<WebElement> topNavMenuItems;

    @FindBy(css = ".email-modal-close")
    public WebElement closeEmailPopup;

    @FindBy(css = "button[class='root__OblK1 root__eL_b5']")
    public WebElement policyPopUpButton;

    @FindBy(css = "a[href='/account'")
    public WebElement myAccountButton;

    public void clickTopMenuItem(String menuItem){
        for (WebElement item : topNavMenuItems) {
            if (item.getText().equals(menuItem)){
                item.click();
                break;
            }
        }
    }

}
