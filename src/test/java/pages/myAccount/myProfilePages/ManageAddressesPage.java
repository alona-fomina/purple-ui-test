package pages.myAccount.myProfilePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageAddressesPage extends UserDashboard{
    public ManageAddressesPage(){super();}

    @FindBy(css = "p[class='c-light-midnight ff-graphik fs-p1']")
    public WebElement noAddressesMessage;

    @FindBy(css = "button[class='button c-purple-primary fw-medium']")
    public WebElement addNewAddressButton;

    @FindBy(css = "#given_name")
    public WebElement firstName;

    @FindBy(css = "#family_name")
    public WebElement lastName;

    @FindBy(css = "#street")
    public WebElement street;

    @FindBy(css = "#postalCode")
    public WebElement zipCode;

    @FindBy(css = "#city")
    public WebElement city;

    @FindBy(css = "#stateSelector")
    public WebElement stateDropDown;

    @FindBy (css = "#countrySelector")
    public WebElement countryDropDown;

    @FindBy(css = "#phone_number")
    public WebElement phoneNumber;

    @FindBy(css = "#nickname")
    public WebElement nicknameAddress;

    @FindBy(css = ".address")
    public WebElement primaryAddress;
}
