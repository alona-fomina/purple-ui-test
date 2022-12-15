package steps;

import io.cucumber.java.en.When;
import utils.seleniumUtils.WindowHandleUtils;

public class TestStep {
    @When("user goes to {string} on new tab")
    public void userGoesToOnNewTab(String url) {
        WindowHandleUtils.openLinkInNewTab(url);
    }
}
