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
<<<<<<< HEAD:src/test/java/runners/apitestrunner/ApiTestRunner.java
        tags = "@Api_US01"
=======
        tags = "@TC03_Api"
>>>>>>> main:src/test/java/runners/api_testrunner/ApiTestRunner.java

)
public class ApiTestRunner {
}
