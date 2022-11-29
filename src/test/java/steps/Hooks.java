package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.CheckOutPage;
import pages.PurpleCartsPage;
import pages.PurpleLogin;
import pages.PurpleMain;
import pages.bedding.BeddingPage;
import pages.mattress.MattressesPage;
import pages.pillows.PillowPage;
import pages.sheets.SheetsPage;
import utils.seleniumUtils.Driver;
import utils.validationUtils.ReportUtils;

public class Hooks {
    public static WebDriver driver;
    public static PurpleMain purpleMain;
    public static MattressesPage purpleMattressesPage;
    public static PurpleCartsPage purpleCartsPage;
    public static PurpleLogin purpleLogin;
    public static CheckOutPage checkOutPage;
    public static PillowPage pillowPage;
    public static SheetsPage sheetsPage;
    public static BeddingPage beddingPage;


    @Before
    public void setup() {
        driver = Driver.getDriver();
        purpleMain = new PurpleMain();
        purpleMattressesPage = new MattressesPage();
        purpleCartsPage = new PurpleCartsPage();
        purpleLogin = new PurpleLogin();
        checkOutPage = new CheckOutPage();
        pillowPage = new PillowPage();
        sheetsPage = new SheetsPage();
        beddingPage = new BeddingPage();
    }

    @After
    public void teardown(Scenario scenario) {
        ReportUtils.takeScreenshot(driver, scenario);
        Driver.quitDriver();
    }
}
