package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.Driver;

public class US09_UI {

    LoginPage loginPage = new LoginPage();

    @Given("user goes {string} home page")
    public void user_goes_page(String string){
        Driver.getDriver().get(string);
    }
    @When("user click on the account menu icon page")
    public void user_click_on_the_account_menu_icon_home_page(){


    }



}
