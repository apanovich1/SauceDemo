import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void buyProduct() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']" +
                "/ancestor::*[@class='inventory_item']//button")).click();
        //*[text()='Sauce Labs Bike Light']/ancestor::*[@class='inventory_item']//button
        driver.findElement(By.id("shopping_cart_container")).click();
        String productName= driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        Assert.assertEquals(productName,"Sauce Labs Bike Light",
                "Incorrect product in the cart");
    }
}
