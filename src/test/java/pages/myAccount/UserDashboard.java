package pages.myAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class UserDashboard extends ParentPage {

    public UserDashboard() {
        super();
    }

    @FindBy(css = ".welcome-message")
    public WebElement welcomeMessage;
}
