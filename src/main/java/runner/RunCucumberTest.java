package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        features = "src/test/java/resources/features",
        monochrome = true,
        plugin = {"pretty", "html:target/Report", "json:target/Distributor.json"}
)
public class RunCucumberTest {
}
