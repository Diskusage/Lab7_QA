package hellocucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber_report.html"},
        features = "src/test/resources/hellocucumber",
        monochrome = true
        )
public class RunCucumberTest {

}
