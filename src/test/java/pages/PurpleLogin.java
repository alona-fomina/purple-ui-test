package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurpleLogin extends ParentPage{
    public PurpleLogin(){
        super();
    }

    @FindBy(css = "#email")
    private WebElement loginInput;

    @FindBy(css = "#loginPassword")
    private WebElement passInput;

    @FindBy(css = "#submitButton")
    private WebElement submitButton;

    public void login(String email, String pass){
        loginInput.sendKeys(email);
        passInput.sendKeys(pass);
        submitButton.click();
    }


}
