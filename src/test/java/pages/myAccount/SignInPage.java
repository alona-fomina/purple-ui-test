package pages.myAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.ParentPage;

public class SignInPage extends ParentPage {
    public SignInPage(){
            super();
    }
    @FindBy(css = "a[class='td-underline c-purple-medium ff-graphik fs-p2 create-one-button']")
    public WebElement createAccountLink;

}
