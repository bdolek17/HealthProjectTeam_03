package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;

public class US17_UI_Room {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    //Faker faker = new Faker();

    @Given("ML Admin Navigate to url {string}")
    public void adminNavigateToUrl(String url) {
        Driver.getDriver().get(url);

    }

    @Given("ML Admin Click on account icon")
    public void click_on_account_icon() {
        homePage.account_menu.click();

    }

    @Then("ML Admin Click on Sign in")
    public void click_on_sign_in() {
        homePage.linkLogin.click();

    }

    @Then("ML Admin Click on {string} input box and enter valid Username")
    public void click_on_input_box_and_enter_valid_username(String username) {
        loginPage.inputUsername.sendKeys(username);

    }

    @Then("ML Admin Click on {string}  input box and enter valid Password")
    public void click_on_input_box_and_enter_valid_password(String password) {
        loginPage.inputPassword.sendKeys(password);

    }

    @Then("ML Admin Click on Sign in button")
    public void click_on_sign_in_button() {
        loginPage.btnSignin.click();

    }

    @Then("ML Admin Click on Items&Titles")
    public void click_on_items_titles() {
        adminPage.itemTitle.click();
        ReusableMethods.waitFor(2);


    }

    @Then("ML Admin Select Room from drop down menu and click")
    public void select_room_from_drop_down_menu_and_click() {

        JSUtils.clickElementByJS(adminPage.dropDownRoom);

    }

    @Then("ML Admin Click on Create a new Room")
    public void click_on_create_a_new_room() {
        //adminPage.verifyTextAlert.isDisplayed();
        adminPage.createRoomButton.click();

    }

    @Then("ML Admin Click on Room Number box and enter room number")
    public void click_on_room_number_box_and_enter_room_number() {
        //adminPage.createOrEditRoomText.isDisplayed();
        adminPage.roomNumberBox.sendKeys("8574");

    }

    @Then("ML Admin Click on Room Type box and select room type")
    public void click_on_room_type_box_and_select_room_type() {
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForVisibility(adminPage.roomTypeBox, 10);
        Select select = new Select(adminPage.roomTypeBox);
        List<WebElement> roomType = select.getOptions();
        for (WebElement each : roomType) {
            each.click();
        }


    }

    @Then("ML Admin Click on Status")
    public void click_on_status() {

        JSUtils.clickElementByJS(adminPage.statusButton);

    }

    @Then("ML Admin Click on Price box and enter price")
    public void click_on_price_box_and_enter_price() {
        adminPage.priceBox.sendKeys("500");

    }

    @Then("ML Admin Click on Description box and enter description")
    public void click_on_description_box_and_enter_description() {
        ReusableMethods.waitFor(2);
        adminPage.descriptionBox.sendKeys("Includes Dinner");

    }

    @Then("ML Admin Click on date corresponds to the day created")
    public void click_on_date_corresponds_to_the_day_created() {
        adminPage.createdDateBox.isDisplayed();

    }

    @Then("ML Admin Click on Save")
    public void click_on_save() {
        JSUtils.clickElementByJS(adminPage.roomSaveButton);
        ReusableMethods.waitFor(3);

    }

    @Then("ML Admin Verify that  A new Room is created is visible")
    public void verify_that_a_new_room_is_created_is_visible() {
        Driver.waitForVisibility(adminPage.alertRoomIsCreated, 5);

        Assert.assertTrue(adminPage.alertRoomIsCreated.isDisplayed());


        // ReusableMethods.getElementsText((By) adminPage.alertRoomIsCreated);
        //Assert.assertTrue(adminPage.alertRoomIsCreated.isDisplayed());

        //JSUtils.generateAlert("");
        //adminPage.verifyTextAlert.isDisplayed();
        // adminPage.alertRoomIsCreated.isDisplayed();

    }

    @Then("ML Admin Click on account menu")
    public void click_on_account_menu() {
        JSUtils.clickElementByJS(adminPage.adminAccountButton);

    }

    @Then("ML Admin Click Sign out")
    public void click_sign_out() {
        JSUtils.clickElementByJS(adminPage.adminSignOutButton);

    }


}