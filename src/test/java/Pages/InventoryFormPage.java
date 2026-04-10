package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryFormPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public InventoryFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Web Automation Advance tab
    @FindBy(xpath = "//*[@id='tab-btn-web']")
    WebElement webAutomationAdvanceTab;

    // Inventory heading
    @FindBy(xpath = "//*[@id='app-main-content']/section/div[1]/h2")
    WebElement inventoryHeading;

    // Device Type dropdown
    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    // Brand dropdown
    @FindBy(xpath = "//select[contains(@id,'brand') or contains(@name,'brand')]")
    WebElement brandDropdown;

    // Device preview image
    @FindBy(xpath = "//*[@id='device-preview']/div/img")
    WebElement devicePreviewImage;

    // Storage option
    @FindBy(xpath = "//input[@value='128GB']")
    WebElement storage128GBOption;

    // Unit price
    @FindBy(id = "unit-price-label")
    WebElement unitPriceLabel;

    // Color dropdown
    @FindBy(id = "color")
    WebElement colorDropdown;

    // Quantity field
    @FindBy(id = "quantity")
    WebElement quantityField;

    // Subtotal
    @FindBy(id = "subtotal-label")
    WebElement subtotalLabel;

    // Delivery address
    @FindBy(xpath = "//input[@placeholder='Enter address']")
    WebElement addressField;

    // Next button
    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    // Shipping section
    @FindBy(id = "shipping-label")
    WebElement shippingLabel;

    @FindBy(id = "shipping-option-express")
    WebElement expressShippingOption;

    @FindBy(id = "breakdown-shipping-value")
    WebElement shippingBreakdownValue;

    // Warranty section
    @FindBy(id = "warranty-label")
    WebElement warrantyLabel;

    @FindBy(id = "warranty-option-1yr")
    WebElement oneYearWarrantyOption;

    @FindBy(id = "breakdown-warranty-value")
    WebElement warrantyBreakdownValue;

    // Discount
    @FindBy(id = "discount-code")
    WebElement discountCodeField;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton;

    @FindBy(id = "discount-feedback")
    WebElement discountFeedback;

    @FindBy(id = "breakdown-discount-value")
    WebElement discountBreakdownValue;

    // Purchase
    @FindBy(id = "purchase-device-btn")
    WebElement purchaseDeviceButton;

    @FindBy(xpath = "//*[@id='purchase-success-toast']/div[1]/h4")
    WebElement purchaseSuccessToast;

    // Invoice history
    @FindBy(id = "view-history-btn")
    WebElement viewHistoryButton;

    @FindBy(id = "invoice-history-title")
    WebElement invoiceHistoryTitle;

    @FindBy(xpath = "//*[contains(@id,'view-invoice')]")
    WebElement viewInvoiceButton;

    @FindBy(xpath = "//*[contains(text(),'Invoice')]")
    WebElement invoiceDetailsLabel;

//   public inventoryFormPage(WebDriver driver) {this.driver = driver;}

   public void clickWebAutomationAdvanceTab(){
       webAutomationAdvanceTab.click();
   }
   public void verifyInventoryHeadingIsDisplayed(){
       inventoryHeading.isDisplayed();
   }
   public void selectDeviceType(String deviceType){
       Select select = new Select(deviceTypeDropdown);
       select.selectByVisibleText(deviceType);
   }
   public void selectBrand(String brand){
       Select select = new Select(brandDropdown);
       select.selectByVisibleText(brand);
   }

   public void verifyDevicePreviewImageIsDisplayed(){
       devicePreviewImage.isDisplayed();
   }

   public void selectStorageOption(String s){
       storage128GBOption.click();
   }

    public void verifyUnitPriceIsDisplayed(){
        unitPriceLabel.isDisplayed();
    }

   public void selectColor(String color){
       Select select = new Select(colorDropdown);
       select.selectByVisibleText(color);
   }
   public void selectQuantity(int quantity){
       quantityField.clear();
       quantityField.sendKeys(String.valueOf(quantity));
   }
   public void verifySubtotalIsDisplayed(){
       subtotalLabel.isDisplayed();
   }
    public void enterDeliveryAddress(String address){
         addressField.sendKeys(address);
    }
    public void clickNextButton(){
        nextButton.click();
    }
    public void verifyShippingSectionIsDisplayed(){
        shippingLabel.isDisplayed();
    }
    public void selectExpressShipping() {
        expressShippingOption.click();
    }
    public void verifyShippingBreakdownValueIsDisplayed() {
        shippingBreakdownValue.isDisplayed();
    }
    public void verifyWarrantySectionIsDisplayed() {
        warrantyLabel.isDisplayed();
    }
    public void selectOneYearWarranty() {
        oneYearWarrantyOption.click();
    }
    public void verifyWarrantyBreakdownValueIsDisplayed() {
        warrantyBreakdownValue.isDisplayed();
    }
    public void enterDiscountCode(String code) {
        discountCodeField.sendKeys(code);
    }
    public void clickApplyDiscount() {
        applyDiscountButton.click();
    }
    public void verifyDiscountFeedbackIsDisplayed() {
        discountFeedback.isDisplayed();
    }
    public void verifyDiscountBreakdownValueIsDisplayed() {
        discountBreakdownValue.isDisplayed();
    }
    public void clickPurchaseDevice() {
        purchaseDeviceButton.click();
    }
    public void verifyPurchaseSuccessToastIsDisplayed() {
        purchaseSuccessToast.isDisplayed();
    }
        public void clickViewHistory() {
            viewHistoryButton.click();
        }
        public void verifyInvoiceHistoryTitleIsDisplayed() {
            invoiceHistoryTitle.isDisplayed();
        }
        public void clickViewInvoice() {
            viewInvoiceButton.click();
        }
        public void verifyInvoiceDetailsLabelIsDisplayed() {
            invoiceDetailsLabel.isDisplayed();
        }









}
