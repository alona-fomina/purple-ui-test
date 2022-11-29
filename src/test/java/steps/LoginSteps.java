package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;

public class LoginSteps {

    public String token;
    @And("user logs in with {string}, {string} credentials")
    public void userLogsInWithCredentials(String email, String pass) {
        Hooks.purpleLogin.login(email, pass);
    }

    @And("takes the {string} from local storage")
    public void takesTheFromLocalStorage(String key) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Hooks.driver;

        //LocalStorage
        String value = (String) jsExecutor.executeScript(String.format("return window.localStorage.getItem('%s');", key));
        System.out.println("LOCAL STORAGE VALUE -->" + value);
        token = value;
    }

    @Then("user hits the active cart API")
    public void userHitsTheActiveCartAPI() {

        Response response = RestAssured
                .given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when().get("https://commerce-api-stage.purple.com/carts/active-cart")
                .then().log().all()
                .extract().response();

        System.out.println("STATUS CODE => " + response.statusCode());
    }
}
