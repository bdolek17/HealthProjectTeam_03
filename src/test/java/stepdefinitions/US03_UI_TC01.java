package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US03_UI_TC01 {

    RegistrationPage registerPage = new RegistrationPage();

    @Given("user goes on {string} home page")
    public void user_goes_on_page(String string) {
        Driver.getDriver().get(string);

    }
    @When("user click on the account menu icon on page")
    public void user_click_on_the_account_menu_icon_on_home_page() {
        registerPage.account_menu.click();

    }
    @When("user click on the register link on registration page")
    public void user_click_on_the_sign_in_link_on_login_page() {
        registerPage.linkRegister.click();

    }
    @Then("User enters a four characters random {string}")
    public void user_enters_a_four_characters_random(String password) {
        registerPage.newPasswordBox.sendKeys(password);
            Driver.wait(1);

    }
    @Then("User enters seven characters {string} with a combination by using two of a digit, special char, upper and  lowers letter")
    public void userEntersSevenCharactersWithACombinationByUsingTwoOfADigitSpecialCharUpperAndLowersLetter(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);

    }

    @Then("User enters seven characters {string} with a combination by using three of a digit, special char, upper and  lowers letter")
    public void userEntersSevenCharactersWithACombinationByUsingThreeOfADigitSpecialCharUpperAndLowersLetter(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);
    }

    @Then("User enters seven characters {string} with a combination by using all of a digit, special char, upper and lowers letter")
    public void userEntersSevenCharactersWithACombinationByUsingAllOfADigitSpecialCharUpperAndLowersLetter(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);
    }

    @Then("User enters more than seven characters {string} with a combination by using all of a digit, special char, upper and lowers letter")
    public void userEntersMoreThanSevenCharactersWithACombinationByUsingAllOfADigitSpecialCharUpperAndLowersLetter(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);
    }

    @Then("user enters a {string} that is less than four chars long")
    public void userEntersAThatIsNotStrongEnough(String password) {
        Driver.wait(2);
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(2);
    }


    @Then("user enters a assorted {string} that is fifty characters long")
    public void userEntersAAssortedThatIsFiftyCharactersLong(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(2);


    }





}



