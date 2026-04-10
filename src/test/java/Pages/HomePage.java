package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    //verify that the home page is displayed
    @FindBy(id="overview-hero")
    WebElement verify_homePage;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public void verifyHomePageIsDisplayed() {
        verify_homePage.isDisplayed();
    }
}
