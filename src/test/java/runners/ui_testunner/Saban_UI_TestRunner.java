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
        //tags = "@US16_TC01"
        //tags = "@US16_TC02"
        //tags = "@US16_PatientCreationAutherization"
        //tags = "@DeleteCreatedPatients"
        tags = "@US23_TC06_DB"

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
