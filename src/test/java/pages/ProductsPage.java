package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.lang.String;
import org.testng.Assert;
import tests.ProductsTest;

public class ProductsPage extends BasePage {


    private final By TITLE = By.cssSelector(".title");

    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']"
            + "/ancestor::*[@class='inventory_item']//button";

    private final By CART_LINK = By.id("shopping_cart_container");

    private final By PRODUCT_QUANTITY = By.cssSelector(".cart_quantity");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openInventory() {

        driver.get(BASE_URL + "inventory.html");
    }
    public String getTitle() {

        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String product) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }
    public void openCart() {

        driver.findElement(CART_LINK).click();
    }

    public String getQuantity() {
        return driver.findElement(PRODUCT_QUANTITY).getText();
    }

    /*public void titleShouldBe(String expectedTitle){
        Assert.assertEquals(driver.findElement(TITLE),
                "Products",
                "User is not logged in or wrong page is opened");

       public void addToCart(int index) {
            driver.findElement(By.xpath(""//*[text()='%s']"
            + "/ancestor::*[@class='inventory_item']//button"").get(index).click();
       }
    }*/
}
