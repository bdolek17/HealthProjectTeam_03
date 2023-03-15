package stepdefinitions.db_stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US17_DB_RoomStepDef {


    @Given("ML given connects to database")
    public void ml_given_connects_to_database() {
        DBUtils.createConnection();

    }
    @When("ML get all {string} as a list from {string} table")
    public void ml_get_all_as_a_list_from_table(String column, String table) {
/*
        List<Object> columnList;
        String query = "SELECT * FROM" + table;
        columnList = DBUtils.getColumnData(query, column);
        System.out.println("columnList = " +columnList);

 */

       String dynamicQuery = "Select " + column + " from " + table;
        DBUtils.executeQuery(dynamicQuery);



    }
    @Then("ML verify {string} table {string} column contains {int}")
    public void mlVerifyTableColumnContains(String table, String column, int data) {

        List<Object> allColumnData = DBUtils.getColumnData("Select * from " + table, column);
        System.out.println(allColumnData);

        List<Object> expectedData = new ArrayList<>();
        expectedData.add(data);

        Assert.assertTrue(allColumnData.containsAll(expectedData));




    }
    @Then("ML close the connection")
    public void ml_close_the_connection() {
        DBUtils.closeConnection();

    }



}
