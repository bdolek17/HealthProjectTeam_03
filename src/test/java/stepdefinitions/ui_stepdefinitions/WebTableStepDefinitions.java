package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AdminAllPatientsListPage;
import utilities.Driver;

import utilities.JSUtils;
import utilities.PatientWebTable;
import utilities.WebTableReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebTableStepDefinitions {

    AdminAllPatientsListPage patientList=new AdminAllPatientsListPage();
    @Then("user reads web table")
    public void user_reads_web_table() {
        By locatorTableHeader=By.xpath("//table//thead//tr");
        By locatorTableBody=By.xpath("//table//tbody//tr");


        PatientWebTable patientWebTableData=new PatientWebTable(locatorTableHeader,locatorTableBody);

        if(!patientList.pageFirstLinkItem.getAttribute("class").contains("disabled")) {
            JSUtils.clickElementByJS(patientList.pageFirst);
            Driver.waitForPageToLoad(10);
        }
        System.out.println(patientList.pageLastLinkItem.getAttribute("class"));
        Boolean readPages=true;

        while(readPages){
            patientWebTableData.loadCurrentPage(Driver.getDriver().findElements(locatorTableBody));
            Driver.wait(1);
            readPages=!patientList.pageLastLinkItem.getAttribute("class").contains("disabled");
            if(readPages){
                JSUtils.clickElementByJS(patientList.pageNext);
                Driver.wait(2);
            }

        }

        Map<String, Map<String,WebElement>> patientData=patientWebTableData.getWebTableData();
        System.out.println(patientData);


    }
}
