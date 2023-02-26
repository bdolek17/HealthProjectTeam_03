package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PatientsPage {
    public PatientsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='MY PAGES(PATIENT)']")
    public WebElement myPages;

    @FindBy(xpath = "//span[.='Make an Appointment']")
    public WebElement makeApp;

    @FindBy(xpath = "//input[@name='ssn']")  //S.A.
    public WebElement inputSearchBySsn;

    @FindBy(xpath = "//table/tbody/tr") //S.A.
    public List<WebElement> patientList;

    @FindBy(xpath = "//span[.='No Patients found']") //S.A.
    public WebElement noPatientFoundMessage;


}


