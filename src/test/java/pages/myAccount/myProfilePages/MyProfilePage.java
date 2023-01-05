package pages.myAccount.myProfilePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends UserDashboard{
    public MyProfilePage(){super();}

    @FindBy(css = "div[class='d-flex flex-column']")
    public List<WebElement> editProfile;

    @FindBy(css = "#given_name")
    public WebElement changeFirstName;

    @FindBy(css = "#family_name")
    public WebElement changeLastName;


    @FindBy(css = "button[class='button white w-100 m-l-16']")
    public WebElement cancelChanges;

    @FindBy(css = "div[class='d-flex align-items-center bg-white justify-content-between full-border together'] p")
    public List<WebElement> userInformation;

    @FindBy(css = "#phone_number")
    public WebElement changePhoneNumber;

    @FindBy(css = "#email")
    public WebElement changeEmail;

    @FindBy(css = "#currentPassword")
    public WebElement currentPassword;

    @FindBy(css = "#newPassword")
    public WebElement newPassword;

    @FindBy(css = "#confirmPassword")
    public WebElement confirmPassword;

}
