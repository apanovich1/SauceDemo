import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.String;

public class LoginTest extends BaseTest{

    @Test
    public void loginHappyPath() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title= driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(title,"Products",
                "Login is unsuccessful");
    }

    @Test
    public void emptyEnter() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector(
                ".error-message-container")).getText();
        Assert.assertTrue(errorMessage.contains("Epic sadface: " +
                "Username is required"));
    }

    @Test
    public void emptyPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        String errorUsernameMessage = driver.findElement(By.cssSelector(
                ".error-message-container")).getText();
        Assert.assertTrue(errorUsernameMessage.contains("Epic sadface: " +
                "Password is required"));
    }


    @Test
    public void incorrectUsername() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String errorMessage= driver.findElement(By.cssSelector(".error-message-container")).getText();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username" +
                " and password do not match any user in this service"));
    }
}
