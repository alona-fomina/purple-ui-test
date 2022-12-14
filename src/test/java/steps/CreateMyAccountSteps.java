package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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

    @And("user puts user information in create account section")
    public void userPutsUserInformationInCreateAccountSection() {
        createAccountPage.firstNameInput.sendKeys(purpleRandomUser.firstName);
        createAccountPage.lastNameInput.sendKeys(purpleRandomUser.lastName);
        createAccountPage.phoneNumberInput.sendKeys(purpleRandomUser.phoneNumber);
        createAccountPage.passwordInput.sendKeys(purpleRandomUser.password);
    }
}
