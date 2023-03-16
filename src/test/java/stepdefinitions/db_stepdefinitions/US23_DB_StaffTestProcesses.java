package stepdefinitions.db_stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class US23_DB_StaffTestProcesses {
    @Given("verify resultset {string} column contains {string} and {string} data")
    public void verify_resultset_column_contains_and_data(String date, String resultDate, String resultTime) {

        if(SharedDataForDb.sharedResultSetAsMapObject.size()==0){
            Assert.fail("Assertion Failed:No record");
        }else {
            String actualValue=SharedDataForDb.sharedResultSetAsMapObject.get(0).get(date).toString();
            Assert.assertEquals(resultDate,actualValue.substring(0,10));
            Assert.assertEquals(resultTime,actualValue.substring(11,16));
            //Assert.assertTrue(actualValue.contains(resultDate) && actualValue.contains(resultTime));
        }


    }
}
