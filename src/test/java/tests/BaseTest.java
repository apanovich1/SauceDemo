package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductCardPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;

    LoginPage loginPage;

    ProductsPage productsPage;

    CartPage cartPage;

    ProductCardPage productCard;
    @Parameters({"browser"})
    @BeforeMethod(description = "Browser set up")
    public void setUp(@Optional("chrome") String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            this.driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productCard = new ProductCardPage(driver);
    }

   @AfterMethod(alwaysRun = true, description = "Browser out")
    public void tearDown() {

        this.driver.quit();
    }
}
