package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminAllPatientsListPage {
    public AdminAllPatientsListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@id='patient-heading']/span")   //S.A.
    public WebElement lblPageHeading;

    @FindBy(id = "jh-create-entity")   //S.A.
    public WebElement btnCreateNewPatient;

    @FindBy(xpath = "//*[@id='app-view-container']//span")   //S.A.
    public WebElement spanUnauthorizedMessage;


}
