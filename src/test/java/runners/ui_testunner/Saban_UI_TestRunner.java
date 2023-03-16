package runners.ui_testunner;

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
        //tags = "@US23_TC01"
        tags = "@US23_TC02"
        //tags = "@US23_TC03"
        //tags = "@US23_TC04"
        //tags = "@US23_TC05_API"
        //tags = "@US23_TC06_DB"
        //tags = "@US23_TC07"
        //tags = "@US23_TC08_API"
        //tags = "@US23_TC09_DB"
        //tags = "@US23_TC10"
        //tags = "@US23_TC11_API"
        //tags = "@US23_TC12_DB"


//        ------------------------------------------------------
//        ------------------------------------------------------
//        tags = "@US07_TC001"
//        tags = "@US07_TC002"
//        tags = "@US07_TC003_API_firstname_verification"
//        tags = "@US07_TC004_DB_firstname_verification"
//        tags = "@US07_TC005"
//        tags = "@US07_TC006"
//        tags = "@US07_TC007_API_lastname_verification"
//        tags = "@US07_TC008_DB_lastname_verification"
//        tags = "@US07_TC009"
//        tags = "@US07_ResetUserInfoUpdates"
//--------------------------------------------------
//        tags = "@US10_TC001"
//        tags = "@US10_TC002_API_patient_verification"
//        tags = "@US10_TC003_DB_patient_verification"
//        tags = "@US10_TC004"
//        tags = "@US10_TC005_API_patient_verification_by_ssn"
//        tags = "@US10_TC006_DB_patient_verification_by_ssn"
//        tags = "@US10_TC007"
//        tags = "@US10_TC008_API_patient_update_verification_by_ssn"
//        tags = "@US10_TC009_DB_patient_update_verification_by_ssn"
//        tags = "@US10_TC010_ResetPatientUpdates
// --------------------------------------------------
//        tags = "@ApiUserRegister"




)
public class Saban_UI_TestRunner {

}
