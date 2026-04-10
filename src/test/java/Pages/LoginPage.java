package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"login-heading\"]/span")
    WebElement verifyLoginHeading;

    @FindBy(id = "login-email")
    WebElement emailField;

    @FindBy(id= "login-password")
    WebElement passwordField;

    @FindBy(id = "login-submit")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyLoginPageIsDisplayed() {
        verifyLoginHeading.isDisplayed();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        submitButton.click();

        // ✅ Wait for URL to change away from login page after submission
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard")); // adjust if your URL is different
    }
}
