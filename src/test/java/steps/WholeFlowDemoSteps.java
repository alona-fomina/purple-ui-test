package steps;

import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;

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
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", purpleMattressesPage.addToCartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", purpleMattressesPage.addToCartButton);
        purpleMattressesPage.addToCartButton.click();
        purpleMattressesPage.noThanksContinueToCart.click();
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        purpleCartsPage.proceedToCheckOutLink.click();
    }
}
