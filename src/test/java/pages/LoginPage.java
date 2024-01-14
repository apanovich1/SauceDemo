package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class LoginPage extends BasePage {
    //WebDriver driver = new ChromeDriver();

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");


    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @Step("Opening login page")
    public void open() {
        log.info("Opening login page");
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Login by {user}")
    public void login(String user, String password) {
        log.info("Login into saucedemo");
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getError() {
        log.info("Getting login error");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
