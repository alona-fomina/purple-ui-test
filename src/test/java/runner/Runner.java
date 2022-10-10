package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = "src/test/resources",
        glue = "steps",
        tags = "@purpleMain",
        plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"}
)
public class Runner {

}
