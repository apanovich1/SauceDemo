package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.lang.String;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(description = "Product should be bought", retryAnalyzer = Retry.class)
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(productName, "Sauce Labs Backpack",
                "Wrong product has been added into the cart");
    }

    @Test(description = "Product should not be bought 2 times")
    public void buyProductTwoTime() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("add-to-cart-sauce-labs-backpack");
        productsPage.addToCart("add-to-cart-sauce-labs-backpack");
        productsPage.openCart();

        /*assertEquals(productsPage.getQuantity(), "1",
                "A user is able to add 2 same items in the cart");*/
    }

}