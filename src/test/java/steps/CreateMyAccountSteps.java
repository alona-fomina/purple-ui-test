package steps;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.readerUtils.ConfigReader;
import utils.seleniumUtils.FrameUtils;
import utils.seleniumUtils.Waiter;
import utils.seleniumUtils.WindowHandleUtils;
import utils.validationUtils.AssertionUtils;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Locale;

import static steps.Hooks.*;

public class CreateMyAccountSteps {

    @And("user click on My Account button")
    public void userClickOnMyAccountButton() {
        purpleMain.myAccountButton.click();
    }

    @Then("user click Create One link")
    public void userClickCreateOneLink() {
        signInPage.createAccountLink.click();
    }

    @And("user goes to {string} and getting temporary email address")
    public void userGoesToAndGettingTemporaryEmailAddress(String url) {
        String mainWindow = WindowHandleUtils.openLinkInNewTab(url);
        Waiter.waitForElementClickable(driver, tempEmailPage.copyButton);
        tempEmailPage.copyButton.click();

        try {
            purpleRandomUser.emailAddress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); // extracting the text that was copied to the clipboard
        } catch (UnsupportedFlavorException e) {
            System.out.println("COPYING TO THE CLIPBOARD HAS FAILED!!!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("COPYING TO THE CLIPBOARD HAS FAILED!!!");
            e.printStackTrace();

        }
        driver.switchTo().window(mainWindow);

    }

    @And("user puts user information in create account section")
    public void userPutsUserInformationInCreateAccountSection() {
        createAccountPage.firstNameInput.sendKeys(purpleRandomUser.firstName);
        createAccountPage.lastNameInput.sendKeys(purpleRandomUser.lastName);
        createAccountPage.phoneNumberInput.sendKeys(purpleRandomUser.phoneNumber);
        createAccountPage.passwordInput.sendKeys(purpleRandomUser.password);
        createAccountPage.emailInput.sendKeys(purpleRandomUser.emailAddress);
        createAccountPage.createAccountButton.click();
    }

    @And("user verified email address")
    public void userVerifiedEmailAddress() {
        WindowHandleUtils.switchToCertainWindowWithUrl(driver,"https://temp-mail.org/");
        //        tempEmailPage.refreshButton.click();
        // click email item
        Waiter.waitForUntilTextToBePresentInElement(driver,tempEmailPage.emailItem, "purple");
        tempEmailPage.emailItem.click();

        // switch to iframe
        // get the link from complete verification button with getAttribute method and store it
        // get out of the iframe
        // modify the string
        String verLink = FrameUtils
                .getAttributesFromIFrameElement(tempEmailPage.messageIFrame,tempEmailPage.completeVerification, "href")
                .replace("https://purple.com/", ConfigReader.getProperty("homepage"));

        // go to the modified url with new tab method
        driver.get(verLink);
    }

    @And("user logs in with random user credentials")
    public void userLogsInWithRandomUserCredentials() {
        Hooks.purpleLogin.login(purpleRandomUser.emailAddress, purpleRandomUser.password);
    }


    @Then("user validates random user dashboard")
    public void userValidatesRandomUserDashboard() {
        AssertionUtils.validateElementText(userDashboard.welcomeMessage,"Hi " + purpleRandomUser.firstName +", Welcome Back!");
    }
}
