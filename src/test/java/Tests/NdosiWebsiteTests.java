package Tests;

import Utils.ReadFromFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NdosiWebsiteTests extends Base {

    @Test
    public void verifyHomePageIsDisplayed() {
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayed")
    public void clickLoginButton() {
        homePage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginButton")
    public void userEnterEmail() {
        loginPage.enterEmail(ReadFromFile.email);
    }

    @Test(dependsOnMethods = "userEnterEmail")
    public void userEnterPassword() {
        loginPage.enterPassword(ReadFromFile.password);
    }

    @Test(dependsOnMethods = "userEnterPassword")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "userClickLoginButton")
    public void verifyDashboardPageIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        dashBoardPage.verifyDashboardPageIsDisplayed();
    }

    @Test (dependsOnMethods = "verifyDashboardPageIsDisplayed")
    public void clickLearnButton() throws InterruptedException {
        Thread.sleep(2000);
        dashBoardPage.clickLearnButton();
    }

    @Test(dependsOnMethods = "clickLearnButton")
    public void clickLearningMaterialButton() throws InterruptedException {
        Thread.sleep(2000);
        dashBoardPage.clickLearningMaterialButton();
    }

    @Test (dependsOnMethods = "clickLearningMaterialButton")
    public void webAutomationTab() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.clickWebAutomationAdvanceTab();
    }

    @Test (dependsOnMethods = "webAutomationTab")
    public void verifyInventoryHeadingIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyInventoryHeadingIsDisplayed();
    }

    @Test (dependsOnMethods = "verifyInventoryHeadingIsDisplayed")
    public void selectDeviceType() throws InterruptedException {
            Thread.sleep(2000);
     inventoryFormPage.selectDeviceType("Phone");}

    @Test (dependsOnMethods = "selectDeviceType")
    public void selectBrand() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.selectBrand("Apple");
    }
    @Test (dependsOnMethods = "selectBrand")
    public void verifyDevicePreviewIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyDevicePreviewImageIsDisplayed();
    }
    @Test (dependsOnMethods = "verifyDevicePreviewIsDisplayed")
    public void selectStorage() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.selectStorageOption("128GB");
    }
    @Test (dependsOnMethods = "selectStorage")
    public void verifyUnitPriceIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyUnitPriceIsDisplayed();
    }
    @Test (dependsOnMethods = "verifyUnitPriceIsDisplayed")
    public void selectColor() throws InterruptedException {
        inventoryFormPage.selectColor("Blue");
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "selectColor")
    public void selectQuantity() throws InterruptedException {
        inventoryFormPage.selectQuantity(2);
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "selectQuantity")
    public void verifySubtotalIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifySubtotalIsDisplayed();
    }
    @Test (dependsOnMethods = "verifySubtotalIsDisplayed")
    public void enterDeliveryAddress() throws InterruptedException {
        inventoryFormPage.enterDeliveryAddress("123 Test Street");
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "enterDeliveryAddress")
    public void clickNextButton() throws InterruptedException {
        inventoryFormPage.clickNextButton();
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "clickNextButton")
    public void verifyShippingSectionIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyShippingSectionIsDisplayed();
    }
    @Test (dependsOnMethods = "verifyShippingSectionIsDisplayed")
    public void selectExpressShipping() throws InterruptedException {
        inventoryFormPage.selectExpressShipping();
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "selectExpressShipping")
    public void verifyShippingBreakdownValueIsDisplayed() throws InterruptedException {
        inventoryFormPage.verifyShippingBreakdownValueIsDisplayed();
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "verifyShippingBreakdownValueIsDisplayed")
    public void verifyWarrantySectionIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyWarrantySectionIsDisplayed();
    }
    @Test (dependsOnMethods = "verifyWarrantySectionIsDisplayed")
    public void selectOneYearWarranty() throws InterruptedException {
        inventoryFormPage.selectOneYearWarranty();
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "selectOneYearWarranty")
    public void verifyWarrantyBreakdownValueIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyWarrantyBreakdownValueIsDisplayed();
    }
    @Test (dependsOnMethods = "verifyWarrantyBreakdownValueIsDisplayed")
    public void enterDiscountCode() throws InterruptedException {
        inventoryFormPage.enterDiscountCode("SAVE10");
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "enterDiscountCode")
    public void applyDiscountCode() throws InterruptedException {
        inventoryFormPage.clickApplyDiscount();
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "applyDiscountCode")
    public void verifyDiscountFeedbackIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyDiscountFeedbackIsDisplayed();
    }
    @Test (dependsOnMethods = "verifyDiscountFeedbackIsDisplayed")
    public void verifyDiscountBreakdownValueIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyDiscountBreakdownValueIsDisplayed();
    }
    @Test (dependsOnMethods = "verifyDiscountBreakdownValueIsDisplayed")
    public void clickPurchaseDevice() throws InterruptedException {
        inventoryFormPage.clickPurchaseDevice();
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "clickPurchaseDevice")
    public void verifyPurchaseSuccessToastIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyPurchaseSuccessToastIsDisplayed();
    }
    @Test (dependsOnMethods = "verifyPurchaseSuccessToastIsDisplayed")
    public void clickViewHistory() throws InterruptedException {
        inventoryFormPage.clickViewHistory();
        Thread.sleep(2000);
    }
    @Test (dependsOnMethods = "clickViewHistory")
    public void verifyInvoiceHistoryTitleIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        inventoryFormPage.verifyInvoiceHistoryTitleIsDisplayed();
    }
    @Test  (dependsOnMethods = "verifyInvoiceHistoryTitleIsDisplayed")
    public void clickViewInvoice() throws InterruptedException {
        inventoryFormPage.clickViewInvoice();
        Thread.sleep(2000);
    }
    @Test  (dependsOnMethods = "clickViewInvoice")
    public void verifyInvoiceDetailsLabelIsDisplayed() throws InterruptedException {
        inventoryFormPage.verifyInvoiceDetailsLabelIsDisplayed();
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}






