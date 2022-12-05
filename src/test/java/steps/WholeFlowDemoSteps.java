package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NotFoundException;
import utils.seleniumUtils.*;
import utils.validationUtils.AssertionUtils;

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
        checkOutPage.firstNameShippingInput.sendKeys("dfghjk ");
        checkOutPage.lastNameShippingInput.sendKeys("Fomina");
        checkOutPage.streetAddressShippingInput.sendKeys("233 Wood Creeek Rd");
        checkOutPage.apartmentFlorShippingInput.sendKeys("305");
        checkOutPage.zipShippingInput.sendKeys("60090");
        checkOutPage.cityShippingInput.sendKeys("Wheeling");
        DropdownHandler.selectOptionByValue(checkOutPage.stateShippingDropdown, "IL");
        checkOutPage.phoneNumberShippingInput.sendKeys("2345678900");
        checkOutPage.emailShippingInput.sendKeys("alona@purple.com");
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
        FrameUtils.sendKeysToIframeElement(checkOutPage.nameOnTheCardIFrame, checkOutPage.creditCardFullNameInput, "Alona FominaAlona Fomina");
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
}
