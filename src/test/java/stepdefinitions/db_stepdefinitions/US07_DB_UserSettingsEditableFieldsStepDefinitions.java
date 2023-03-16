package stepdefinitions.db_stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class US07_DB_UserSettingsEditableFieldsStepDefinitions {

    //List<Map<String,Object>> resultSetAsMapObject;

    @Given("connect to medunna database")
    public void connect_to_medunna_database() {
        DBUtils.createConnection();
    }

    @Given("get all records from {string} with the {string} columns where {string} column has {string} value")
    public void get_all_records_from_with_the_columns_where_column_has_value(String table, String columns, String filterField, String filterValue) {
        String myQuery="Select "+columns+" From "+table+" Where "+filterField+"='"+filterValue+"'";

        //List<Object> valueFirstRowAsListObject=DBUtils.getRowList(myQuery);
        //System.out.println("---DBUtils.getRowList(myQuery)---");
        //System.out.println(valueFirstRowAsListObject);

        //Map<String,Object> firstRowValueAsMapObject=DBUtils.getRowMap(myQuery);
        //System.out.println("---DBUtils.getRowMap(myQuery)---");
        //System.out.println(firstRowValueAsMapObject);

        //List<List<Object>> rowList=DBUtils.getQueryResultList(myQuery);
        //System.out.println("---DBUtils.getQueryResultList(myQuery)---");
        //System.out.println(rowList);

        //resultSetAsMapObject=DBUtils.getQueryResultMap(myQuery);
        SharedDataForDb.sharedResultSetAsMapObject=DBUtils.getQueryResultMap(myQuery);;

        //System.out.println("---DBUtils.getQueryResultMap(myQuery)---");
        //System.out.println(resultSetAsMapObject);
    }
    @Given("verify resultset {string} column contains {string} data")
    public void verify_resultset_column_contains_data(String queryFiledName, String expectedValue) {
        if(SharedDataForDb.sharedResultSetAsMapObject.size()==0){
            Assert.fail("Assertion Failed");
        }else {
            String actualValue=SharedDataForDb.sharedResultSetAsMapObject.get(0).get(queryFiledName).toString();
            Assert.assertEquals(expectedValue,actualValue);
        }
    }
    @Then("close the database connection")
    public void close_the_database_connection() {
        DBUtils.closeConnection();
    }

}
