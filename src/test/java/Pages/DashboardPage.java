package Pages;


import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;

    @FindBy(xpath= "//*[@id=\"app-main-content\"]/section/div[1]/h2")
    WebElement verifyDashboardHeading;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")
    WebElement learnButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement learningMaterialButton;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyDashboardPageIsDisplayed() {
        verifyDashboardHeading.isDisplayed();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // ✅ Wait for element using By locator, not the proxy WebElement
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("practice-heading")));
    }

    public void clickLearnButton() {
        learnButton.click();
    }

    public void clickLearningMaterialButton() {
        learningMaterialButton.click();
    }

}



