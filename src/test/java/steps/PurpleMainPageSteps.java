package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.validationUtils.AssertionUtils;

import static steps.Hooks.*;

public class PurpleMainPageSteps {

    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        driver.get(url);
    }

    @Then("user should see purple logo")
    public void userShouldSeePurpleLogo() {
        AssertionUtils.validateElementDisplayed(purpleMain.purpleLogo);
    }

    @And("dismisses the popup")
    public void dismissesThePopup() {
        purpleMain.closeEmailPopup.click();
    }

    @Then("Validate navigation headers")
    public void validateNavigationHeaders(DataTable expectedNavHeaders) {
        AssertionUtils.validateElementLinks(purpleMain.topNavMenuItems);
        AssertionUtils.validateElementTexts(purpleMain.topNavMenuItems, expectedNavHeaders.asList());
    }
}
