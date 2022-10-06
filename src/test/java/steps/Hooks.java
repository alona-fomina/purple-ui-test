package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.PurpleMain;
import utils.seleniumUtils.Driver;
import utils.validationUtils.ReportUtils;

public class Hooks {
    public static WebDriver driver;
    public static PurpleMain purpleMain;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        purpleMain = new PurpleMain();
    }

    @After
    public void teardown(Scenario scenario) {
        ReportUtils.takeScreenshot(driver, scenario);
        Driver.quitDriver();
    }
}
