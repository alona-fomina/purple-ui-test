package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CheckOutPage;
import pages.mattress.MattressesPage;
import utils.seleniumUtils.*;

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
        }
    }

    @And("user adds {string} to the cart")
    public void userAddsToTheCart(String product) {
        switch (product) {
            case "Purple Mattress":
                JavaScriptUtils.clickElementScrollIfIntercepted(purpleMattressesPage.addToCartButton, 48);
                purpleMattressesPage.noThanksContinueToCart.click();
                break;
            case "Purple Harmony™ Pillow":
                JavaScriptUtils.clickElementScrollIfIntercepted(pillowPage.addToTheCarButton, 48);
                pillowPage.noThanksContinueToCart.click();
                break;
            case "Kid's Sheets":
                JavaScriptUtils.clickElementScrollIfIntercepted(sheetsPage.addToTheCarButton, 48);
                sheetsPage.noThanksContinueToCart.click();
                break;
            case "Purple Duvet":
                JavaScriptUtils.clickElementScrollIfIntercepted(beddingPage.addToTheCarButton, 48);
                beddingPage.noThanksContinueToCart.click();
                break;
        }
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        JavaScriptUtils.clickElementScrollIfIntercepted(purpleCartsPage.proceedToCheckOutLink, 48);
    }

    @Then("user sends user information into shipping information menu")
    public void userSendsUserInformationIntoShippingInformationMenu() {
        checkOutPage.firstNameShippingInput.sendKeys("Alona");
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

    @And("user confirm that shipping is the same as billing address")
    public void userConfirmThatShippingIsTheSameAsBillingAddress() {
        checkOutPage.verifyShippingButton.click();
    }

    @And("then user click on paymentInfo button")
    public void thenUserClickOnPaymentInfoButton() {
        checkOutPage.nextPaymentInfoButton.click();
    }

    @Then("user send credit card information")
    public void userSendCreditCardInformation() {
        FrameUtils.sendKeysToIframeElement(checkOutPage.nameOnTheCardIFrame, checkOutPage.creditCardFullNameInput, "Alona Fomina");
        FrameUtils.sendKeysToIframeElement(checkOutPage.creditCardNumberIFrame, checkOutPage.creditCardNumberInput, "5500000000000004");
        FrameUtils.sendKeysToIframeElement(checkOutPage.expirationDateIFrame, checkOutPage.expDateInput, "1126");
        FrameUtils.sendKeysToIframeElement(checkOutPage.securityCodeIFrame, checkOutPage.securityCodeInput, "233");

    }

    @And("user complete order")
    public void userCompleteOrder() {
        checkOutPage.completeOrderButton.click();
    }

}
