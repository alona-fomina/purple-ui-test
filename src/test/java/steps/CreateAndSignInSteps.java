package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.readerUtils.ConfigReader;
import utils.seleniumUtils.DropdownHandler;
import utils.seleniumUtils.FrameUtils;
import utils.seleniumUtils.Waiter;
import utils.seleniumUtils.WindowHandleUtils;
import utils.validationUtils.AssertionUtils;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static steps.Hooks.*;

public class CreateAndSignInSteps {

    String firstTabId = "";
    String secondTabId = "";
    String thirdTabId = "";

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
        firstTabId = WindowHandleUtils.openLinkInNewTab(url);
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
        driver.switchTo().window(firstTabId);

    }

    @And("user puts random user information in create account section")
    public void userPutsRandomUserInformationInCreateAccountSection() {
        createAccountPage.firstNameInput.sendKeys(purpleRandomUser.firstName);
        createAccountPage.lastNameInput.sendKeys(purpleRandomUser.lastName);
        createAccountPage.phoneNumberInput.sendKeys(purpleRandomUser.phoneNumber);
        createAccountPage.passwordInput.sendKeys(purpleRandomUser.password);
        createAccountPage.emailInput.sendKeys(purpleRandomUser.emailAddress);
        createAccountPage.createAccountButton.click();
    }

    @And("user verified email address")
    public void userVerifiedEmailAddress() {
        WindowHandleUtils.switchToCertainWindowWithUrl(driver, "https://temp-mail.org/");
        //        tempEmailPage.refreshButton.click();
        // click email item
        Waiter.waitForUntilTextToBePresentInElement(driver, tempEmailPage.emailItem, "purple");
        tempEmailPage.emailItem.click();

        // switch to iframe
        // get the link from complete verification button with getAttribute method and store it
        // get out of the iframe
        // modify the string
        String verLink = FrameUtils
                .getAttributesFromIFrameElement(tempEmailPage.messageIFrame, tempEmailPage.completeVerification, "href")
                .replace("https://purple.com/", ConfigReader.getProperty("homepage"));

        // go to the modified url with new tab method
        driver.get(verLink);
    }

    @And("user logs in with random user credentials")
    public void userLogsInWithRandomUserCredentials() {
        Hooks.purpleLogin.login(purpleRandomUser.emailAddress, purpleRandomUser.password);
    }


    @Then("user validates random user dashboard")
    public void userValidatesRandomUserDashboard(DataTable expectedLeftNavMenuTexts) {
        AssertionUtils.validateElementText(userDashboard.welcomeMessage, "Hi " + purpleRandomUser.firstName + ", Welcome Back!");
        AssertionUtils.validateElementLinks(userDashboard.accountNavMenu);
        AssertionUtils.validateElementTexts(userDashboard.accountNavMenu, expectedLeftNavMenuTexts.asList());
    }

    @Then("user click on My Order and validating order history")
    public void userClickOnMyOrderAndValidatingOrderHistory() {
        userDashboard.clickLeftMenuByText("My Orders");
        AssertionUtils.validateElementText(ordersPage.emptyOrdersMessage, "There are currently no orders associated with your account.");
        AssertionUtils.validateButton(ordersPage.shopNowButton, "Shop Now");
    }

    @And("user logs in with {string}, {string} credentials")
    public void userLogsInWithCredentials(String email, String pass) {
        Hooks.purpleLogin.login(email, pass);
    }

    @And("user puts user information in sign in section")
    public void userPutsUserInformationInSignInSection() {
        signInPage.emilInputBar.sendKeys(purpleUser.emailAddress);
        signInPage.passwordInputBar.sendKeys(purpleUser.password);
        signInPage.singInButton.click();
    }

    @Then("user click on My Profile and validating user credentials and changing them")
    public void userClickOnMyProfileAndValidatingUserCredentialsAndChangingThem() {
        userDashboard.clickLeftMenuByText("My Profile");

        //validating name, phone number, email, and password is the purple random user ONE
        AssertionUtils.validateElementText(myProfilePage.userInformation.get(0), purpleRandomUser.firstName + " " + purpleRandomUser.lastName);
        AssertionUtils.validatePhoneNumber(myProfilePage.userInformation.get(1), purpleRandomUser.phoneNumber);
        AssertionUtils.validateElementText(myProfilePage.userInformation.get(2), purpleRandomUser.emailAddress);
        Assert.assertTrue(myProfilePage.userInformation.get(3).getText().replace("*", "").isEmpty());


        //validating and resetting name of the user
        myProfilePage.editProfile.get(0).click();
        myProfilePage.changeFirstName.clear();
        myProfilePage.changeFirstName.sendKeys(purpleRandomUser2.firstName);
        myProfilePage.changeLastName.clear();
        myProfilePage.changeLastName.sendKeys(purpleRandomUser2.lastName);
        myProfilePage.saveChangesButton.click();
        AssertionUtils.validateElementText(myProfilePage.userInformation.get(0), purpleRandomUser2.firstName + " " + purpleRandomUser2.lastName);

        //validating and resetting phone number of the user
        myProfilePage.editProfile.get(1).click();
        myProfilePage.changePhoneNumber.clear();
        myProfilePage.changePhoneNumber.sendKeys(purpleRandomUser2.phoneNumber);
        myProfilePage.saveChangesButton.click();
        AssertionUtils.validatePhoneNumber(myProfilePage.userInformation.get(1), purpleRandomUser2.phoneNumber);

        //validating and resetting email address
        myProfilePage.editProfile.get(2).click();
        myProfilePage.changeEmail.clear();

        //stored second tabId and closed the first tab
        secondTabId = driver.getWindowHandle();
        driver.switchTo().window(firstTabId);
        driver.close();
        //switched back to second tab
        driver.switchTo().window(secondTabId);


        // open up the third tab and go to temp email website

        WindowHandleUtils.openLinkInNewTab(ConfigReader.getProperty("tempEmailWebSite"));
        // NOTE: don't forget to change the email and assign it to the random user 2
        Waiter.waitForElementClickable(driver, tempEmailPage.changeButton);
        tempEmailPage.changeButton.click();
        tempEmailPage.popUpOk.click();
        tempEmailPage.copyButton.click();

        try {
            purpleRandomUser2.emailAddress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); // extracting the text that was copied to the clipboard
        } catch (UnsupportedFlavorException e) {
            System.out.println("COPYING TO THE CLIPBOARD HAS FAILED!!!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("COPYING TO THE CLIPBOARD HAS FAILED!!!");
            e.printStackTrace();

        }

        //come back to the second tab and send the random user 2 email
        thirdTabId = driver.getWindowHandle();
        driver.switchTo().window(secondTabId);

        //save the email
        myProfilePage.changeEmail.sendKeys(purpleRandomUser2.emailAddress);
        myProfilePage.saveChangesButton.click();

        // go back to the third tab and wait for the one time verification email verify it and close it
        driver.switchTo().window(thirdTabId);
        Waiter.waitForUntilTextToBePresentInElement(driver, tempEmailPage.emailItem, "purple");
        tempEmailPage.emailItem.click();

        // switch to iframe
        // get the link from complete verification button with getAttribute method and store it
        // get out of the iframe
        // modify the string
        String verLink = FrameUtils
                .getAttributesFromIFrameElement(tempEmailPage.messageIFrame, tempEmailPage.completeVerification, "href")
                .replace("https://purple.com/", ConfigReader.getProperty("homepage"));

        // go to the modified url with new tab method
        driver.get(verLink);
        AssertionUtils.validateURLContains(driver, ConfigReader.getProperty("homepage") + "account/orders");
        driver.close();

        // go back to second tab refresh and continue...
        driver.switchTo().window(secondTabId);
        driver.navigate().refresh();

        //change password
        myProfilePage.editProfile.get(3).click();
        myProfilePage.currentPassword.sendKeys(purpleRandomUser.password);
        myProfilePage.newPassword.sendKeys(purpleRandomUser2.password);
        myProfilePage.confirmPassword.sendKeys(purpleRandomUser2.password);
        myProfilePage.saveChangesButton.click();
        Assert.assertTrue(myProfilePage.userInformation.get(3).getText().replace("*", "").isEmpty());

    }

    @Then("user click on Manage Addresses and checking, adding, changing and reviewing")
    public void userClickOnManageAddressesAndCheckingAddingChangingAndReviewing() {
        userDashboard.clickLeftMenuByText("Manage Addresses");
        AssertionUtils.validateElementText(manageAddressesPage.noAddressesMessage, "There are currently no addresses associated with your account.");
        manageAddressesPage.addNewAddressButton.click();
        manageAddressesPage.firstName.sendKeys(purpleRandomUser2.firstName);
        manageAddressesPage.lastName.sendKeys(purpleRandomUser2.lastName);
        manageAddressesPage.street.sendKeys(purpleRandomUser2.streetAddress1);
        manageAddressesPage.zipCode.sendKeys(purpleRandomUser2.zipCode);
        DropdownHandler.selectOptionByValue(manageAddressesPage.stateDropDown, purpleRandomUser2.state);
        DropdownHandler.selectOptionByValue(manageAddressesPage.countryDropDown, "US");
        manageAddressesPage.phoneNumber.sendKeys(purpleRandomUser2.phoneNumber);
        manageAddressesPage.nicknameAddress.sendKeys("Primary");
        manageAddressesPage.saveChangesButton.click();

        AssertionUtils.validateElementText(manageAddressesPage.primaryAddress,
                "Primary Address\n" +
                        purpleRandomUser2.firstName + " " + purpleRandomUser2.lastName + "\n" +
                        purpleRandomUser2.streetAddress1 + "\n" +
                        purpleRandomUser2.city + ", " + purpleRandomUser2.state + " " + purpleRandomUser2.zipCode
        );


    }
    @Then("user click on Sign Out and validates redirected to sign in portal")
    public void userClickOnSignOutAndValidatesRedirectedToSignInPortal() {
        userDashboard.clickLeftMenuByText("Sign Out");
        AssertionUtils.validateURLContains(driver,"/account/login");
    }
}
