package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.seleniumUtils.Waiter;

public class TestSteps {
    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        Hooks.driver.get(url);
    }

    @And("waits for {int} seconds")
    public void waitsForSeconds(int seconds) throws Exception{
        Waiter.sleep(seconds * 1000);
    }
}
