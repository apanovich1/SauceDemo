package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductCardPage;
import pages.ProductsPage;
import org.testng.ITestContext;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;

    LoginPage loginPage;

    ProductsPage productsPage;

    CartPage cartPage;

    ProductCardPage productCardPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Browser set up")
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        System.out.println(System.getProperty("hi"));
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            this.driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            driver = new FirefoxDriver(options);
        }
        testContext.setAttribute("driver", driver);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productCardPage = new ProductCardPage(driver);


    }

   @AfterMethod(alwaysRun = true, description = "Browser out")
    public void tearDown() {

        this.driver.quit();
    }
}
