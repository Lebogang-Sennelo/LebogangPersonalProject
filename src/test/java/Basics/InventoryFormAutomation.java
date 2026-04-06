package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InventoryFormAutomation {

WebDriver driver;

    @Test
    public void InventoryFormAutomation() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");//home page

        Thread.sleep(Duration.ofMillis(2000));
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
        Thread.sleep(Duration.ofMillis(2000));
        driver.findElement(By.id("login-email")).sendKeys("laylayT@gmail.com");//login page
        driver.findElement(By.id("login-password")).sendKeys("@12345678");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(Duration.ofMillis(5000));
        driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).isDisplayed(); //Dashboard Page

        //Click on learn //learn page
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")).click();
        Thread.sleep(2000);
        // Click on "Learning Materials" from the dropdown
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")).click();
        Thread.sleep(Duration.ofMillis(2000));
        // Click Web Automation Advance tab
        driver.findElement(By.xpath("//*[@id=\"tab-btn-web\"]")).click();
        Thread.sleep(Duration.ofMillis(2000));

        // Assert Dashboard/Inventory heading is displayed
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/h2")).isDisplayed()
        );

        // Select "Phone" from Device Type dropdown
        Select deviceType = new Select(driver.findElement(By.id("deviceType")));
        deviceType.selectByVisibleText("Phone");
        Thread.sleep(Duration.ofMillis(2000));

        // Select "Apple" from Brand dropdown
        Select brand = new Select(driver.findElement(By.xpath("//select[contains(@id,'brand') or contains(@name,'brand')]")));
        brand.selectByVisibleText("Apple");
        Thread.sleep(Duration.ofMillis(2000));
        // Device preview is displayed
        driver.findElement(By.xpath("//*[@id=\"device-preview\"]/div/img")).isDisplayed();
        Thread.sleep(1000);

        // Step 3: Select Storage - 128GB
        driver.findElement(By.xpath("//input[@value='128GB']")).click();
        Thread.sleep(Duration.ofMillis(2000));

        // Assert Unit Price R480.00 is displayed and correct
        WebElement unitPrice = driver.findElement(By.xpath("//*[@id=\"unit-price-label\"]"));
        Assert.assertTrue(unitPrice.isDisplayed());
        Assert.assertTrue(unitPrice.getText().contains("R480.00"));
        Thread.sleep(Duration.ofMillis(2000));

        // Step 4: Select Color - Blue
        Select color = new Select(driver.findElement(By.id("color")));
        color.selectByVisibleText("Blue");
        Thread.sleep(Duration.ofMillis(2000));

// Step 5: Enter Quantity - 2
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("2");
        Thread.sleep(Duration.ofMillis(2000));

// Assert Subtotal R960.00 is displayed
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[@id=\"subtotal-label\"]")).getText().contains("960")
        );
        Thread.sleep(Duration.ofMillis(2000));

// Step 6: Enter Delivery Address
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement addressField = driver.findElement(By.xpath("//input[@placeholder='Enter address']"));
        js.executeScript("arguments[0].click();", addressField);
        addressField.clear();
        addressField.sendKeys("123 Test Street");
        Thread.sleep(Duration.ofMillis(2000));

// Step 7: Click Next → Order Preview displayed
        driver.findElement(By.xpath("//*[@id=\"inventory-next-btn\"]")).click();
        Thread.sleep(Duration.ofMillis(2000));

        //step 8:Select shipping method
        driver.findElement(By.xpath("//*[@id=\"shipping-label\"]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"shipping-option-express\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"breakdown-shipping-value\"]")).isDisplayed();
        Thread.sleep(2000);

//step 8:Select shipping method
       driver.findElement(By.xpath("//*[@id=\"warranty-label\"]")).isDisplayed();
       driver.findElement(By.xpath("//*[@id=\"warranty-option-1yr\"]")).click();
       driver.findElement(By.xpath("//*[@id=\"breakdown-warranty-value\"]")).isDisplayed();
       Thread.sleep(2000);

// Step 9: Apply Discount Code SAVE10
        driver.findElement(By.xpath("//*[@id=\"discount-code\"]")).sendKeys("SAVE10");
        Thread.sleep(Duration.ofMillis(1000));
        driver.findElement(By.id("apply-discount-btn")).click();
        Thread.sleep(Duration.ofMillis(2000));
        driver.findElement(By.xpath("//*[@id=\"discount-feedback\"]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"breakdown-discount-value\"]")).isDisplayed();
        Thread.sleep(2000);

//Confirm Purchase
        driver.findElement(By.id("purchase-device-btn")).click();
        Thread.sleep(Duration.ofMillis(3000));

//Order Successfull
        driver.findElement(By.xpath("//*[@id=\"purchase-success-toast\"]/div[1]/h4")).isDisplayed();
        Thread.sleep(2000);

 //Click view invoice
        driver.findElement(By.id("view-history-btn")).click();
        Thread.sleep(2000);
 //Invoice History is displayed
        driver.findElement(By.xpath("//*[@id=\"invoice-history-title\"]")).isDisplayed();
        Thread.sleep(2000);

// Click View Invoice - using contains to handle dynamic ID
        driver.findElement(By.xpath("//*[contains(@id,'view-invoice')]")).click();
        Thread.sleep(Duration.ofMillis(2000));

// Assert Invoice panel is displayed
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[contains(@id,'view-invoice')]")).isDisplayed()
        );
        Thread.sleep(Duration.ofMillis(2000));

// Assert Invoice details are displayed
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[contains(text(),'Invoice')]")).isDisplayed()
        );
        Thread.sleep(Duration.ofMillis(2000));

        driver.quit();


    }


}


