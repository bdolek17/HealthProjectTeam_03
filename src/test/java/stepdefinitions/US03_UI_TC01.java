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
        HomePage homePage = new HomePage();

    @Given("user is on {string} page")
    public void user_is_on_page(String health_project_url) {
        Driver.getDriver().get(ConfigReader.getProperty(health_project_url));

    }
    @When("user click on the account menu icon on home page")
    public void user_click_on_the_account_menu_icon_on_home_page() {
        homePage.account_menu.click();

    }
    @When("user clicks on Register button ")
    public void user_clicks_on_register_button() {
        homePage.linkRegister.click();

    }


    @Then("User enters a four characters random {string}")
    public void user_enters_a_four_characters_random(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);
    }
    @Then("User verifies password  chart color is filled first level bar with red color")
    public void user_verifies_password_chart_color_is_filled_first_level_bar() {
        Assert.assertTrue(RegistrationPage.passwordStrength1.isDisplayed());
        Driver.wait(2);
    }


    @Then("User enters seven characters {string} with a combination by using two of a digit, special char, upper and  lowers letter")
    public void userEntersSevenCharactersWithACombinationByUsingTwoOfADigitSpecialCharUpperAndLowersLetter(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);

    }

    @Then("User verifies password  chart color is filled first two level bars")
    public void userVerifiesPasswordChartColorIsFilledFirstTwoLevelBars() {
        Assert.assertTrue(RegistrationPage.passwordStrength2.isDisplayed());
        Driver.wait(2);
    }

    @Then("User enters seven characters {string} with a combination by using three of a digit, special char, upper and  lowers letter")
    public void userEntersSevenCharactersWithACombinationByUsingThreeOfADigitSpecialCharUpperAndLowersLetter(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);
    }
    @Then("User verifies password  chart color is filled first three level bars")
    public void userVerifiesPasswordChartColorIsFilledFirstThreeLevelBars() {
        Assert.assertTrue(RegistrationPage.passwordStrength3.isDisplayed());
        Driver.wait(2);
    }


    @Then("User enters seven characters {string} with a combination by using all of a digit, special char, upper and lowers letter")
    public void userEntersSevenCharactersWithACombinationByUsingAllOfADigitSpecialCharUpperAndLowersLetter(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);
    }

    @Then("User verifies password  chart color is filled first four level bars")
    public void userVerifiesPasswordChartColorIsFilledFirstFourLevelBars() {
        Assert.assertTrue(RegistrationPage.passwordStrength4.isDisplayed());
        Driver.wait(2);
    }


    @Then("User verifies password chart's fifth bar is still gray")
    public void userVerifiesPasswordChartSFifthBarIsStillGray() {
        Assert.assertTrue(RegistrationPage.fifthPasswordBarGray.isDisplayed());
        Driver.wait(2);
    }

    @Then("User enters more than seven characters {string} with a combination by using all of a digit, special char, upper and lowers letter")
    public void userEntersMoreThanSevenCharactersWithACombinationByUsingAllOfADigitSpecialCharUpperAndLowersLetter(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(1);
    }

    @Then("User verifies password  chart color is filled all the level bars")
    public void userVerifiesPasswordChartColorIsFilledAllTheLevelBars() {
        Assert.assertTrue(RegistrationPage.passwordStrength5.isDisplayed());
        Driver.wait(2);
    }

    @When("user enters a {string} that is less than four chars long")
    public void userEntersAThatIsNotStrongEnough(String password) {
        Driver.wait(2);
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(2);
    }

    @Then("user should see a message that password should be at least four characters long")
    public void userShouldSeeAMessageThatPasswordShouldBeAtLeastFourCharactersLong() {
        registerPage.confirmPasswordBox.click();
        Driver.wait(4);
        Assert.assertTrue(RegistrationPage.passwordErrorMessage.isDisplayed());
        Driver.wait(2);
    }

    @When("user enters a assorted {string} that is fifty characters long")
    public void userEntersAAssortedThatIsFiftyCharactersLong(String password) {
        registerPage.newPasswordBox.sendKeys(password);
        Driver.wait(2);
    }

    @Then("User asserts that password should be max {int} characters long")
    public void userAssertsThatPasswordShouldBeMaxCharactersLong(int maxCharacters) {
        Assert.assertTrue(RegistrationPage.newPasswordBoxStatic.getAttribute("maxlength").equals(String.valueOf(maxCharacters)));
        Driver.wait(2);


        }

    }

