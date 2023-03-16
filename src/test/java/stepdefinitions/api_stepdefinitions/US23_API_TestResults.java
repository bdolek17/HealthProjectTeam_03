package stepdefinitions.api_stepdefinitions;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static utilities.ApiUtilities.responseMedunna;
import static utilities.ApiUtilities.specMedunna;

public class US23_API_TestResults {
    @Then("user verifies that status code is {int} and test results item informations have {string} {string} values")
    public void user_verifies_that_status_code_is_and_test_results_item_informations_have_values(Integer statusCode, String result, String description) {
        JsonPath json=responseMedunna.jsonPath();
        Assert.assertEquals((int)statusCode,responseMedunna.statusCode());
        Assert.assertEquals(result,json.getString("result"));
        Assert.assertEquals(description,json.getString("description"));
    }

    @Then("user verifies that status code is {int} and test results item informations have {string} {string} values for test result date")
    public void user_verifies_that_status_code_is_and_test_results_item_informations_have_values_for_test_result_date(Integer statusCode, String datePart, String timePart) {
        JsonPath json=responseMedunna.jsonPath();
        Assert.assertEquals((int)statusCode,responseMedunna.statusCode());
        Assert.assertTrue(json.getString("date").contains(datePart));
        Assert.assertTrue(json.getString("date").contains(timePart));
    }
}
