package steps;

import io.cucumber.java.en.And;
import utils.seleniumUtils.Waiter;

public class CommonSteps {
    @And("user waits {int} seconds")
    public void userWaitsSeconds(int seconds) throws Exception{
        Waiter.sleep(seconds * 1000);
    }
}
