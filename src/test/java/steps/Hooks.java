package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.*;
import pages.bedFrames.BedFramesPage;
import pages.bedding.BeddingPage;
import pages.mattress.MattressesPage;
import pages.myAccount.CreateAccountPage;
import pages.myAccount.SignInPage;
import pages.myAccount.TempEmailPage;
import pages.myAccount.UserDashboard;
import pages.pillows.PillowPage;
import pages.seatCushions.SeatCushionsPage;
import pages.sheets.SheetsPage;
import utils.dataHelpers.PurpleUser;
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
    public static ParentPage parentPage;
    public static BedFramesPage bedFramesPage;
    public static SeatCushionsPage seatCushionsPage;
    public static SignInPage signInPage;
    public static CreateAccountPage createAccountPage;
    public static PurpleUser purpleUser;
    public static PurpleUser purpleRandomUser;
    public static TempEmailPage tempEmailPage;
    public static UserDashboard userDashboard;

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
        parentPage = new ParentPage();
        bedFramesPage = new BedFramesPage();
        seatCushionsPage = new SeatCushionsPage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        tempEmailPage = new TempEmailPage();
        userDashboard = new UserDashboard();

        purpleUser = PurpleUser.getInstance();
        purpleRandomUser = PurpleUser.getRandomInstance();

        System.out.println("EXISTING USER = \"" + purpleUser + "\nRANDOM USER = " + purpleRandomUser);
    }

    @After
    public void teardown(Scenario scenario) {
        ReportUtils.takeScreenshot(driver, scenario);
        Driver.quitDriver();
    }
}
