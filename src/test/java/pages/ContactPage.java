package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactPage {
    public ContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "subject")
    public WebElement subjectInput;

    @FindBy(name = "message")
    public WebElement messageInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sendButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div[2]")
    public WebElement sentMessage;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[1]/div[1]/div/div")
    public WebElement invalidNameMessage;


}
