package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps", // which package

        dryRun = true,

        plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json"},

        tags = ""  // ADD the @


)


public class TestRunner {
}
