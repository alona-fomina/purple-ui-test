package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.PurpleCartsPage;
import pages.PurpleMain;
import pages.PurpleMattressesPage;
import utils.seleniumUtils.Driver;
import utils.validationUtils.ReportUtils;

public class Hooks {
    public static WebDriver driver;
    public static PurpleMain purpleMain;
    public static PurpleMattressesPage purpleMattressesPage;
    public static PurpleCartsPage purpleCartsPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        purpleMain = new PurpleMain();
        purpleMattressesPage = new PurpleMattressesPage();
        purpleCartsPage = new PurpleCartsPage();
    }

    @After
    public void teardown(Scenario scenario) {
        ReportUtils.takeScreenshot(driver, scenario);
        Driver.quitDriver();
    }
}
