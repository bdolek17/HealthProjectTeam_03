package stepdefinitions.ui_stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;
import pages.TestItemsPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US18_UI_testItem {
   HomePage homePage=new HomePage();
   LoginPage loginPage= new LoginPage();
   TestItemsPage testItemsPage=new TestItemsPage();
   Faker faker=new Faker();
    @Given("Admin goes on {string} page..")
    public void admin_goes_on_page(String string) {
        Driver.getDriver().get(string);

    }
    @Then("Admin click on sign in button on login page..")
    public void admin_click_on_sign_in_button_on_login_page() {
     homePage.account_menu.click();
     homePage.linkLogin.click();
     ReusableMethods.waitFor(2);

    }
    @Then("Admin enters {string} ..")
    public void admin_enters(String string) {
     loginPage.inputUsername.sendKeys(string);

    }
    @And("Admin enters {string} .")
    public void adminEnters(String arg0) {
     loginPage.inputPassword.sendKeys(arg0);
    }
    @Then("Admin clicks sign in submit button..")
    public void admin_clicks_sign_in_submit_button() {
     loginPage.btnSignin.click();

    }
    @Then("clicks on {string} ..")
    public void clicks_on(String string) {
     homePage.adminMenuItemsAndTitles.click();
     ReusableMethods.waitFor(2);

    }
    @Then("Admin clicks {string} from dropdown..")
    public void admin_clicks_from_dropdown(String string) {
    // WebElement ddm=homePage.adminMenuCTestItem;
    // Select options= new Select(ddm);
     //options.selectByVisibleText("Test Item");
     homePage.adminMenuCTestItem.click();

    }
    @Then("Admin clicks create a new test item button..")
    public void admin_clicks_create_a_new_test_item_button() {
     testItemsPage.createTestItem.click();

    }
    @And("Admin enters his-her name")
    public void adminEntersHisHerName() {
     testItemsPage.inputName.sendKeys(faker.name().fullName());

    }

    @Then("Admin enters description")
    public void admin_enters_description() {
     testItemsPage.inputdescription.sendKeys("disease definition");

    }
    @Then("Admin enters price")
    public void admin_enters_price() {
     testItemsPage.inputPrice.sendKeys("100");

    }
    @Then("Admin enters default min value")
    public void admin_enters_default_min_value() {
     testItemsPage.inputdefaultValMin.sendKeys("55");

    }
    @Then("Admin enters default max value")
    public void admin_enters_default_max_value() {
     testItemsPage.inputdefaultValMax.sendKeys(faker.numerify("200"));
     ReusableMethods.waitFor(2);

    }
    @Then("Admin clicks save button")
    public void admin_clicks_save_button() {
    // testItemsPage.saveButton.click();
     JSUtils.clickElementByJS(testItemsPage.saveButton);
     ReusableMethods.waitFor(1);

    }
    @And("Admin should see created message")
    public void adminShouldSeeCreatedMessage() {
     testItemsPage.createdMessage.isDisplayed();
    }
    @Then("Admin clicks view button")
    public void admin_clicks_view_button() {
     testItemsPage.viewButton.click();
     ReusableMethods.waitFor(2);

    }
    @Then("Admin should see view page")
    public void admin_should_see_view_page() {
     testItemsPage.viewNewTestItem.isDisplayed();

    }
    @Then("Admin clicks edit button")
    public void admin_clicks_edit_button() {
     testItemsPage.editButton.click();

    }
    @Then("Admin should see create or edit test item")
    public void admin_should_see_create_or_edit_test_item() {
     testItemsPage.createOrEditMessage.isDisplayed();

    }
    @And("Admin edits description")
    public void adminEditsDescription() {
     testItemsPage.inputdescription.clear();
     testItemsPage.inputdescription.sendKeys("diabetes");
     ReusableMethods.waitFor(2);
    }
     @Then("Admin clicks save button..")
     public void admin_clicks_saved_button () {
      //testItemsPage.editSave.click();
      JSUtils.clickElementByJS(testItemsPage.editSave);
      ReusableMethods.waitFor(2);
     }

    @Then("Admin clicks delete button")
    public void admin_clicks_delete_button() {
    // testItemsPage.deleteButton1.click();
     JSUtils.clickElementByJS(testItemsPage.deleteButton1);
     ReusableMethods.waitFor(1);

    }
    @Then("Admin  clicks delete button again on the small box")
    public void admin_clicks_delete_button_again_on_the_small_box() {
    // testItemsPage.deleteButton2.click();
     JSUtils.clickElementByJS(testItemsPage.deleteButton2);

    }
    @Then("Admin shouldn't see data on this page")
    public void admin_shouldn_t_see_data_on_this_page() {
     testItemsPage.deleteMessage.isDisplayed();

    }



}
