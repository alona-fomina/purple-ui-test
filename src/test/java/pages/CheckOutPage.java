package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckOutPage extends ParentPage {
    public CheckOutPage() {
        super();
    }

    @FindBy(css = "#MainBlockAmzBtn_button")
    public WebElement amazonPayButton;

    @FindBy(css = "#paypal-stepped-checkout-express-button")
    public WebElement payPalButton;

    @FindBy(css = "#shipping-firstName")
    public WebElement firstNameShippingInput;

    @FindBy(css = "#shipping-lastName")
    public WebElement lastNameShippingInput;

    @FindBy(css = "#shipping-streetAddress")
    public WebElement streetAddressShippingInput;

    @FindBy(css = "#shipping-additionalStreetInfo")
    public WebElement apartmentFlorShippingInput;

    @FindBy(css = "#shipping-postalCode")
    public WebElement zipShippingInput;

    @FindBy(css = "#shipping-city")
    public WebElement cityShippingInput;

    @FindBy(css = "select[id='shipping-state']")
    public WebElement stateShippingDropdown;

    @FindBy(css = "#shipping-phone")
    public WebElement phoneNumberShippingInput;

    @FindBy(css = "#shipping-email")
    public WebElement emailShippingInput;

    @FindBy(xpath = "//input[@id='signupForNewsletter'']/following-sibling::label/div[1]")
    public WebElement singUpForUpdatesRadioButton;

    @FindBy(xpath = "(//button[@data-testid='primary-button'])[1]")
    public WebElement nextDeliveryMethod;

    @FindBy(xpath = "(//button[@class='btn'])[2]")
    public WebElement verifyShippingButton;

    @FindBy(xpath = "(//button[@data-testid='primary-button'])[1]")
    public WebElement nextPaymentInfoButton;

    @FindBy(xpath = "(//div[@role='radio'])[1]")
    public WebElement creditCardRadioButton;

    @FindBy(xpath = "(//div[@role='radio'])[2]")
    public WebElement affirmPaymentRadioButton;

    @FindBy(css = "div[class='_6lLnIWZPR4sDugGis7DXyw==']")
    public WebElement getAffirmPaymentRadioButton;

    @FindBy(css = "svg[aria-label='Affirm logo']")
    public WebElement affirmLogo;

    @FindBy(css = "input[class='focusable-form-field pro11TnYcue pro284gg8sY']")
    public WebElement affirmMobileNumberInput;

    @FindBy(css = "button[class='pro35Wfly4z pro2TSiV0Gx pro300N0DVx profBy8oj9g']")
    public WebElement affirmContinueButton;

    @FindBy(xpath = "(//div[@role='radio'])[3]")
    public WebElement payPalPaymentRadioButton;

    @FindBy(xpath = "(//div[@role='radio'])[4]")
    public WebElement amazonPayRadioButton;

    @FindBy(name = "first-data-payment-field-name")
    public WebElement nameOnTheCardIFrame;

    @FindBy(name = "first-data-payment-field-card")
    public WebElement creditCardNumberIFrame;

    @FindBy(name = "first-data-payment-field-exp")
    public WebElement expirationDateIFrame;

    @FindBy(name = "first-data-payment-field-cvv")
    public WebElement securityCodeIFrame;

    @FindBy(css = "#name")
    public WebElement creditCardFullNameInput;

    @FindBy(css = "#card")
    public WebElement creditCardNumberInput;

    @FindBy(css = "#exp")
    public WebElement expDateInput;

    @FindBy(css = "#cvv")
    public WebElement securityCodeInput;

    @FindBy(xpath = "(//div[@role='radio'])[5]")
    public WebElement billingAddressSameAsShipping;

    @FindBy(xpath = "(//div[@role='radio'])[6]")
    public WebElement differentBillingAddress;

    @FindBy(css = "#billing-firstName")
    public WebElement billingAddressFirstName;

    @FindBy(css = "#billing-lastName")
    public WebElement billingAddressLAstName;

    @FindBy(css = "#billing-streetAddress")
    public WebElement billingStreetAddress;

    @FindBy(css = "#billing-additionalStreetInfo")
    public WebElement billingAdditionalStreetInfo;

    @FindBy(css = "#billing-postalCode")
    public WebElement billingPostalCode;

    @FindBy(css = "#billing-city")
    public WebElement billingCity;

    @FindBy(css = "select[id='billing-state'] option")
    public List<WebElement> billingStates;

    @FindBy(xpath = "(//button[text()='Complete Order'])[1]")
    public WebElement completeOrderButton;

    @FindBy(css = "#stepshipping .pac-container div")
    public List<WebElement> autofillShippingAddresses;
}
