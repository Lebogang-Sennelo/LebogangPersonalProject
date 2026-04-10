package Tests;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.InventoryFormPage;
import Pages.LoginPage;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("chrome", "https://ndosisimplifiedautomation.vercel.app/");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    DashboardPage dashBoardPage = PageFactory.initElements(driver, DashboardPage.class);
    InventoryFormPage inventoryFormPage = PageFactory.initElements(driver, InventoryFormPage.class);
}
