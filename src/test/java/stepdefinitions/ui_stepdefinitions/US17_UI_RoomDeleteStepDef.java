package stepdefinitions.ui_stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US17_UI_RoomDeleteStepDef {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    //Faker faker = new Faker();


    //Scenario: TC_02_The admin should view all rooms, update existing rooms and delete rooms
    @Given("ML Admin Navigate to url {string} page")
    public void ml_admin_navigate_to_url_page(String url) {
        Driver.getDriver().get(url);

    }
    @And("ML Admin Click on account icon page")
    public void mlAdminClickOnAccountIconPage() {
        homePage.account_menu.click();

    }

    @Then("ML Admin Click on Sign in page")
    public void mlAdminClickOnSignInPage() {
        homePage.linkLogin.click();

    }

    @And("ML Admin Click on {string} input box and enter valid Username page")
    public void mlAdminClickOnInputBoxAndEnterValidUsernamePage(String username) {
        loginPage.inputUsername.sendKeys(username);

    }

    @And("ML Admin Click on {string}  input box and enter valid Password page")
    public void mlAdminClickOnInputBoxAndEnterValidPasswordPage(String password) {
        loginPage.inputPassword.sendKeys(password);

    }

    @And("ML Admin Click on Sign in button page")
    public void mlAdminClickOnSignInButtonPage() {
        loginPage.btnSignin.click();

    }

    @And("ML Admin Click on Items&Titles page")
    public void mlAdminClickOnItemsTitlesPage() {
        adminPage.itemTitle.click();
        ReusableMethods.waitFor(2);

    }

    @And("ML Admin Select Room from drop down menu and click page")
    public void mlAdminSelectRoomFromDropDownMenuAndClickPage() {
        JSUtils.clickElementByJS(adminPage.dropDownRoom);
    }


    @Given("Admin Click on Edit and update rooms")
    public void admin_click_on_edit_and_update_rooms() {
        Driver.waitAndClick(adminPage.viewButton);
        Driver.waitForVisibility(adminPage.visibleRoomInfo, 5);
        Assert.assertTrue(adminPage.visibleRoomInfo.isDisplayed());
        Driver.waitAndClick(adminPage.editButton);

    }

    @Given("Admin Click on Room Number box, delete information and enter room number")
    public void admin_click_on_room_number_box_delete_information_and_enter_room_number() {
        Driver.wait(1);
        adminPage.roomNumberBox.clear();
        Driver.wait(1);
        adminPage.roomNumberBox.sendKeys("200499");


    }

    @Given("Admin Click on Room Type box and change room type")
    public void admin_click_on_room_type_box_and_change_room_type() {
        Select select = new Select((adminPage.roomTypeBox));
        select.selectByValue("SUITE");

    }

    @Given("Admin Click on Status")
    public void admin_click_on_status() {
        JSUtils.clickElementByJS(adminPage.statusButton);

    }

    @Given("Admin Click on Price box, delete information and enter price")
    public void admin_click_on_price_box_delete_information_and_enter_price() {
        Driver.wait(1);
        adminPage.priceBox.clear();
        Driver.wait(1);
        adminPage.priceBox.sendKeys("500");


    }

    @Given("Admin Click on Description box,delete information and enter description")
    public void admin_click_on_description_box_delete_information_and_enter_description() {
        Driver.wait(1);
        adminPage.descriptionBox.clear();
        Driver.wait(1);
        adminPage.descriptionBox.sendKeys("Room with extra service");

    }

    @Given("Admin Click on Save button")
    public void admin_click_on_save_button() {
        JSUtils.clickElementByJS(adminPage.adminAccountButton);

    }

    @Given("Admin Verify that updated successfully")
    public void admin_verify_that_updated_successfully() {
        Driver.waitForVisibility(adminPage.alertRoomIsUpdate, 5);
        Assert.assertTrue(adminPage.alertRoomIsUpdate.isDisplayed());

    }
    @And("Admin Click on Delete")
    public void adminClickOnDelete() {
        JSUtils.clickElementByJS(adminPage.deleteButton);
    }
    @And("Admin Click on Delete in alert window")
    public void adminClickOnDeleteInAlertWindow() {
        Driver.waitForVisibility(adminPage.deleteQuestionAlert, 5);
        JSUtils.clickElementByJS(adminPage.deletButtonAlertRoom);
    }
    @And("Admin Verify that deleted successfully")
    public void adminVerifyThatDeletedSuccessfully() {
        Driver.waitForVisibility(adminPage.alertDeleteRoom, 5);
        Assert.assertTrue(adminPage.alertDeleteRoom.isDisplayed());

    }

    @Given("Admin Click on account menu")
    public void admin_click_on_account_menu() {
        JSUtils.clickElementByJS(adminPage.adminAccountButton);

    }

    @Then("Admin Click Sign out")
    public void admin_click_sign_out() {
        JSUtils.clickElementByJS(adminPage.adminSignOutButton);



    }

}


