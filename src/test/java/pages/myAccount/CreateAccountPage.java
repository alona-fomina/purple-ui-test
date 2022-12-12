package pages.myAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class CreateAccountPage extends ParentPage {
    public CreateAccountPage(){
        super();
    }
    @FindBy(css = "#given_name")
    public WebElement firstNameInput;

    @FindBy(css = "#family_name")
    public WebElement lastNameInput;

    @FindBy(css = "#email")
    public WebElement emailInput;

    @FindBy(css = "#phone_number")
    public WebElement phoneNumberInput;

    @FindBy(css = "#signUpPassword")
    public WebElement passwordInput;

    @FindBy(css = "button[data-testid='primary-button']")
    public WebElement createAccountButton;
}
