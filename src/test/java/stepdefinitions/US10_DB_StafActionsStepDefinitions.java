package stepdefinitions;

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
        String myQuery="Select p.email,u.ssn From patient p Inner Join jhi_user u On p.user_id=u.id Where  u."+filterField+"='"+filterValue+"'";
        resultSetAsMapObject= DBUtils.getQueryResultMap(myQuery);
    }

}
