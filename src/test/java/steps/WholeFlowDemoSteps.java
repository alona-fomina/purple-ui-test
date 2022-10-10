package steps;

import io.cucumber.java.en.And;

import static steps.Hooks.*;

public class WholeFlowDemoSteps {

    @And("user clicks on {string} from top navigation")
    public void userClicksOnFromTopNavigation(String topMenuItemText) {
        purpleMain.clickTopMenuItem(topMenuItemText);
    }

    @And("user navigates to Purple Mattress")
    public void userNavigatesToPurpleMattress() {
        purpleMattressesPage.purpleMattressShopNow.click();
    }

    @And("user adds Purple Mattress to the cart")
    public void userAddsPurpleMattressToTheCart() {
        purpleMattressesPage.addToCartButton.click();
        purpleMattressesPage.noThanksContinueToCart.click();
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        purpleCartsPage.proceedToCheckOutLink.click();
    }

    @And("click on the Pillow button")
    public void clickOnThePillowButton() {
    }
}
