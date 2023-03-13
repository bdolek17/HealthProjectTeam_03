package stepdefinitions.db_stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.LogUtilities;

import java.util.List;
import java.util.Map;

public class US16_DB_PatientCreationProcesses {
    @Given("get record from {string} with the {string} columns where {string} column has created id value")
    public void get_record_from_with_the_columns_where_column_has_created_id_value(String table, String columns, String filterField) {
        String patientID= LogUtilities.getAllCreatedPatientIds().get(0);
        String myQuery="Select "+columns+" From "+table+" Where "+filterField+"="+patientID;  //id is  number
        DB_CommonDefinitions.resultSetAsMapObject = DBUtils.getQueryResultMap(myQuery);
    }

    @Then("verify resultset fallowing values")
    public void verify_resultset_fallowing_values(DataTable dataTable) {
        List<Map<String,String>> data=dataTable.asMaps(String.class, String.class);

        Map<String,String> expectedData=data.get(0);

        List<Map<String,Object>> resultSet=DB_CommonDefinitions.resultSetAsMapObject;
        if(resultSet.size()==0){
            Assert.fail("Assertion Failed");
        }else {
            Map<String,Object> actualData=resultSet.get(0);
            Assert.assertEquals(expectedData.get("firstname"),actualData.get("first_name"));
            Assert.assertEquals(expectedData.get("lastname"),actualData.get("last_name"));
            Assert.assertEquals(expectedData.get("email"),actualData.get("email"));
            Assert.assertEquals(expectedData.get("phone"),actualData.get("phone"));
            Assert.assertEquals(expectedData.get("gender"),actualData.get("gender"));
        }
    }

    @Given("get record from {string} with the {string} columns where {string} column has {int} id value")
    public void get_record_from_with_the_columns_where_column_has_id_value(String table, String columns, String filterField, Integer filterFieldValue) {
        String deletedPatientId=LogUtilities.getFirstCreatedPatientId();  //get it from text file
        if(deletedPatientId.length()==0) {deletedPatientId=filterFieldValue.toString();}

        String myQuery="Select "+columns+" From "+table+" Where "+filterField+"="+deletedPatientId;
        DB_CommonDefinitions.resultSetAsMapObject = DBUtils.getQueryResultMap(myQuery);
    }
    @Then("verify resultset is empty")
    public void verify_resultset_is_empty() {
        Assert.assertEquals(0,DB_CommonDefinitions.resultSetAsMapObject.size());
    }
}
