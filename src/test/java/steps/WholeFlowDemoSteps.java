package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NotFoundException;
import utils.seleniumUtils.*;
import utils.validationUtils.AssertionUtils;

import java.util.Locale;

import static steps.Hooks.*;

public class WholeFlowDemoSteps {

    @And("user clicks on {string} from top navigation")
    public void userClicksOnFromTopNavigation(String topMenuItemText) {
        purpleMain.clickTopMenuItem(topMenuItemText);
    }

    @And("user navigates to {string}")
    public void userNavigatesTo(String page) {
        switch (page) {
            case "Purple Mattress":
                purpleMattressesPage.purpleMattressShopNow.click();
                break;
            case "Pillows":
                pillowPage.purpleHarmonyPillow.click();
                break;
            case "Sheets":
                sheetsPage.kidsSheets.click();
                break;
            case "Bedding":
                beddingPage.purpleDuvet.click();
                break;
            case "Bed Frames":
                bedFramesPage.ascentAdjustableBase.click();
                break;
            case "Seat Cushions":
                seatCushionsPage.ultimateSeatCushion.click();
                break;
        }
    }

    @And("user adds {string} to the cart")
    public void userAddsToTheCart(String product) {
        try {
            ActionsUtils.persistentClick(parentPage.addToTheCartButton, 35);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        parentPage.noThanksContinueToCart.click();
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        JavaScriptUtils.clickElementScrollIfIntercepted(purpleCartsPage.proceedToCheckOutLink, 48);
    }

    @Then("user sends user information into shipping information menu")
    public void userSendsUserInformationIntoShippingInformationMenu() {
        Faker faker = new Faker(new Locale("en-us"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        checkOutPage.firstNameShippingInput.sendKeys(firstName);
        checkOutPage.lastNameShippingInput.sendKeys(lastName);
        checkOutPage.streetAddressShippingInput.sendKeys("4100 N Chapel Hill Dr");
//        checkOutPage.apartmentFlorShippingInput.sendKeys("8");
        checkOutPage.zipShippingInput.sendKeys("60004");
        checkOutPage.cityShippingInput.sendKeys("Arlington Heights");
        DropdownHandler.selectOptionByValue(checkOutPage.stateShippingDropdown, "IL");
        checkOutPage.phoneNumberShippingInput.sendKeys(faker.phoneNumber().cellPhone());
        checkOutPage.emailShippingInput.sendKeys(email);
        checkOutPage.nextDeliveryMethod.click();
    }

    @And("then user click on paymentInfo button")
    public void thenUserClickOnPaymentInfoButton() {
        checkOutPage.nextPaymentInfoButton.click();
    }

    @And("user confirm that shipping is the same as billing address")
    public void userConfirmThatShippingIsTheSameAsBillingAddress() {
        checkOutPage.verifyShippingButton.click();
    }


    @Then("user send credit card information")
    public void userSendCreditCardInformation() {
        Waiter.waitForElementVisible(driver, checkOutPage.nameOnTheCardIFrame);
        FrameUtils.sendKeysToIframeElement(checkOutPage.nameOnTheCardIFrame, checkOutPage.creditCardFullNameInput, "Alona Fomina");
        FrameUtils.sendKeysToIframeElement(checkOutPage.creditCardNumberIFrame, checkOutPage.creditCardNumberInput, "5500000000000004");
        FrameUtils.sendKeysToIframeElement(checkOutPage.expirationDateIFrame, checkOutPage.expDateInput, "1126");
        FrameUtils.sendKeysToIframeElement(checkOutPage.securityCodeIFrame, checkOutPage.securityCodeInput, "233");

    }

    @And("user complete order")
    public void userCompleteOrder() {
        checkOutPage.completeOrderButton.click();
    }

    /**
     * @param expressWay  => amazon or paypal
     * @param expectedURL
     */
    @And("user proceeds to {string} express checkout where URL is {string}")
    public void userProceedsToExpressCheckoutWhereURLIs(String expressWay, String expectedURL) {

        switch (expressWay.toLowerCase()) {
            case "amazon":
                purpleCartsPage.getExpressCheckOutAmazonPay.click();
                break;
            case "paypal":
//                FrameUtils.clickOnElementInIFrame(purpleCartsPage.payPalIFrame, purpleCartsPage.expressCheckOutPayPal);
                purpleCartsPage.expressCheckOutPayPal2.click();
                break;
            default:
                throw new NotFoundException("The express way you are trying to checkout doesn't exist!");
        }

        // switching window to where URL is "https://apay-us.amazon.com/"
        // storing the ID of the main window
        Waiter.sleep(5000);
        for (String windowHandle : driver.getWindowHandles()) {
            System.out.println(windowHandle);
        }
        String mainWindowId = WindowHandleUtils.switchToCertainWindowWithUrl(driver, expectedURL);
        Waiter.waitUntilURLContains(driver, expectedURL);
        AssertionUtils.validateURLStartsWith(driver, expectedURL);

        driver.close();
        driver.switchTo().window(mainWindowId);
    }

    @And("then user click on Affirm radio button")
    public void thenUserClickOnAffirmRadioButton() {
        Waiter.waitForElementClickable(driver,checkOutPage.affirmPaymentRadioButton);
       checkOutPage.affirmPaymentRadioButton.click();
       checkOutPage.getAffirmPaymentRadioButton.click();

       driver.switchTo().frame(checkOutPage.affirmIframe);
      AssertionUtils.validateElementDisplayed(checkOutPage.affirmLogo);
      AssertionUtils.validateElementDisplayed(checkOutPage.affirmPartnershipText);

      AssertionUtils.validateElementEnabled(checkOutPage.affirmContinueButton);
      AssertionUtils.validateElementEnabled(checkOutPage.affirmMobileNumberInput);
    }

    @Then("user sends user information randomly")
    public void userSendsUserInformationRandomly() {
        Faker faker = new Faker(new Locale("en-us"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String street1 = faker.address().streetAddress();
        String city = faker.address().city();
        String state = "";
        do {
            state = faker.address().stateAbbr();
        } while (state.equals("AL") || state.equals("HI"));
        String zipCode = faker.address().zipCodeByState(state);

        System.out.println("Your random user information {" +
                "firstName = " + firstName +
                ", lastName = " + lastName +
                ", email = " + email +
                ", street1 = " + street1 +
                ", city = " + city +
                ", state = " + state +
                ", zipCode = " + zipCode +
                "}");

        checkOutPage.firstNameShippingInput.sendKeys(firstName);
        checkOutPage.lastNameShippingInput.sendKeys(lastName);
        checkOutPage.streetAddressShippingInput.sendKeys(street1);
//        checkOutPage.apartmentFlorShippingInput.sendKeys("8");
        checkOutPage.zipShippingInput.sendKeys(zipCode);
        checkOutPage.cityShippingInput.sendKeys(city);
        DropdownHandler.selectOptionByValue(checkOutPage.stateShippingDropdown, state);
        checkOutPage.phoneNumberShippingInput.sendKeys(faker.phoneNumber().cellPhone());
        checkOutPage.emailShippingInput.sendKeys(email);
        checkOutPage.nextDeliveryMethod.click();
    }

    @And("user agrees with the privacy policy")
    public void userAgreesWithThePrivacyPolicy() {
        try{
            purpleMain.policyPopUpButton.click();}
        catch (NotFoundException e){
            System.out.println("Pop-up wasn't visible");
        }
    }
}
