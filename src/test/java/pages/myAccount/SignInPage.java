package pages.myAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class SignInPage extends ParentPage {
    public SignInPage(){
            super();
    }
    @FindBy(css = "a[class='td-underline c-purple-medium ff-graphik fs-p2 create-one-button']")
    public WebElement createAccountLink;

    @FindBy(css = "#email")
    public WebElement emilInputBar;

    @FindBy(css = "#loginPassword")
    public WebElement passwordInputBar;

    @FindBy(css = "#submitButton")
    public WebElement singInButton;
}
