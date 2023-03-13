package stepdefinitions.ui_stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminStaffPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;



public class US20_UI_TC001 {
    HomePage homePage= new HomePage();
    LoginPage loginPage= new LoginPage();
    AdminStaffPage adminStaff=new AdminStaffPage();

    @Given("Admin goes on {string} page")
    public void admin_goes_on_page(String string) {
        Driver.getDriver().get(string);
    }

    @Then("Admin click on sign in button on login page")
    public void admin_click_on_sign_in_button_on_login_page() {

        homePage.account_menu.click();
        homePage.linkLogin.click();

    }
    @Then("Admin enters {string} in username field")
    public void admin_enters_in_username_field(String username) {
        loginPage.inputUsername.sendKeys(username);
    }
    @Then("Admin enters {string} in password field")
    public void admin_enters_in_password_field(String password) {
        loginPage.inputPassword.sendKeys(password);
    }
    @Then("Admin clicks sign in submit button")
    public void admin_clicks_sign_in_submit_button() {
        JSUtils.clickElementByJS(loginPage.btnSignin);
    }
    @Then("clicks on {string}")
    public void clicks_on(String string) {
        adminStaff.itemTitle.click();



        /* List<WebElement> rooms = select.getOptions();
        for( WebElement each: rooms){
            if (each.getText().contains("UNAVAILABLE")){
                each.click();
                break;
         */

    }
    @Then("Admin clicks {string} from dropdown")
    public void admin_clicks_from_dropdown(String string) {
        JSUtils.clickElementByJS(adminStaff.staffText);
    }
    @Then("clicks on {string} and enter the registered {string}")
    public void clicks_on_and_enter_the_registered(String string, String string2) {

        JSUtils.clickElementByJS(adminStaff.patient);

        JSUtils.clickElementByJS(adminStaff.edit);

        JSUtils.clickElementByJS(adminStaff.SSN);
        ReusableMethods.waitFor(3);

        adminStaff.SSN.sendKeys("333-33-5332");

        JSUtils.clickElementByJS(adminStaff.useSSN);
        ReusableMethods.waitFor(3);

        JSUtils.clickElementByJS(adminStaff.button);

       adminStaff.text.isDisplayed();

       ReusableMethods.waitFor(3);

       //String verifyText= adminStaff.text.getText();
        //Assert.assertEquals(verifyText,"User found with search SSN");

//        WebDriver driver= new ChromeDriver();
//        String actualAlertText=driver.switchTo().alert().getText();
//
//        System.out.println(actualAlertText);
       // Assert.assertEquals("I am a JS Confirm",actualAlertText);

    }
    @Then("verify all information on the page")
    public void verify_all_information_on_the_page() {

        adminStaff.firstName.clear();
        adminStaff.firstName.sendKeys("Ali");

        adminStaff.lastName.clear();
        adminStaff.lastName.sendKeys("Can");

        //adminStaff.saveButton.click();
        JSUtils.clickElementByJS(adminStaff.saveButton);
        adminStaff.saveText.isDisplayed();


       // adminStaff.birthDate.clear();
       // adminStaff.birthDate.sendKeys("2023-03-03 10:10");

       // String name=adminStaff.firstName.getText();
       // Assert.assertEquals("Staff",name);

       // JSUtils.clickElementByJS(adminStaff.ID);
      // String ID= adminStaff.ID.getText();
       // Assert.assertEquals(ID,"4354");


    }
    @Then("return \"staff\"page and clicks on edit from one of the registered staff")
    public void return_staff_page_and_clicks_on_edit_from_one_of_the_registered_staff() {

        //adminStaff.saveButton.click();
        JSUtils.clickElementByJS(adminStaff.saveButton);
        adminStaff.saveText.isDisplayed();

        //adminStaff.deleteButton.click();
        //JSUtils.clickElementByJS(adminStaff.deleteButton);
    }
    @Then("Admin clicks on delete and delete the staff")
    public void admin_clicks_on_delete_and_delete_the_staff() {

        //adminStaff.deleteButton.click();
//        JSUtils.clickElementByJS(adminStaff.deleteButton);
//        WebDriver driver=new ChromeDriver();
//        driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
//       driver.switchTo().alert().accept();
    }
}
