package pages.myAccount.myProfilePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

import java.util.List;

public class UserDashboard extends ParentPage {

    public UserDashboard() {
        super();
    }

    @FindBy(css = ".welcome-message")
    public WebElement welcomeMessage;

    @FindBy(css = "nav[class='accounts-nav'] li")
    public List<WebElement> accountNavMenu;

    @FindBy(css = "button[class='button primary-button w-100 ']")
    public WebElement saveChangesButton;

    public void clickLeftMenuByText(String text){
        for(WebElement link : accountNavMenu){
            if(link.getText().equals(text)){
                link.click();
                break;
            }
        }
    }
}
