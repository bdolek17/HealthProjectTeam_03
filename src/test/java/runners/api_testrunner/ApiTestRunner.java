package runners.api_testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "rerun:target/failedRerun.txt"
        },
        monochrome=true,
        features = "./src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        dryRun = false,

        tags = "@Api_US01"

        //tags = "@TC03_Api"


)
public class ApiTestRunner {
}
