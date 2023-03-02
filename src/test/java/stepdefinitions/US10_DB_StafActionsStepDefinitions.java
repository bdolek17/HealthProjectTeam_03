package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;


public class US10_DB_StafActionsStepDefinitions {
    List<Map<String,Object>> resultSetAsMapObject;
    @Given("get record from {string} with the {string} columns where {string} column has {string} value")
    public void get_record_from_with_the_columns_where_column_has_value(String table, String columns, String filterField, String filterValue) {
        String myQuery="Select "+columns+" From "+table+" Where "+filterField+"="+filterValue;  //id is  number
        resultSetAsMapObject= DBUtils.getQueryResultMap(myQuery);
    }
    @Then("verify resultset {string} column has {string} value")
    public void verify_resultset_column_has_value(String validateField, String expectedValue ) {
        if(resultSetAsMapObject.size()==0){
            Assert.fail("Assertion Failed");
        }else {
            String actualValue=resultSetAsMapObject.get(0).get(validateField).toString();
            Assert.assertEquals(expectedValue,actualValue);
        }
    }

    @Given("get patient record from database where {string} column has {string} value")
    public void get_patient_record_from_database_where_column_has_value(String filterField, String filterValue) {
        String myQuery="Select p.*,u.ssn From patient p Inner Join jhi_user u On p.user_id=u.id Where  u."+filterField+"='"+filterValue+"'";
        resultSetAsMapObject= DBUtils.getQueryResultMap(myQuery);
    }

    @Then("verify resultset has following values")
    public void verify_resultset_has_following_values(DataTable dataTable) {
        Map<String,String> expectedData=dataTable.asMap(String.class,String.class);
        Map<String,Object> actualData=resultSetAsMapObject.get(0);

        Assert.assertEquals(expectedData.get("id"),actualData.get("id").toString());
        Assert.assertEquals(expectedData.get("firstName"),actualData.get("first_name"));
        Assert.assertEquals(expectedData.get("lastName"),actualData.get("last_name"));
        Assert.assertEquals(expectedData.get("phone"),actualData.get("phone"));
        Assert.assertEquals(expectedData.get("ssn"),actualData.get("ssn"));
        Assert.assertEquals(expectedData.get("gender"),actualData.get("gender"));
        Assert.assertEquals(expectedData.get("email"),actualData.get("email"));
        Assert.assertEquals(expectedData.get("bloodGroup"),actualData.get("blood_group"));
        Assert.assertEquals(expectedData.get("birthDate"),actualData.get("birth_date"));
        Assert.assertEquals(expectedData.get("country"),actualData.get("country_id"));
        Assert.assertEquals(expectedData.get("description"),actualData.get("description"));
        Assert.assertEquals(expectedData.get("state_city"),actualData.get("cstate_id"));
        Assert.assertEquals(expectedData.get("adress"),actualData.get("adress"));

    }


}
