package utils.validationUtils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReportUtils {
    public static void takeScreenshot(WebDriver driver, Scenario scenario){
        if (scenario.isFailed()){
            try{
                scenario.attach(
                        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                        "image/png",
                        "screenshot");
            }catch (Exception e){
                System.out.println("Failed to take screenshot");
            }
        }else{
            System.out.println("Scenario PASSED!");
        }
    }
}
