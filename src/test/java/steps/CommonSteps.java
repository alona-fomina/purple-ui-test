package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.readerUtils.ConfigReader;
import utils.seleniumUtils.Waiter;

public class CommonSteps {
    @And("user waits {int} seconds")
    public void userWaitsSeconds(int seconds) throws Exception{
        Waiter.sleep(seconds * 1000);
    }

    @Given("user goes to homepage")
    public void userGoesToHomepage() {
        Hooks.driver.get(ConfigReader.getProperty("homepage"));
    }
}
